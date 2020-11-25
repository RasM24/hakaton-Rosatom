package ru.endroad.rosatom.view.monitoring

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import ru.endroad.component.common.MviViewModel

class MonitoringViewModel : ViewModel(), MviViewModel<MonitoringScreenState, MonitoringScreenEvent> {

	override val state = MutableStateFlow<MonitoringScreenState>(MonitoringScreenState.Initialized)

	init {
		notice(MonitoringScreenEvent.FetchData)
	}

	override fun notice(event: MonitoringScreenEvent) {
		viewModelScope.launch {
			when (event) {
				is MonitoringScreenEvent.FetchData -> Unit
			}
		}
	}
}