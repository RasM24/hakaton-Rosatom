package ru.endroad.rosatom.view.order.draft

sealed class DraftOrderScreenEvent {

	object StartSpeak : DraftOrderScreenEvent()
	object StopSpeak : DraftOrderScreenEvent()
	object SendAudioFile : DraftOrderScreenEvent()
	object Create: DraftOrderScreenEvent()
}