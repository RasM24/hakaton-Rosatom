package ru.endroad.rosatom.domain

import ru.endroad.rosatom.data.ProfileDataSource
import ru.endroad.server.orders.data.OrderListDataSource
import ru.endroad.server.orders.entity.OrderStatus

class GetCompletedOrders(
	private val profileDataSource: ProfileDataSource,
	private val orderListDataSource: OrderListDataSource,
) {

	//TODO
	suspend operator fun invoke() =
		orderListDataSource.getList(profileDataSource.get().id)
			.filter { it.orderStatus is OrderStatus.Complete }
}