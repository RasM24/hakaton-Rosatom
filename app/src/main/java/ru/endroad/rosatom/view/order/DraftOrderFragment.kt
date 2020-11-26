package ru.endroad.rosatom.view.order

import ru.endroad.component.common.BaseFragment
import ru.endroad.rosatom.R

class DraftOrderFragment : BaseFragment() {

	override val layout = R.layout.order_draft_fragment

	override fun setupViewComponents() {
		setToolbarText(getString(R.string.tab_navigation_order_draft))
	}
}