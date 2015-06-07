package au.com.amdocs.executer.factory;

import java.io.Serializable;

import au.com.amdocs.command.interf.Command;
import au.com.amdocs.command.interf.CommandExecuter;
import au.com.amdocs.command.interf.ExecuterFactory;
import au.com.amdocs.executer.ReportCommandExecuter;
import au.com.amdocs.interf.Car;

public class ReportCommandExecuterFactory implements ExecuterFactory,
		Serializable {

	/**
	 * Generated Serial Version UID.
	 */
	private static final long serialVersionUID = 6481856998652562691L;

	@Override
	public CommandExecuter buildExecuter(Command command, Car car) {
		return new ReportCommandExecuter(command);
	}

}
