package au.com.amdocs.command.factory;

import java.io.Serializable;

import au.com.amdocs.command.MoveCommand;
import au.com.amdocs.command.interf.Command;
import au.com.amdocs.command.interf.CommandFactory;

/**
 * Move command factory.
 * @author Jiang Liu
 *
 */
public class MoveCommandFactory implements CommandFactory, Serializable {

	/**
	 * Generated Serial Version UID.
	 */
	private static final long serialVersionUID = 3922930993130815278L;

	@Override
	public Command buildCommand(String commandString) {
		return new MoveCommand();
	}

}
