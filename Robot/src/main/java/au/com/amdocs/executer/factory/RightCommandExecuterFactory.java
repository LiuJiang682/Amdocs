package au.com.amdocs.executer.factory;

import java.io.Serializable;

import au.com.amdocs.command.interf.Command;
import au.com.amdocs.command.interf.CommandExecuter;
import au.com.amdocs.command.interf.ExecuterFactory;
import au.com.amdocs.executer.RightCommandExecuter;
import au.com.amdocs.interf.Robot;

public class RightCommandExecuterFactory implements ExecuterFactory,
		Serializable {

	/**
	 * Generated Serial Version UID.
	 */
	private static final long serialVersionUID = 2451172349177368383L;

	@Override
	public CommandExecuter buildExecuter(Command command, Robot robot) {
		return new RightCommandExecuter(command);
	}

}
