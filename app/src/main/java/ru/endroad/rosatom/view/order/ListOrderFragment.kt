package ru.endroad.rosatom.view.order

import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.endroad.component.common.MviFragment
import ru.endroad.rosatom.R

class ListOrderFragment : MviFragment<ListOrderScreenState, ListOrderScreenEvent>() {

	override val viewModel by viewModel<ListOrderViewModel>()
	override val layout = R.layout.order_list_fragment

	override fun setupViewComponents() {
		setToolbarText(getString(R.string.tab_navigation_order_draft))
	}

	override fun render(state: ListOrderScreenState) {
		when (state) {
			ListOrderScreenState.Initialized -> Unit
			is ListOrderScreenState.ShowData -> TODO()
		}
	}
}