package ru.endroad.rosatom.view.order.spectator

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import ru.endroad.component.common.MviViewModel
import ru.endroad.rosatom.domain.GetCompletedOrders
import ru.endroad.rosatom.domain.GetOpenOrders

class SpectatorOrderViewModel(
	private val getOpenOrders: GetOpenOrders,
	private val getCompletedOrders: GetCompletedOrders,
) : ViewModel(), MviViewModel<SpectatorOrderScreenState, SpectatorOrderScreenEvent> {

	override val state = MutableStateFlow<SpectatorOrderScreenState>(SpectatorOrderScreenState.Initialized)

	init {
		notice(SpectatorOrderScreenEvent.Load)
	}

	override fun notice(event: SpectatorOrderScreenEvent) {
		when (event) {
			is SpectatorOrderScreenEvent.Load -> viewModelScope.launch { reduce(event) }
		}
	}

	private suspend fun reduce(event: SpectatorOrderScreenEvent.Load) {
		val orderList = getOpenOrders()
		val completedOrders = getCompletedOrders()
		state.tryEmit(SpectatorOrderScreenState.ShowData(orderList + completedOrders))
	}
}