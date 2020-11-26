package ru.endroad.rosatom.view.order

import kotlinx.android.synthetic.main.order_draft_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.endroad.component.common.MviFragment
import ru.endroad.rosatom.R

class DraftOrderFragment : MviFragment<DraftOrderScreenState, DraftOrderScreenEvent>() {

	override val viewModel by viewModel<DraftOrderViewModel>()
	override val layout = R.layout.order_draft_fragment

	override fun setupViewComponents() {
		setToolbarText(getString(R.string.tab_navigation_order_draft))
	}

	override fun render(state: DraftOrderScreenState) {
		when (state) {
			DraftOrderScreenState.Initialized -> TODO()
			is DraftOrderScreenState.RecognitionData -> render(state)
		}
	}

	private fun render(state: DraftOrderScreenState.RecognitionData) {
		state.draftOrder.run {
			creator?.name?.let(order_draft_input_to::setText)
			executor?.name?.let(order_draft_input_from::setText)
			titleText?.let(order_draft_input_title::setText)
			bodyText?.let(order_draft_input_body::setText)
			deadline?.let(order_draft_input_date::setText)
		}
	}
}