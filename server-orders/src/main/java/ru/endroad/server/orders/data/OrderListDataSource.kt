package ru.endroad.server.orders.data

import ru.endroad.server.orders.OrderApi
import ru.endroad.server.orders.entity.*

class OrderListDataSource(
	private val orderApi: OrderApi,
) {
asdfasd
	private val hardcode = listOf(
		Order(1, 1, Performer.All, 0, 0, "title", Priority.CRITICAL, OrderType.COMMON, OrderStatus.InProgress, ""),
		Order(1, 1, Performer.All, 0, 0, "title", Priority.HIGH, OrderType.COMMON, OrderStatus.Read, ""),
		Order(1, 1, Performer.All, 0, 0, "title", Priority.LOW, OrderType.TECHNOLOGICAL, OrderStatus.InProgress, ""),
		Order(1, 1, Performer.All, 0, 0, "title", Priority.HIGH, OrderType.COMMON, OrderStatus.New, ""),
		Order(1, 1, Performer.All, 0, 0, "title", Priority.MEDIUM, OrderType.TECHNICAL, OrderStatus.InProgress, ""),
	)

	suspend fun getList(employerId: Long): List<Order> =
		hardcode
}