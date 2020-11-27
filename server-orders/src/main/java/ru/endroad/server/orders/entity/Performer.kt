package ru.endroad.server.orders.entity

sealed class Performer {
	object All : Performer()
	class Group(val groupName: String)
	class Employer(val employerId: Long)
}