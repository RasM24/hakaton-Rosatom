package ru.endroad.server.voice.api

import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.POST
import ru.endroad.server.voice.model.RecognitionResult

interface VoiceApi {

	@POST("/audio-command")
	suspend fun recognizeAudio(@Body requestBody: RequestBody): RecognitionResult
}