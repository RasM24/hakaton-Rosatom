package ru.endroad.rosatom.view.monitoring

sealed class MonitoringScreenEvent {

	object FetchData : MonitoringScreenEvent()
}