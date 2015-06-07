package au.com.amdocs.executer.factory;

import java.io.Serializable;

import au.com.amdocs.command.interf.Command;
import au.com.amdocs.command.interf.CommandExecuter;
import au.com.amdocs.command.interf.ExecuterFactory;
import au.com.amdocs.executer.DoNothingExecuter;
import au.com.amdocs.executer.ForwardEastCommandExecuter;
import au.com.amdocs.executer.ForwardNorthCommandExecuter;
import au.com.amdocs.executer.ForwardSouthCommandExecuter;
import au.com.amdocs.executer.ForwardWestCommandExecuter;
import au.com.amdocs.interf.Car;

public class ForwardCommandExecuterFactory implements ExecuterFactory, Serializable {

	/**
	 * Generated Serial Version UID.
	 */
	private static final long serialVersionUID = 4898603827272628726L;

	@Override
	public CommandExecuter buildExecuter(Command command, Car car) {
		CommandExecuter commandExecuter = null;
		if (car == null) {
			commandExecuter = new DoNothingExecuter();
		} else {
			switch (car.getFacing()) {
				case EAST:
					commandExecuter = new ForwardEastCommandExecuter(command);
					break;
				case NORTH:
					commandExecuter = new ForwardNorthCommandExecuter(command);
					break;
				case WEST:
					commandExecuter = new ForwardWestCommandExecuter(command);
					break;
				case SOUTH:
					commandExecuter = new ForwardSouthCommandExecuter(command);
					break;
				default:
					commandExecuter = new DoNothingExecuter();
			}
		}
		return commandExecuter;
	}

}
