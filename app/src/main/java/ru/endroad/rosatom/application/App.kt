package ru.endroad.rosatom.application

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import ru.endroad.rosatom.di.*
import ru.endroad.server.orders.di.ordersModule
import ru.endroad.server.voice.di.voiceModule

class App : Application() {

	override fun onCreate() {
		super.onCreate()
		startKoin {
			androidContext(this@App)
			modules(
				navigationModule,
				routerModule,
				viewModelModule,
				dataModule,
				voiceModule,
				ordersModule,
			)
		}
	}
}