package ru.endroad.component.navigation.navigator

import android.content.Context
import androidx.fragment.app.FragmentManager
import ru.endroad.component.navigation.command.Command

class Navigator(
	private val fragmentContainer: Int,
	private val commandStack: NavigationCommandStack,
	private val commandExecutor: NavigationCommandExecutor,
) {

	fun execute(command: Command) {
		val executor = { context: Context, fragmentManager: FragmentManager ->
			commandExecutor.execute(command, context, fragmentManager, fragmentContainer)
		}
		commandStack.execute(executor)
	}
}