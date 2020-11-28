package ru.endroad.rosatom.view.order.list

sealed class ListOrderScreenEvent {
	object Load : ListOrderScreenEvent()
	class OrderClick(val id: Long) : ListOrderScreenEvent()
}