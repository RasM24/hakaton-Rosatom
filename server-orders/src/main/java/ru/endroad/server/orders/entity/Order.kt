package ru.endroad.server.orders.entity

import java.io.File

data class Order(
	val id: Long,
	val creatorId: Long,
	val performer: Performer,
	val createData: Long,
	val deadline: Long,
	val titleText: String,
	val priority: Priority,
	val orderType: OrderType,
	val orderStatus: OrderStatus,
	val bodyText: String,
	val attachment: File? = null,
)