package au.com.amdocs.executer.factory;

import java.io.Serializable;

import au.com.amdocs.command.interf.Command;
import au.com.amdocs.command.interf.CommandExecuter;
import au.com.amdocs.command.interf.ExecuterFactory;
import au.com.amdocs.executer.TurnRightCommandExecuter;
import au.com.amdocs.interf.Car;

public class TurnRightCommandExecuterFactory implements ExecuterFactory,
		Serializable {

	/**
	 * Generated Serial Version UID.
	 */
	private static final long serialVersionUID = 2451172349177368383L;

	@Override
	public CommandExecuter buildExecuter(Command command, Car car) {
		return new TurnRightCommandExecuter(command);
	}

}
