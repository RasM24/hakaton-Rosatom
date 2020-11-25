package ru.endroad.component.navigation.destination

import androidx.fragment.app.Fragment

interface FragmentDestination : Destination {

	fun createFragment(): Fragment
}