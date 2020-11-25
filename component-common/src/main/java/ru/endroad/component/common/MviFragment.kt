package ru.endroad.component.common

import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.collect

abstract class MviFragment<STATE, EVENT> : BaseFragment() {

	abstract val viewModel: MviViewModel<STATE, EVENT>

	override fun onActivityCreated(savedInstanceState: Bundle?) {
		super.onActivityCreated(savedInstanceState)
		lifecycleScope.launchWhenResumed {
			viewModel.state.collect { render(it) }
		}
	}

	protected abstract fun render(state: STATE)
}
