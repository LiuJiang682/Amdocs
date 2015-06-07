package au.com.amdocs.command.factory;

import java.io.Serializable;

import au.com.amdocs.command.ReportCommand;
import au.com.amdocs.command.interf.Command;
import au.com.amdocs.command.interf.CommandFactory;

/**
 * The report command factory class.
 * @author Jiang Liu
 *
 */
public class ReportCommandFactory implements CommandFactory, Serializable {

	/**
	 * Generated Serial Version UID.
	 */
	private static final long serialVersionUID = 214263650002128753L;

	@Override
	public Command buildCommand(String commandString) {
		return new ReportCommand();
	}

}
