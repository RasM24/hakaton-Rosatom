package ru.endroad.component.navigation.destination

import android.content.Intent

class EmailSendDestination(
	private val title: String,
	private val body: String
) : SystemDestination {

	private companion object {

		const val REPORT_EMAIL_ADDRESS = "report@endroad.ru"
	}

	override fun createIntent(): Intent =
		Intent.createChooser(emailIntent, "Отчет")

	private val emailIntent: Intent
		get() = Intent(Intent.ACTION_SEND)
			.apply {
				type = "plain/text"
				putExtra(Intent.EXTRA_EMAIL, arrayOf(REPORT_EMAIL_ADDRESS))
				putExtra(Intent.EXTRA_SUBJECT, title)
				putExtra(Intent.EXTRA_TEXT, body)
			}
}