package ru.endroad.rosatom.data

import ru.endroad.rosatom.entity.Profile

class ProfileDataSource {

	private val mockData = Profile(1, "Дволятик Олег", "Инженер-программист")

	suspend fun get(): Profile =
		mockData
}