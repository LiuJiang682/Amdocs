package au.com.amdocs.command.factory;

import au.com.amdocs.command.QuitCommand;
import au.com.amdocs.command.interf.Command;
import au.com.amdocs.command.interf.CommandFactory;

public class QuitCommandFactory implements CommandFactory {

	@Override
	public Command buildCommand(String commandString) {
		return new QuitCommand();
	}

}
