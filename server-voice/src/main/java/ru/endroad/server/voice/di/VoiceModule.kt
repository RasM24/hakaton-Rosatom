package ru.endroad.server.voice.di

import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.create
import ru.endroad.server.voice.api.VoiceApi

val voiceModule = module {

	single { getVoiceRetrofit() }
	single { get<Retrofit>().create<VoiceApi>() }
}