package ru.endroad.rosatom.view.order

import kotlinx.android.synthetic.main.order_list_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.endroad.component.common.MviFragment
import ru.endroad.rosatom.R
import ru.endroad.rosatom.view.order.adapter.SpectatorOrdersAdapter

class SpectatorOrderFragment : MviFragment<SpectatorOrderScreenState, SpectatorOrderScreenEvent>() {

	override val viewModel by viewModel<SpectatorOrderViewModel>()
	override val layout = R.layout.order_list_fragment

	private val adapter = SpectatorOrdersAdapter()

	override fun setupViewComponents() {
		setToolbarText(getString(R.string.tab_navigation_order_draft))
		order_list.adapter = adapter
	}

	override fun render(state: SpectatorOrderScreenState) {
		when (state) {
			SpectatorOrderScreenState.Initialized -> Unit
			is SpectatorOrderScreenState.ShowData -> adapter.items = state.orders
		}
	}
}