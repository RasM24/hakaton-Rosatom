package ru.endroad.rosatom.view.order

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import ru.endroad.component.common.MviViewModel
import ru.endroad.rosatom.entity.DraftOrder
import ru.endroad.rosatom.entity.Profile

class DraftOrderViewModel : ViewModel(), MviViewModel<DraftOrderScreenState, DraftOrderScreenEvent> {

	private val sampleDraft = DraftOrder(
		orderId = 1,
		creator = Profile("Дволятик Олег", ""),
		executor = Profile("Иван Петров", ""),
		createData = 89492879139,
		deadline = "29.11.2020",
		titleText = "План ПХД",
		bodyText = "Составить презентацию о планировании хозяйственной деятельности отдела Петрова на 2021год",
	)

	override val state = MutableStateFlow<DraftOrderScreenState>(DraftOrderScreenState.RecognitionData(sampleDraft))

	override fun notice(event: DraftOrderScreenEvent) {
		viewModelScope.launch {
			when (event) {
				DraftOrderScreenEvent.Speak -> TODO()
			}
		}
	}
}