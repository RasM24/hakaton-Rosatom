package ru.endroad.server.voice.data

import okhttp3.MediaType
import okhttp3.RequestBody
import ru.endroad.server.voice.api.VoiceApi
import java.io.File

class VoiceRecognitionDataSource(private val api: VoiceApi) {

	suspend fun recognize(file: File): String {
		val requestBody: RequestBody = RequestBody.create(MediaType.parse("audio/wav"), file)

		return api.recognizeAudio(requestBody).text
	}
}