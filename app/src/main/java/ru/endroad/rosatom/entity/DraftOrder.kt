package ru.endroad.rosatom.entity

data class DraftOrder(
	val orderId: Long?,
	val creator: Profile?,
	val executor: Profile?,
	val createData: Long?,
	val deadline: String?,
	val titleText: String?,
	val bodyText: String?,
)