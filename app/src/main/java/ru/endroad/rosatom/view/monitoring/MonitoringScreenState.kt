package ru.endroad.rosatom.view.monitoring

import ru.endroad.rosatom.entity.SensorData

sealed class MonitoringScreenState {

	object Initialized : MonitoringScreenState()
	class Data(val sensorDataList: List<SensorData>) : MonitoringScreenState()
}