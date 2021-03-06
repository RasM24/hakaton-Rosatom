package ru.endroad.rosatom.view.order.draft

import ru.endroad.rosatom.entity.DraftOrder

sealed class DraftOrderScreenState {

	object Initialized : DraftOrderScreenState()
	object StopRecording : DraftOrderScreenState()
	class RecognitionData(val draftOrder: DraftOrder) : DraftOrderScreenState()
	object Recording : DraftOrderScreenState()
}