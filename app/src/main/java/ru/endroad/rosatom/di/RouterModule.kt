package ru.endroad.rosatom.di

import org.koin.dsl.module
import org.koin.experimental.builder.single
import ru.endroad.rosatom.router.*

val routerModule = module {
	single<RootRouter>()
	single<MainNavigationRouter>()
	single<SummaryRouter>()
	single<PushRouting>()
}