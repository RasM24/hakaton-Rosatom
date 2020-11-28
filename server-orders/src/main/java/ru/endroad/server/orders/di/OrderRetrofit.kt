package ru.endroad.server.orders.di

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val SERVER_URL = "http://95.31.10.133:8090/"

internal fun getRetrofit(): Retrofit =
	Retrofit.Builder()
		.baseUrl(SERVER_URL)
		.addConverterFactory(GsonConverterFactory.create())
		.build()
