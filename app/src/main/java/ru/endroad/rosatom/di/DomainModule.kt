package ru.endroad.rosatom.di

import org.koin.dsl.module
import org.koin.experimental.builder.single
import ru.endroad.rosatom.domain.GetCompletedOrders
import ru.endroad.rosatom.domain.GetOpenOrders

val domainModule = module {

	single<GetCompletedOrders>()
	single<GetOpenOrders>()
}