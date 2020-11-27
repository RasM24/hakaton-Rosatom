package ru.endroad.rosatom.view.order

sealed class DraftOrderScreenEvent {

	object StartSpeak : DraftOrderScreenEvent()
	object StopSpeak : DraftOrderScreenEvent()
	object SendAudioFile : DraftOrderScreenEvent()
}