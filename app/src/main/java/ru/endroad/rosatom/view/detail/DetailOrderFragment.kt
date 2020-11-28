package ru.endroad.rosatom.view.detail

import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.order_draft_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf
import ru.endroad.component.common.MviFragment
import ru.endroad.component.common.withArguments
import ru.endroad.rosatom.R
import ru.endroad.rosatom.view.main.MainNavigationFragment
import ru.endroad.rosatom.view.order.DraftOrderScreenEvent

class DetailOrderFragment : MviFragment<DetailOrderScreenState, DetailOrderScreenEvent>() {

	companion object {

		private const val ORDER_ID = "ORDER_ID"

		fun createFragment(orderId: Long): Fragment =
			DetailOrderFragment().withArguments(
				ORDER_ID to orderId
			)
	}

	private val orderId: Long
		get() = requireArguments().getLong(ORDER_ID)

	override val viewModel by viewModel<DetailOrderViewModel> { parametersOf(orderId) }
	override val layout = R.layout.order_detail_fragment

	override fun setupViewComponents() {
		setToolbarText(getString(R.string.tab_navigation_order_draft))
	}

	override fun render(state: DetailOrderScreenState) {
		when (state) {
			is DetailOrderScreenState.Initialized -> Unit
			is DetailOrderScreenState.Data -> render(state)
		}
	}

	private fun render(stateOrder: DetailOrderScreenState.Data) {
		stateOrder.order.run {
			order_draft_input_to.setText("Дволятик Олег")
			order_draft_input_from.setText("Автоматически")
			order_draft_input_title.setText(titleText)
			order_draft_input_body.setText(bodyText)
			order_draft_input_date.setText("29.11.2020")
		}
	}
}