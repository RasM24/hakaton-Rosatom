package ru.endroad.rosatom.data

import ru.endroad.rosatom.entity.Sensor
import ru.endroad.rosatom.entity.SensorData

class SensorsDataSource {

	private val mockSensorTemperature1 = SensorData(22f, null, 60f, Sensor.TEMPERATURE)
	private val mockSensorTemperature2 = SensorData(35f, 20f, 60f, Sensor.TEMPERATURE)
	private val mockSensorPressure1 = SensorData(101f, 80f, 140f, Sensor.PRESSURE)
	private val mockSensorPressure2 = SensorData(1183f, 800f, null, Sensor.PRESSURE)
	private val mockSensorLight = SensorData(453f, 300f, null, Sensor.LIGHT)
	private val mockSensorOxygen = SensorData(1358f, null, 1800f, Sensor.OXYGEN)

	suspend fun getList(): List<SensorData> =
		listOf(
			mockSensorTemperature1,
			mockSensorTemperature2,
			mockSensorPressure1,
			mockSensorLight,
			mockSensorOxygen,
			mockSensorPressure2,
		)
}