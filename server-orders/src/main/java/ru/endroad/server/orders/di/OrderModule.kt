package ru.endroad.server.orders.di

import org.koin.core.qualifier.named
import org.koin.dsl.module
import org.koin.experimental.builder.single
import retrofit2.Retrofit
import retrofit2.create
import ru.endroad.server.orders.OrderApi
import ru.endroad.server.orders.data.OrderListDataSource

private val commonQualifier = named("CommonQualifier")

val ordersModule = module {
	single(commonQualifier) { getRetrofit() }
	single { get<Retrofit>(commonQualifier).create<OrderApi>() }

	single<OrderListDataSource>()
}