package ru.endroad.server.orders.data

import ru.endroad.server.orders.OrderApi
import ru.endroad.server.orders.entity.*
import ru.endroad.server.orders.model.OrderModel

class OrderListDataSource(
	private val orderApi: OrderApi,
) {

	suspend fun getList(employerId: Long): List<Order> =
		orderApi.getOrders().map(::convert)

	private fun convert(model: OrderModel): Order =
		Order(
			id = model.id,
			creatorId = model.creatorId,
			performer = model.getPerformer,
			createData = model.createData,
			deadline = model.deadline,
			titleText = model.titleText,
			priority = model.getPriority,
			orderType = model.getOrderType,
			orderStatus = model.getOrderStatus,
			bodyText = model.bodyText,
			attachment = null,
		)

	private val OrderModel.getOrderType: OrderType
		get() = OrderType.valueOf(orderType)

	//TODO
	private val OrderModel.getOrderStatus: OrderStatus
		get() = OrderStatus.New

	//TODO
	private val OrderModel.getPerformer: Performer
		get() = Performer.All

	private val OrderModel.getPriority: Priority
		get() = Priority.valueOf(priority)
}