package ru.endroad.server.voice.data

import android.os.Environment
import java.io.File

class AudioRecordingDataSource {

	private val audioFile: File = File(Environment.getExternalStorageDirectory().absolutePath + "/record")

	fun get(): File = audioFile

	fun prepareFile(): File {
		audioFile.deleteOnExit()
		audioFile.createNewFile()

		return audioFile
	}

	fun clear() {
		audioFile.deleteOnExit()
	}
}