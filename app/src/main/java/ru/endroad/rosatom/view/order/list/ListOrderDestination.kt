package ru.endroad.rosatom.view.order.list

import androidx.fragment.app.Fragment
import ru.endroad.component.navigation.destination.FragmentDestination

object ListOrderDestination : FragmentDestination {

	override fun createFragment(): Fragment =
		ListOrderFragment()
}