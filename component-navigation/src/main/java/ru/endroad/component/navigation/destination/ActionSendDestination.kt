package ru.endroad.component.navigation.destination

import android.content.Intent

class ActionSendDestination(
	private val title: String,
	private val description: String
) : SystemDestination {

	override fun createIntent(): Intent =
		Intent.createChooser(actionSendIntent, title)

	private val actionSendIntent: Intent
		get() = Intent(Intent.ACTION_SEND).apply {
			type = "text/plain"
			putExtra(Intent.EXTRA_TEXT, description)
		}
}