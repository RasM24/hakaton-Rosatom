package ru.endroad.rosatom.entity

sealed class OrderStatus {
	object New : OrderStatus()
	object Read : OrderStatus()
	object InProgress : OrderStatus()
	class Complete(val dateOfCompletion: Long) : OrderStatus()
}
