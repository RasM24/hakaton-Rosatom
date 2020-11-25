package ru.endroad.rosatom.view.monitoring

import androidx.recyclerview.widget.StaggeredGridLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager.VERTICAL
import kotlinx.android.synthetic.main.monitoring_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.endroad.component.common.MviFragment
import ru.endroad.rosatom.R
import ru.endroad.rosatom.view.monitoring.widget.WidgetAdapter
import ru.endroad.rosatom.view.monitoring.widget.WidgetItem

class MonitoringFragment : MviFragment<MonitoringScreenState, MonitoringScreenEvent>() {

	override val layout = R.layout.monitoring_fragment
	override val viewModel by viewModel<MonitoringViewModel>()
	private val adapter: WidgetAdapter = WidgetAdapter()
	private val layoutManager: StaggeredGridLayoutManager
		get() = StaggeredGridLayoutManager(2, VERTICAL)

	override fun setupViewComponents() {
		setToolbarText(getString(R.string.tab_navigation_monitoring))
		widget_list.adapter = adapter
		widget_list.layoutManager = layoutManager
	}

	override fun render(state: MonitoringScreenState) {
		when (state) {
			MonitoringScreenState.Initialized -> Unit
			is MonitoringScreenState.Data -> render(state)
		}
	}

	private fun render(state: MonitoringScreenState.Data) {
		adapter.items = state.sensorDataList.map(::WidgetItem)
	}
}