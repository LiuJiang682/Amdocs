package au.com.amdocs.command.factory;

import java.io.Serializable;

import au.com.amdocs.command.GPSReportCommand;
import au.com.amdocs.command.interf.Command;
import au.com.amdocs.command.interf.CommandFactory;

/**
 * The GPS report command factory class.
 * @author Jiang Liu
 *
 */
public class GPSReportCommandFactory implements CommandFactory, Serializable {

	/**
	 * Generated Serial Version UID.
	 */
	private static final long serialVersionUID = 214263650002128753L;

	@Override
	public Command buildCommand(String commandString) {
		return new GPSReportCommand();
	}

}
