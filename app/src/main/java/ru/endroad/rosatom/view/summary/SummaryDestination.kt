package ru.endroad.rosatom.view.summary

import androidx.fragment.app.Fragment
import ru.endroad.component.navigation.destination.FragmentDestination

object SummaryDestination : FragmentDestination {

	override fun createFragment(): Fragment =
		SummaryFragment()
}