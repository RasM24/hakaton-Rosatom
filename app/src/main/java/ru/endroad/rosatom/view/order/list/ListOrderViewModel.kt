package ru.endroad.rosatom.view.order.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import ru.endroad.component.common.MviViewModel
import ru.endroad.rosatom.domain.GetOpenOrders

class ListOrderViewModel(
	private val getOpenOrders: GetOpenOrders,
) : ViewModel(), MviViewModel<ListOrderScreenState, ListOrderScreenEvent> {

	override val state = MutableStateFlow<ListOrderScreenState>(ListOrderScreenState.Initialized)

	init {
		notice(ListOrderScreenEvent.Load)
	}

	override fun notice(event: ListOrderScreenEvent) {
		when (event) {
			is ListOrderScreenEvent.Load -> viewModelScope.launch { reduce(event) }
		}
	}

	private suspend fun reduce(event: ListOrderScreenEvent.Load) {
		val orderList = getOpenOrders()
		state.tryEmit(ListOrderScreenState.ShowData(orderList))
	}
}