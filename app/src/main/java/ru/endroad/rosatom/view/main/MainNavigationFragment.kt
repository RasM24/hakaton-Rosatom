package ru.endroad.rosatom.view.main

import android.view.MenuItem
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.hub_fragment.*
import org.koin.android.ext.android.inject
import ru.endroad.component.common.BaseFragment
import ru.endroad.component.common.withArguments
import ru.endroad.rosatom.R
import ru.endroad.rosatom.router.MainNavigationRouter

class MainNavigationFragment : BaseFragment(), BottomNavigationView.OnNavigationItemSelectedListener {

	companion object {

		private const val INITIAL_SCREEN_KEY = "INITIAL_SCREEN"

		fun create(initialScreen: Int): Fragment =
			MainNavigationFragment().withArguments(
				INITIAL_SCREEN_KEY to initialScreen
			)
	}

	override val layout = R.layout.hub_fragment

	private val router: MainNavigationRouter by inject()

	private val initialScreen: Int
		get() = requireArguments().getInt(INITIAL_SCREEN_KEY)

	override fun setupViewComponents() {
		requireAppCompatActivity().setupToolbar()
		navigation_view.setOnNavigationItemSelectedListener(this)
		navigation_view.selectedItemId = initialScreen
	}

	override fun onNavigationItemSelected(item: MenuItem): Boolean {
		when (item.itemId) {
			R.id.tab_draft_order -> router.openDraftOrder()
			R.id.tab_monitoring  -> router.openMonitoring()
			R.id.tab_profile     -> router.openThirdScreen()
			else                 -> return false
		}

		return true
	}

	private fun requireAppCompatActivity() =
		requireActivity() as AppCompatActivity

	private fun AppCompatActivity.setupToolbar() {
		setSupportActionBar(toolbar)
		toolbar.setNavigationOnClickListener { onBackPressed() }
		supportFragmentManager.addOnBackStackChangedListener {
			supportActionBar?.setHomeEnabled()
		}
		supportActionBar?.setHomeEnabled()
	}

	private fun ActionBar.setHomeEnabled() {
		this.setDisplayHomeAsUpEnabled(requireActivity().supportFragmentManager.backStackEntryCount != 0)
	}
}