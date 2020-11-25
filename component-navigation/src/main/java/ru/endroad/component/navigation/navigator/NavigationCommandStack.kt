package ru.endroad.component.navigation.navigator

import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.*

class NavigationCommandStack {

	private val sharedFlow = MutableSharedFlow<RequireNavigationContext>(
		replay = Int.MAX_VALUE,
		extraBufferCapacity = 0,
		onBufferOverflow = BufferOverflow.SUSPEND,
	)

	val commandFlow: Flow<RequireNavigationContext> = flow {
		sharedFlow.collect {
			sharedFlow.resetReplayCache()
			emit(it)
		}
	}

	fun execute(requireNavigationContext: RequireNavigationContext) {
		sharedFlow.tryEmit(requireNavigationContext)
	}
}