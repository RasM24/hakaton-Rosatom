package ru.endroad.component.navigation.command

import ru.endroad.component.navigation.destination.Destination

sealed class Command {

	class Open(val destination: Destination) : Command()
	class Replace(val destination: Destination) : Command()
	class ChangeRoot(val destination: Destination) : Command()
}