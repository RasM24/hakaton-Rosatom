package ru.endroad.rosatom.application

import android.Manifest.permission
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.collect
import org.koin.android.ext.android.inject
import ru.endroad.component.common.BaseActivity
import ru.endroad.component.navigation.navigator.NavigationCommandStack
import ru.endroad.rosatom.R
import ru.endroad.rosatom.router.RootRouter

class SingleActivity : BaseActivity() {

	override val layout = R.layout.hub_activity
	override val theme = R.style.ThemeRosatom

	private val navigatorCommandStack: NavigationCommandStack by inject()
	private val router: RootRouter by inject()

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		lifecycleScope.launchWhenResumed {
			navigatorCommandStack.commandFlow.collect { requireNavigationContext ->
				requireNavigationContext(baseContext, supportFragmentManager)
			}
		}

		requestPermission()
		intent.let(::processIntent)
	}

	private fun processIntent(intent: Intent) {
		if (intent.action == Intent.ACTION_VIEW) {
			intent.data?.let(router::openDeepLink)
		}
	}

	override fun onFirstCreate() {
		router.openMainNavigationScreen(R.id.tab_draft_order)
	}

	private fun requestPermission() {
		val audioPermission = checkSelfPermission(permission.RECORD_AUDIO) == PackageManager.PERMISSION_GRANTED
		val storageWritePermission = checkSelfPermission(permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED
		val storageReadPermission = checkSelfPermission(permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED

		arrayOf(permission.RECORD_AUDIO, permission.WRITE_EXTERNAL_STORAGE, permission.READ_EXTERNAL_STORAGE)
			.takeUnless { audioPermission && storageReadPermission && storageWritePermission }
			?.let { requestPermissions(it, 0) }
	}
}