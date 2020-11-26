package ru.endroad.rosatom.view.profile

import kotlinx.android.synthetic.main.profile_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.endroad.component.common.MviFragment
import ru.endroad.rosatom.R

class ProfileFragment : MviFragment<ProfileScreenState, ProfileScreenEvent>() {

	override val layout = R.layout.profile_fragment
	override val viewModel by viewModel<ProfileViewModel>()

	override fun setupViewComponents() {
		setToolbarText(getString(R.string.tab_navigation_profile))
	}

	override fun render(state: ProfileScreenState) {
		when (state) {
			ProfileScreenState.Initialized -> Unit
			is ProfileScreenState.Data -> render(state)
		}
	}

	private fun render(state: ProfileScreenState.Data) {
		profile_name.text = state.profile.name
		profile_position.text = state.profile.position
	}
}