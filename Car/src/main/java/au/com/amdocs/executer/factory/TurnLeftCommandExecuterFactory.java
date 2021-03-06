package au.com.amdocs.executer.factory;

import java.io.Serializable;

import au.com.amdocs.command.interf.Command;
import au.com.amdocs.command.interf.CommandExecuter;
import au.com.amdocs.command.interf.ExecuterFactory;
import au.com.amdocs.executer.TurnLeftCommandExecuter;
import au.com.amdocs.interf.Car;

public class TurnLeftCommandExecuterFactory implements ExecuterFactory,
		Serializable {

	/**
	 * Generated Serial Version UID.
	 */
	private static final long serialVersionUID = -2116161501346490872L;

	@Override
	public CommandExecuter buildExecuter(Command command, Car car) {
		return new TurnLeftCommandExecuter(command);
	}

}
