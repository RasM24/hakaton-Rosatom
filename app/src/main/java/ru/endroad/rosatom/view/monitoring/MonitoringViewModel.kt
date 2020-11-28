package ru.endroad.rosatom.view.monitoring

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import ru.endroad.component.common.MviViewModel
import ru.endroad.rosatom.data.SensorsDataSource
import ru.endroad.rosatom.entity.SensorData
import ru.endroad.rosatom.entity.isAlert
import ru.endroad.rosatom.router.PushRouting

class MonitoringViewModel(
	private val sensorsDataSource: SensorsDataSource,
	private val router: PushRouting,
) : ViewModel(), MviViewModel<MonitoringScreenState, MonitoringScreenEvent> {

	private var alertSent = false

	override val state = MutableStateFlow<MonitoringScreenState>(MonitoringScreenState.Initialized)

	init {
		viewModelScope.launch {
			while (true) {
				delay(1000)
				notice(MonitoringScreenEvent.FetchData)
			}
		}
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

		if (!alertSent && sensorDataList.any(SensorData::isAlert)) {
			val message = sensorDataList
				.find(SensorData::isAlert)
				.let(::requireNotNull)
				.let { "Критическое значение датчика ${it.type}: ${it.value}" }

			router.sendNotification("Внимание!", message, "")
			alertSent = true
		}

		return MonitoringScreenState.Data(sensorDataList)
	}
}