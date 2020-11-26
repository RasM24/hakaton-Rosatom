package ru.endroad.rosatom.router

import org.koin.java.KoinJavaComponent.inject
import ru.endroad.component.navigation.command.Command
import ru.endroad.component.navigation.navigator.Navigator
import ru.endroad.rosatom.di.contentNavigatorQualifier
import ru.endroad.rosatom.view.monitoring.MonitoringDestination
import ru.endroad.rosatom.view.profile.ProfileDestination

class MainNavigationRouter {

	private val contentNavigator: Navigator by inject(Navigator::class.java, contentNavigatorQualifier)

	fun openDraftOrder() = Unit

	fun openMonitoring() {
		contentNavigator.execute(Command.ChangeRoot(MonitoringDestination))
	}

	fun openProfile() {
		contentNavigator.execute(Command.ChangeRoot(ProfileDestination))
	}
}