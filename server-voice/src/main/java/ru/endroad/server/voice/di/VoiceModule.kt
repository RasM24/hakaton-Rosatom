package ru.endroad.server.voice.di

import org.koin.dsl.module
import org.koin.experimental.builder.single
import retrofit2.Retrofit
import retrofit2.create
import ru.endroad.server.voice.api.VoiceApi
import ru.endroad.server.voice.data.AudioRecordingDataSource
import ru.endroad.server.voice.data.RecorderInteractor
import ru.endroad.server.voice.data.VoiceRecognitionDataSource

val voiceModule = module {
	single { getVoiceRetrofit() }
	single { get<Retrofit>().create<VoiceApi>() }

	single<AudioRecordingDataSource>()
	single<VoiceRecognitionDataSource>()
	single<RecorderInteractor>()
}