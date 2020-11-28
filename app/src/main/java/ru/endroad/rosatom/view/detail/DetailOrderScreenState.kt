package ru.endroad.rosatom.view.detail

import ru.endroad.server.orders.entity.Order

sealed class DetailOrderScreenState {

	object Initialized : DetailOrderScreenState()
	class Data(val order: Order) : DetailOrderScreenState()
}