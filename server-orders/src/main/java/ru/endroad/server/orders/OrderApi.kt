package ru.endroad.server.orders

import retrofit2.http.GET
import ru.endroad.server.orders.entity.Order
import ru.endroad.server.orders.model.OrderModel

interface OrderApi {

	@GET("/orders")
	suspend fun getOrders(): List<OrderModel>
}