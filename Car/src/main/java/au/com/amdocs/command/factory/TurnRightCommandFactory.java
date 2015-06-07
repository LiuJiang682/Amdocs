package au.com.amdocs.command.factory;

import java.io.Serializable;

import au.com.amdocs.command.TurnRightCommand;
import au.com.amdocs.command.interf.Command;
import au.com.amdocs.command.interf.CommandFactory;

/**
 * The turn right command factory class.
 * @author Jiang Liu
 *
 */
public class TurnRightCommandFactory implements CommandFactory, Serializable {

	/**
	 * Generated Serial Version UID.
	 */
	private static final long serialVersionUID = -259995006276349162L;

	@Override
	public Command buildCommand(String commandString) {
		return new TurnRightCommand();
	}

}
