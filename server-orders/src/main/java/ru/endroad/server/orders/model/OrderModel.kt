package ru.endroad.server.orders.model

data class OrderModel(
	val id: Long,
	val creatorId: Long,
	val performer: String,
	val createData: Long,
	val deadline: Long,
	val titleText: String,
	val priority: String,
	val orderType: String,
	val orderStatus: String,
	val bodyText: String,
)