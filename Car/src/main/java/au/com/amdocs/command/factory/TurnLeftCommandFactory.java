package au.com.amdocs.command.factory;

import java.io.Serializable;

import au.com.amdocs.command.TurnLeftCommand;
import au.com.amdocs.command.interf.Command;
import au.com.amdocs.command.interf.CommandFactory;

/**
 * The turn left command factory class.
 * @author Jiang Liu
 *
 */
public class TurnLeftCommandFactory implements CommandFactory, Serializable {

	/**
	 * Generated Serial Version UID.
	 */
	private static final long serialVersionUID = 8453453567494682889L;

	@Override
	public Command buildCommand(String commandString) {
		return new TurnLeftCommand();
	}

}
