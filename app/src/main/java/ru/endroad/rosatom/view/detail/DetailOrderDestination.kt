package ru.endroad.rosatom.view.detail

import androidx.fragment.app.Fragment
import ru.endroad.component.navigation.destination.FragmentDestination

object DetailOrderDestination : FragmentDestination {

	override fun createFragment(): Fragment =
		DetailOrderFragment()
}