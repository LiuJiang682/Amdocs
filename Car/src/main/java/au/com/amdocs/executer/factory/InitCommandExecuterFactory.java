package au.com.amdocs.executer.factory;

import java.io.Serializable;

import au.com.amdocs.command.InitCommand;
import au.com.amdocs.command.interf.Command;
import au.com.amdocs.command.interf.CommandExecuter;
import au.com.amdocs.command.interf.ExecuterFactory;
import au.com.amdocs.executer.InitCommandExecuter;
import au.com.amdocs.interf.Car;

/**
 * The Place command factory class.
 * @author Jiang Liu
 *
 */
public class InitCommandExecuterFactory implements ExecuterFactory,
		Serializable {

	/**
	 * Generated Serial Version UID.
	 */
	private static final long serialVersionUID = 8551374901096550949L;

	@Override
	public CommandExecuter buildExecuter(Command command, Car car) {
		return new InitCommandExecuter((InitCommand) command);
	}

}
