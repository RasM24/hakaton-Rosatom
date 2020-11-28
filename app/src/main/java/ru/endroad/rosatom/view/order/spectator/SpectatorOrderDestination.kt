package ru.endroad.rosatom.view.order.spectator

import androidx.fragment.app.Fragment
import ru.endroad.component.navigation.destination.FragmentDestination

object SpectatorOrderDestination : FragmentDestination {

	override fun createFragment(): Fragment =
		SpectatorOrderFragment()
}