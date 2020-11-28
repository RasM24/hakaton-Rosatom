package ru.endroad.rosatom.view.summary

import kotlinx.android.synthetic.main.summary_fragment.*
import org.koin.android.ext.android.inject
import ru.endroad.component.common.BaseFragment
import ru.endroad.rosatom.R
import ru.endroad.rosatom.router.SummaryRouter

class SummaryFragment : BaseFragment() {

	override val layout = R.layout.summary_fragment

	private val router: SummaryRouter by inject()

	override fun setupViewComponents() {
		setToolbarText(getString(R.string.tab_navigation_calendar))
		summary_statistic_body.setText(R.string.mock_summary_statistic_body)
		summary_performer_body.setText(R.string.mock_summary_performer_body)

		summary_share.setOnClickListener { router.shareReport("Отправить отчет", getString(R.string.mock_summary_performer_body)) }
		summary_send_to_mail.setOnClickListener { router.sendEmail("Отчет за 29.11.2020", getString(R.string.mock_summary_statistic_body)) }
	}
}