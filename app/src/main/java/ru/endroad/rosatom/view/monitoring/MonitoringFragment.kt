package ru.endroad.rosatom.view.monitoring

import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.endroad.component.common.MviFragment
import ru.endroad.rosatom.R

class MonitoringFragment : MviFragment<MonitoringScreenState, MonitoringScreenEvent>() {

	override val layout = R.layout.monitoring_fragment
	override val viewModel by viewModel<MonitoringViewModel>()

	override fun setupViewComponents() {
		setToolbarText(getString(R.string.tab_navigation_monitoring))
	}

	override fun render(state: MonitoringScreenState) {
		when (state) {
			MonitoringScreenState.Initialized -> Unit
			is MonitoringScreenState.Data -> render(state)
		}
	}

	private fun render(state: MonitoringScreenState.Data) = Unit
}