package ru.endroad.rosatom.view.order

import ru.endroad.server.orders.entity.Order

sealed class ListOrderScreenState {
	object Initialized : ListOrderScreenState()
	class ShowData(val orders: List<Order>) : ListOrderScreenState()
}