package ru.endroad.rosatom.data

import ru.endroad.rosatom.entity.Profile

class ProfileDataSource {

	private val mockData = Profile("Дволятик Олег", "Инженер-программист")

	suspend fun get(): Profile =
		mockData
}