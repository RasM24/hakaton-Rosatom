package ru.endroad.rosatom.entity

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import ru.endroad.rosatom.R

enum class Sensor(@StringRes val sensorName: Int, @DrawableRes val iconRes: Int, @StringRes val measureRes: Int) {
	OXYGEN(R.string.sensor_name_oxygen, R.drawable.ic_sensor_oxygen, R.string.sensor_measure_oxygen),
	LIGHT(R.string.sensor_name_light, R.drawable.ic_sensor_light, R.string.sensor_measure_light),
	TEMPERATURE(R.string.sensor_name_temperature, R.drawable.ic_senser_temperature, R.string.sensor_measure_temperature),
	PRESSURE(R.string.sensor_name_pressure, R.drawable.ic_sensor_pressure, R.string.sensor_measure_pressure),
}