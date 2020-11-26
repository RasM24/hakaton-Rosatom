package ru.endroad.rosatom.view.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import ru.endroad.component.common.MviViewModel
import ru.endroad.rosatom.data.ProfileDataSource

class ProfileViewModel(
	private val profileDataSource: ProfileDataSource,
) : ViewModel(), MviViewModel<ProfileScreenState, ProfileScreenEvent> {

	override val state = MutableStateFlow<ProfileScreenState>(ProfileScreenState.Initialized)

	init {
		notice(ProfileScreenEvent.LoadProfile)
	}

	override fun notice(event: ProfileScreenEvent) {
		viewModelScope.launch {
			when (event) {
				is ProfileScreenEvent.LoadProfile -> state.tryEmit(event.reduce())
			}
		}
	}

	private suspend fun ProfileScreenEvent.LoadProfile.reduce(): ProfileScreenState {
		val profile = profileDataSource.get()
		return ProfileScreenState.Data(profile)
	}
}