package ru.endroad.component.navigation.destination

import android.content.Intent

interface SystemDestination : Destination {

	fun createIntent(): Intent
}