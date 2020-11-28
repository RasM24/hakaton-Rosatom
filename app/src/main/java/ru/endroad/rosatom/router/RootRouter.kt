package ru.endroad.rosatom.router

import android.net.Uri
import org.koin.java.KoinJavaComponent.inject
import ru.endroad.component.navigation.command.Command
import ru.endroad.component.navigation.navigator.Navigator
import ru.endroad.rosatom.di.rootNavigatorQualifier
import ru.endroad.rosatom.view.detail.DetailOrderDestination
import ru.endroad.rosatom.view.main.MainNavigationDestination

class RootRouter {

	private val rootNavigator: Navigator by inject(Navigator::class.java, rootNavigatorQualifier)

	fun openMainNavigationScreen(initialScreen: Int) {
		rootNavigator.execute(Command.ChangeRoot(MainNavigationDestination(initialScreen)))
	}

	fun openDeepLink(deeplink: Uri) {
		when (deeplink.path) {
			"/detail" -> rootNavigator.execute(Command.Open(DetailOrderDestination))
		}
	}
}