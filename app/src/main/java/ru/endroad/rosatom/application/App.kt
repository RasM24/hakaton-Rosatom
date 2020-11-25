package ru.endroad.rosatom.application

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import ru.endroad.rosatom.di.navigationModule
import ru.endroad.rosatom.di.routerModule

class App : Application() {

	override fun onCreate() {
		super.onCreate()
		startKoin {
			androidContext(this@App)
			modules(navigationModule, routerModule)
		}
	}
}