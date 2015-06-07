package au.com.amdocs.command;

import au.com.amdocs.common.StringUtils;

/**
 * The all valid car commands.
 * 
 * @author Jiang Liu
 * 
 */
public enum CommandEnum {
	INIT, FORWARD, TURN_LEFT, TURN_RIGHT, GPS_REPORT, DONOTHING, QUIT;

	public static CommandEnum fromString(final String commandString) {
		if ((!StringUtils.isNullOrEmpty(commandString))
				&& (commandString.toUpperCase().startsWith(INIT.toString()))) {
			return INIT;
		}
		
		for (CommandEnum command : CommandEnum.values()) {
			if (command.toString().equalsIgnoreCase(commandString)) {
				return command;
			}
		}

		return DONOTHING;
	}
}
