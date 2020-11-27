package ru.endroad.server.orders.di

import org.koin.dsl.module

val ordersModule = module {
	single { getRetrofit() }
}