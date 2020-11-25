package ru.endroad.rosatom.application

import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.collect
import org.koin.android.ext.android.inject
import ru.endroad.component.common.BaseActivity
import ru.endroad.component.navigation.navigator.NavigationCommandStack
import ru.endroad.rosatom.R

class SingleActivity : BaseActivity() {

	override val layout = R.layout.hub_activity
	override val theme = R.style.ThemeRosatom

	private val navigatorCommandStack: NavigationCommandStack by inject()

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		lifecycleScope.launchWhenResumed {
			navigatorCommandStack.commandFlow.collect { requireNavigationContext ->
				requireNavigationContext(baseContext, supportFragmentManager)
			}
		}
	}
}