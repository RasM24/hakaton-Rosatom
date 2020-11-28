package ru.endroad.rosatom.view.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import ru.endroad.component.common.MviViewModel
import ru.endroad.server.orders.data.OrderListDataSource
import ru.endroad.server.orders.entity.*

class DetailOrderViewModel(
	private val orderId: Long,
	private val ordersDataSource: OrderListDataSource,
) : ViewModel(), MviViewModel<DetailOrderScreenState, DetailOrderScreenEvent> {

	override val state = MutableStateFlow<DetailOrderScreenState>(DetailOrderScreenState.Initialized)

	init {
		if (orderId == -1L) {
			notice(DetailOrderScreenEvent.LoadSensor)
		} else {
			notice(DetailOrderScreenEvent.Load)
		}
	}

	override fun notice(event: DetailOrderScreenEvent) {
		viewModelScope.launch {
			when (event) {
				is DetailOrderScreenEvent.Load -> reduce(event)
				DetailOrderScreenEvent.LoadSensor -> loadMockSensor()
			}
		}
	}

	private suspend fun reduce(event: DetailOrderScreenEvent.Load) {
		ordersDataSource.getList(0)
			.find { it.id == orderId }
			?.let(DetailOrderScreenState::Data)
			?.let(state::tryEmit)
	}

	private fun loadMockSensor() {
		val data = Order(
			id = 1,
			creatorId = 2,
			performer = Performer.All,
			createData = 1,
			deadline = 2,
			titleText = "Критические показания датчика",
			priority = Priority.CRITICAL,
			orderType = OrderType.TECHNICAL,
			orderStatus = OrderStatus.New,
			bodyText = "Датчик давления показал значения выше критических.\nТекущее значение:143КПа.\nМаксимально допустимое: 140Кпа.",
		)

		state.tryEmit(DetailOrderScreenState.Data(data))
	}
}