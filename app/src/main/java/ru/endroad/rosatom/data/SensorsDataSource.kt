package ru.endroad.rosatom.data

import ru.endroad.rosatom.entity.Sensor
import ru.endroad.rosatom.entity.SensorData
import kotlin.random.Random

class SensorsDataSource {

	private val mockSensorTemperature1
		get() = SensorData(rand(40.0, 59.0), null, 60f, Sensor.TEMPERATURE)
	private val mockSensorTemperature2
		get() = SensorData(rand(21.0, 59.0), 20f, 60f, Sensor.TEMPERATURE)
	private val mockSensorPressure1
		get() = SensorData(rand(81.0, 145.0), 80f, 140f, Sensor.PRESSURE)
	private val mockSensorPressure2
		get() = SensorData(rand(801.0, 1183.0), 800f, null, Sensor.PRESSURE)
	private val mockSensorLight
		get() = SensorData(rand(301.0, 453.0), 300f, null, Sensor.LIGHT)
	private val mockSensorOxygen
		get() = SensorData(rand(1000.0, 1799.0), null, 1800f, Sensor.OXYGEN)

	private val random = Random(1451)
	private fun rand(from: Double, to: Double): Float =
		random.nextDouble(from, to).toFloat()

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