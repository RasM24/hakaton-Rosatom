package ru.endroad.rosatom.router

import org.koin.java.KoinJavaComponent
import ru.endroad.component.navigation.command.Command
import ru.endroad.component.navigation.destination.EmailSendDestination
import ru.endroad.component.navigation.navigator.Navigator
import ru.endroad.rosatom.di.contentNavigatorQualifier
import ru.endroad.rosatom.view.detail.DetailOrderDestination

class OrderRouter {

	private val contentNavigator: Navigator by KoinJavaComponent.inject(Navigator::class.java, contentNavigatorQualifier)

	fun openOrderDetail(orderId: Long) {
		contentNavigator.execute(Command.Open(DetailOrderDestination(orderId)))
	}
}