package ru.endroad.rosatom.view.order.list

import kotlinx.android.synthetic.main.order_list_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.endroad.component.common.MviFragment
import ru.endroad.rosatom.R
import ru.endroad.rosatom.view.order.adapter.OrdersAdapter

class ListOrderFragment : MviFragment<ListOrderScreenState, ListOrderScreenEvent>() {

	override val viewModel by viewModel<ListOrderViewModel>()
	override val layout = R.layout.order_list_fragment

	private val adapter = OrdersAdapter(
		onOrderClick = { id -> viewModel.notice(ListOrderScreenEvent.OrderClick(id.id)) }
	)

	override fun setupViewComponents() {
		setToolbarText(getString(R.string.tab_navigation_order_list))
		order_list.adapter = adapter
	}

	override fun render(state: ListOrderScreenState) {
		when (state) {
			ListOrderScreenState.Initialized -> Unit
			is ListOrderScreenState.ShowData -> adapter.items = state.orders
		}
	}
}