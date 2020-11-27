package ru.endroad.rosatom.entity

sealed class Performer {
	object All : Performer()
	class Group(val groupName: String)
	class Employer(val employerProfile: Profile)
}