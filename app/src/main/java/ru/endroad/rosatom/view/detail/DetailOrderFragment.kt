package ru.endroad.rosatom.view.detail

import ru.endroad.component.common.BaseFragment
import ru.endroad.rosatom.R

class DetailOrderFragment : BaseFragment() {

	override val layout = R.layout.order_detail_fragment

	override fun setupViewComponents() {
		setToolbarText(getString(R.string.tab_navigation_order_detail))
	}
}