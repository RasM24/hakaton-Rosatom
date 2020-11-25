package ru.endroad.rosatom.view.main

import androidx.fragment.app.Fragment
import ru.endroad.component.navigation.destination.FragmentDestination

class MainNavigationDestination(private val initialScreen: Int) : FragmentDestination {

	override fun createFragment(): Fragment =
		MainNavigationFragment.create(initialScreen)
}