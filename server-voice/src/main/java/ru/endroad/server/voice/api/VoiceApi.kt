package ru.endroad.server.voice.api

import retrofit2.http.POST

interface VoiceApi {

	@POST("/audio-command")
	suspend fun recognizeAudio(): String
}