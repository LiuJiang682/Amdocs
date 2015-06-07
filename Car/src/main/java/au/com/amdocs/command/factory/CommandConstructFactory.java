package au.com.amdocs.command.factory;

import java.io.Serializable;

import au.com.amdocs.command.CommandEnum;
import au.com.amdocs.command.interf.Command;
import au.com.amdocs.command.interf.CommandFactory;

/**
 * The abstract factory for construct command object.
 * 
 * @author Jiang Liu
 * 
 */
public class CommandConstructFactory implements Serializable {

	/**
	 * Generated Serial Version UID.
	 */
	private static final long serialVersionUID = 360894072658242306L;

	private CommandConstructFactory() {
		// prevent instantiation
	}

	public static Command constructCommand(String commandString) {
		CommandFactory commandFactory = findCommandFactory(commandString);
		Command command = commandFactory.buildCommand(commandString);
		return command;
	}

	/**
	 * This method selects the correct command factory.
	 * 
	 * @param commandString
	 *            the command string.
	 * @return command factory object.
	 */
	public static CommandFactory findCommandFactory(String commandString) {

		CommandFactory commandFactory = null;
		switch (CommandEnum.fromString(commandString)) {
		case INIT:
			commandFactory = new InitCommandFactory();
			break;
		case FORWARD:
			commandFactory = new ForwardCommandFactory();
			break;
		case TURN_LEFT:
			commandFactory = new TurnLeftCommandFactory();
			break;
		case TURN_RIGHT:
			commandFactory = new TurnRightCommandFactory();
			break;
		case GPS_REPORT:
			commandFactory = new GPSReportCommandFactory();
			break;
		case QUIT:
			commandFactory = new QuitCommandFactory();
			break;
		case DONOTHING:
			commandFactory = new DoNothingCommandFactory();
		}

		return commandFactory;
	}
}
