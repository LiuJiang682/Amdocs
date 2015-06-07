package au.com.amdocs.command.factory;

import java.io.Serializable;

import au.com.amdocs.command.InitCommand;
import au.com.amdocs.command.interf.Command;
import au.com.amdocs.command.interf.CommandFactory;
import au.com.amdocs.common.CommonConstants;

/**
 * Init command factory
 * @author Jiang Liu
 *
 */
public class InitCommandFactory implements CommandFactory, Serializable {

	/**
	 * Generated Serial Version UID. 
	 */
	private static final long serialVersionUID = 4757681782796403917L;

	@Override
	public Command buildCommand(String commandString) {
		Command command = null;
		String[] strings = commandString.split(CommonConstants.SPACE, CommonConstants.TWO);
		if ((strings == null)||(strings.length != CommonConstants.TWO)) {
			command = new InitCommand(commandString);
		} else {
			command = new InitCommand(commandString, strings[CommonConstants.ONE].trim());
		}
		
		return command;
	}

}
