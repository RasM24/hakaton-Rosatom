package ru.endroad.rosatom.view.monitoring

import androidx.fragment.app.Fragment
import ru.endroad.component.navigation.destination.FragmentDestination

object MonitoringDestination : FragmentDestination {

	override fun createFragment(): Fragment =
		MonitoringFragment()
}