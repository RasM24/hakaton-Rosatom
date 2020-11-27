package ru.endroad.rosatom.entity

import java.io.File

data class Order(
	val id: Long,
	val creator: Profile,
	val performer: Performer,
	val createData: Long,
	val deadline: Long,
	val titleText: String,
	val priority: Priority,
	val orderType: OrderType,
	val orderStatus: OrderStatus,
	val bodyText: String,
	val attachment: File?,
)