package ru.endroad.server.voice.data

import android.media.MediaRecorder

class RecorderInteractor(
	private val audioRecordingDataSource: AudioRecordingDataSource
) {

	private var mediaRecorder = MediaRecorder()

	fun record() {
		val file = audioRecordingDataSource.prepareFile()

		mediaRecorder.release()
		mediaRecorder = MediaRecorder()
		mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC)
		mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4)
		mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AAC)
		mediaRecorder.setOutputFile(file)
		mediaRecorder.prepare()
		mediaRecorder.start()
	}

	fun stop() {
		mediaRecorder.stop()
	}
}