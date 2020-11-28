package ru.endroad.rosatom.view.order

import ru.endroad.server.orders.entity.Order

sealed class SpectatorOrderScreenState {
	object Initialized : SpectatorOrderScreenState()
	class ShowData(val orders: List<Order>) : SpectatorOrderScreenState()
}