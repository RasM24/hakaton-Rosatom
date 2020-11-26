package ru.endroad.rosatom.di

import org.koin.dsl.module
import org.koin.experimental.builder.single
import ru.endroad.rosatom.data.ProfileDataSource
import ru.endroad.rosatom.data.SensorsDataSource

val dataModule = module {

	single<ProfileDataSource>()
	single<SensorsDataSource>()
}