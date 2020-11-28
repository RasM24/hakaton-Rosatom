package ru.endroad.rosatom.router

import org.koin.java.KoinJavaComponent.inject
import ru.endroad.component.navigation.command.Command
import ru.endroad.component.navigation.navigator.Navigator
import ru.endroad.rosatom.di.contentNavigatorQualifier
import ru.endroad.rosatom.view.monitoring.MonitoringDestination
import ru.endroad.rosatom.view.order.DraftOrderDestination
import ru.endroad.rosatom.view.order.ListOrderDestination
import ru.endroad.rosatom.view.order.SpectatorOrderDestination
import ru.endroad.rosatom.view.summary.SummaryDestination

class MainNavigationRouter {

	private val contentNavigator: Navigator by inject(Navigator::class.java, contentNavigatorQualifier)

	fun openDraftOrder() {
		contentNavigator.execute(Command.ChangeRoot(DraftOrderDestination))
	}

	fun openMonitoring() {
		contentNavigator.execute(Command.ChangeRoot(MonitoringDestination))
	}

	fun openProfile() {
		contentNavigator.execute(Command.ChangeRoot(SpectatorOrderDestination))
	}

	fun openListOrder() {
		contentNavigator.execute(Command.ChangeRoot(ListOrderDestination))
	}

	fun openSummary() {
		contentNavigator.execute(Command.ChangeRoot(SummaryDestination))
	}
}