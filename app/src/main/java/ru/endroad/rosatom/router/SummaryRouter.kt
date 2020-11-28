package ru.endroad.rosatom.router

import org.koin.java.KoinJavaComponent
import ru.endroad.component.navigation.command.Command
import ru.endroad.component.navigation.destination.ActionSendDestination
import ru.endroad.component.navigation.destination.EmailSendDestination
import ru.endroad.component.navigation.navigator.Navigator
import ru.endroad.rosatom.di.contentNavigatorQualifier

class SummaryRouter {

	private val contentNavigator: Navigator by KoinJavaComponent.inject(Navigator::class.java, contentNavigatorQualifier)

	fun shareReport(title: String, description: String) {
		contentNavigator.execute(Command.Open(ActionSendDestination(title, description)))
	}

	fun sendEmail(title: String, body: String) {
		contentNavigator.execute(Command.Open(EmailSendDestination(title, body)))
	}
}