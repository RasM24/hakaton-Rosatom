package ru.endroad.rosatom.entity

data class Order(
	val orderId: Long,
	val creator: Profile,
	val executor: Profile,
	val createData: Long,
	val deadline: Long,
	val titleText: String,
	val bodyText: String,
)