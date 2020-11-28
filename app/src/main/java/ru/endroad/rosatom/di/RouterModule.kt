package ru.endroad.rosatom.di

import org.koin.dsl.module
import org.koin.experimental.builder.single
import ru.endroad.rosatom.router.MainNavigationRouter
import ru.endroad.rosatom.router.RootRouter
import ru.endroad.rosatom.router.SummaryRouter

val routerModule = module {
	single<RootRouter>()
	single<MainNavigationRouter>()
	single<SummaryRouter>()
}