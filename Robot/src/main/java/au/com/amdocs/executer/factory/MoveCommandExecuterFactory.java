package au.com.amdocs.executer.factory;

import java.io.Serializable;

import au.com.amdocs.command.interf.Command;
import au.com.amdocs.command.interf.CommandExecuter;
import au.com.amdocs.command.interf.ExecuterFactory;
import au.com.amdocs.executer.DoNothingExecuter;
import au.com.amdocs.executer.MoveEastCommandExecuter;
import au.com.amdocs.executer.MoveNorthCommandExecuter;
import au.com.amdocs.executer.MoveSouthCommandExecuter;
import au.com.amdocs.executer.MoveWestCommandExecuter;
import au.com.amdocs.interf.Robot;

public class MoveCommandExecuterFactory implements ExecuterFactory, Serializable {

	/**
	 * Generated Serial Version UID.
	 */
	private static final long serialVersionUID = 4898603827272628726L;

	@Override
	public CommandExecuter buildExecuter(Command command, Robot robot) {
		CommandExecuter commandExecuter = null;
		if (robot == null) {
			commandExecuter = new DoNothingExecuter();
		} else {
			switch (robot.getFacing()) {
				case EAST:
					commandExecuter = new MoveEastCommandExecuter(command);
					break;
				case NORTH:
					commandExecuter = new MoveNorthCommandExecuter(command);
					break;
				case WEST:
					commandExecuter = new MoveWestCommandExecuter(command);
					break;
				case SOUTH:
					commandExecuter = new MoveSouthCommandExecuter(command);
					break;
				default:
					commandExecuter = new DoNothingExecuter();
			}
		}
		return commandExecuter;
	}

}
