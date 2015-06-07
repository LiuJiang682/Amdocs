package au.com.amdocs.command.factory;

import java.io.Serializable;

import au.com.amdocs.command.DoNothingCommand;
import au.com.amdocs.command.interf.Command;
import au.com.amdocs.command.interf.CommandFactory;

public class DoNothingCommandFactory implements CommandFactory, Serializable {

	/**
	 * Generated Serial Version UID. 
	 */
	private static final long serialVersionUID = 5941383854467937988L;

	@Override
	public Command buildCommand(String commandString) {
		System.out.println("Unknown command string " + commandString);
		return new DoNothingCommand();
	}

}
