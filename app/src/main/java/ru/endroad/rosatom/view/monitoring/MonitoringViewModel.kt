package ru.endroad.rosatom.view.monitoring

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import ru.endroad.component.common.MviViewModel
import ru.endroad.rosatom.data.SensorsDataSource

class MonitoringViewModel(
	private val sensorsDataSource: SensorsDataSource,
) : ViewModel(), MviViewModel<MonitoringScreenState, MonitoringScreenEvent> {

	override val state = MutableStateFlow<MonitoringScreenState>(MonitoringScreenState.Initialized)

	init {
		notice(MonitoringScreenEvent.FetchData)
	}

	override fun notice(event: MonitoringScreenEvent) {
		viewModelScope.launch {
			when (event) {
				is MonitoringScreenEvent.FetchData -> state.tryEmit(event.reduce())
			}
		}
	}

	private suspend fun MonitoringScreenEvent.FetchData.reduce(): MonitoringScreenState {
		val sensorDataList = sensorsDataSource.getList()
		return MonitoringScreenState.Data(sensorDataList)
	}
}