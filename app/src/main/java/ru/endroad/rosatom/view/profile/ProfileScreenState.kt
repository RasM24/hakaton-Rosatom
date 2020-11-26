package ru.endroad.rosatom.view.profile

import ru.endroad.rosatom.entity.Profile

sealed class ProfileScreenState {

	object Initialized : ProfileScreenState()
	class Data(val profile: Profile) : ProfileScreenState()
}