package ru.endroad.rosatom.view.order

import androidx.fragment.app.Fragment
import ru.endroad.component.navigation.destination.FragmentDestination

object DraftOrderDestination : FragmentDestination {

	override fun createFragment(): Fragment =
		DraftOrderFragment()
}