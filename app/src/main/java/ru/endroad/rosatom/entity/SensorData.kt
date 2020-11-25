package ru.endroad.rosatom.entity

data class SensorData(val value: Float, val thresholdMin: Float?, val thresholdMax: Float?, val type: Sensor)