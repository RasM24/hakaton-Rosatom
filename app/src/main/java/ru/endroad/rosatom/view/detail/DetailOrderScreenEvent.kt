package ru.endroad.rosatom.view.detail

sealed class DetailOrderScreenEvent {
	object Load : DetailOrderScreenEvent()
	object LoadSensor : DetailOrderScreenEvent()
}