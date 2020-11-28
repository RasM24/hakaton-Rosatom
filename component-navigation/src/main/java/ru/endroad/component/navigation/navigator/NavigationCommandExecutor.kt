package ru.endroad.component.navigation.navigator

import android.content.Context
import android.content.Intent
import androidx.fragment.app.FragmentManager
import ru.endroad.component.navigation.command.Command
import ru.endroad.component.navigation.destination.Destination
import ru.endroad.component.navigation.destination.FragmentDestination
import ru.endroad.component.navigation.destination.SystemDestination
import ru.endroad.component.navigation.manager.*

class NavigationCommandExecutor {

	fun execute(command: Command, context: Context, fragmentManager: FragmentManager, container: Int) {
		when (command) {
			is Command.Open -> open(command.destination, context, fragmentManager, container)
			is Command.Replace -> replace(command.destination, fragmentManager, container)
			is Command.ChangeRoot -> changeRoot(command.destination, fragmentManager, container)
		}
	}

	private fun open(destination: Destination, context: Context, fragmentManager: FragmentManager, container: Int) {
		when (destination) {
			is FragmentDestination -> fragmentManager.forwardTo(destination.createFragment(), defaultForwardAnimation, container)
			is SystemDestination -> context.startActivity(destination.createIntent().apply { addFlags(Intent.FLAG_ACTIVITY_NEW_TASK) })
		}
	}

	private fun replace(destination: Destination, fragmentManager: FragmentManager, container: Int) {
		when (destination) {
			is FragmentDestination -> fragmentManager.replace(destination.createFragment(), defaultReplaceAnimation, container)
		}
	}

	private fun changeRoot(destination: Destination, fragmentManager: FragmentManager, container: Int) {
		when (destination) {
			is FragmentDestination -> fragmentManager.changeRoot(destination.createFragment(), defaultReplaceAnimation, container)
		}
	}
}