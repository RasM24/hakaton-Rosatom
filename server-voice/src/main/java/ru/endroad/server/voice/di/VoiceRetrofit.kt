package ru.endroad.server.voice.di

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val SERVER_URL = "https://rca-audio.herokuapp.com/"

fun getVoiceRetrofit(): Retrofit =
	Retrofit.Builder()
		.baseUrl(SERVER_URL)
		.addConverterFactory(GsonConverterFactory.create())
		.build()
