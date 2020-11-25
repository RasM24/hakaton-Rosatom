package ru.endroad.rosatom.router

import org.koin.java.KoinJavaComponent.inject
import ru.endroad.component.navigation.navigator.Navigator
import ru.endroad.rosatom.di.contentNavigatorQualifier

class MainNavigationRouter {

	private val contentNavigator: Navigator by inject(Navigator::class.java, contentNavigatorQualifier)

	fun openDraftOrder() = Unit

	fun openMonitoring() = Unit

	fun openThirdScreen() = Unit
}