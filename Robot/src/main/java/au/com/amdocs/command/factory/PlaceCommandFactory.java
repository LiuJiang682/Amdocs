package au.com.amdocs.command.factory;

import java.io.Serializable;

import au.com.amdocs.command.PlaceCommand;
import au.com.amdocs.command.interf.Command;
import au.com.amdocs.command.interf.CommandFactory;
import au.com.amdocs.common.CommonConstants;

/**
 * Place command factory
 * @author Jiang Liu
 *
 */
public class PlaceCommandFactory implements CommandFactory, Serializable {

	/**
	 * Generated Serial Version UID. 
	 */
	private static final long serialVersionUID = 4757681782796403917L;

	@Override
	public Command buildCommand(String commandString) {
		Command command = null;
		String[] strings = commandString.split(CommonConstants.SPACE, CommonConstants.TWO);
		if ((strings == null)||(strings.length != CommonConstants.TWO)) {
			command = new PlaceCommand(commandString);
		} else {
			command = new PlaceCommand(commandString, strings[CommonConstants.ONE].trim());
		}
		
		return command;
	}

}
