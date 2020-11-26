package ru.endroad.rosatom.view.order

import ru.endroad.rosatom.entity.DraftOrder

sealed class DraftOrderScreenState {

	object Initialized : DraftOrderScreenState()
	class RecognitionData(val draftOrder: DraftOrder) : DraftOrderScreenState()
	object Recording : DraftOrderScreenState()
}