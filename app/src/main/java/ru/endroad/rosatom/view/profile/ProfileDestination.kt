package ru.endroad.rosatom.view.profile

import androidx.fragment.app.Fragment
import ru.endroad.component.navigation.destination.FragmentDestination

object ProfileDestination : FragmentDestination {

	override fun createFragment(): Fragment =
		ProfileFragment()
}