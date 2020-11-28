package ru.endroad.rosatom.view.order

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import ru.endroad.component.common.MviViewModel
import ru.endroad.rosatom.entity.DraftOrder
import ru.endroad.rosatom.entity.Profile
import ru.endroad.server.voice.data.AudioRecordingDataSource
import ru.endroad.server.voice.data.RecorderInteractor
import ru.endroad.server.voice.data.VoiceRecognitionDataSource

class DraftOrderViewModel(
	private val recorderInteractor: RecorderInteractor,
	private val audioRecordingDataSource: AudioRecordingDataSource,
	private val voiceRecognitionDataSource: VoiceRecognitionDataSource,
) : ViewModel(), MviViewModel<DraftOrderScreenState, DraftOrderScreenEvent> {

	private val sampleDraft = DraftOrder(
		orderId = 1,
		creator = Profile(1,"Дволятик Олег", ""),
		executor = Profile(2, "Иван Петров", ""),
		createData = 89492879139,
		deadline = "29.11.2020",
		titleText = "План ПХД",
	)

	override val state = MutableStateFlow<DraftOrderScreenState>(DraftOrderScreenState.RecognitionData(sampleDraft))

	override fun notice(event: DraftOrderScreenEvent) {
		viewModelScope.launch {
			when (event) {
				is DraftOrderScreenEvent.StartSpeak -> reduce(event)
				is DraftOrderScreenEvent.StopSpeak -> reduce(event)
				is DraftOrderScreenEvent.SendAudioFile -> viewModelScope.launch { reduce(event) }
			}
		}
	}

	private fun reduce(event: DraftOrderScreenEvent.StartSpeak) {
		recorderInteractor.record()
		state.tryEmit(DraftOrderScreenState.Recording)
	}

	private fun reduce(event: DraftOrderScreenEvent.StopSpeak) {
		recorderInteractor.stop()
		state.tryEmit(DraftOrderScreenState.Initialized)
		notice(DraftOrderScreenEvent.SendAudioFile)
	}

	private suspend fun reduce(event: DraftOrderScreenEvent.SendAudioFile) {
		val audioFile = audioRecordingDataSource.get()
		val text = voiceRecognitionDataSource.recognize(audioFile)
		val draft = DraftOrder(bodyText = text)
		audioRecordingDataSource.clear()
		state.tryEmit(DraftOrderScreenState.RecognitionData(draft))
	}
}