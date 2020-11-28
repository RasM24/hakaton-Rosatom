package ru.endroad.rosatom.view.detail

import androidx.fragment.app.Fragment
import ru.endroad.component.navigation.destination.FragmentDestination

class DetailOrderDestination(private val orderId: Long) : FragmentDestination {

	override fun createFragment(): Fragment =
		DetailOrderFragment.createFragment(orderId)
}