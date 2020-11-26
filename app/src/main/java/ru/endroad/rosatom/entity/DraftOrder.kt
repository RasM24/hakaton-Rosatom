package ru.endroad.rosatom.entity

data class DraftOrder(
	val orderId: Long? = null,
	val creator: Profile? = null,
	val executor: Profile? = null,
	val createData: Long? = null,
	val deadline: String? = null,
	val titleText: String? = null,
	val bodyText: String? = null,
)