package ru.endroad.rosatom.di

import org.koin.core.qualifier.named
import org.koin.dsl.module
import org.koin.experimental.builder.single
import ru.endroad.component.navigation.navigator.NavigationCommandExecutor
import ru.endroad.component.navigation.navigator.NavigationCommandStack
import ru.endroad.component.navigation.navigator.Navigator
import ru.endroad.rosatom.R

val rootNavigatorQualifier = named("RootNavigator")
val contentNavigatorQualifier = named("ContentNavigator")

val navigationModule = module {
	single<NavigationCommandStack>()
	single<NavigationCommandExecutor>()

	single(rootNavigatorQualifier) { Navigator(R.id.root, get(), get()) }
	single(contentNavigatorQualifier) { Navigator(R.id.content, get(), get()) }
}