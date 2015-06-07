package au.com.amdocs.executer.factory;

import java.io.Serializable;

import au.com.amdocs.command.PlaceCommand;
import au.com.amdocs.command.interf.Command;
import au.com.amdocs.command.interf.CommandExecuter;
import au.com.amdocs.command.interf.ExecuterFactory;
import au.com.amdocs.executer.PlaceCommandExecuter;
import au.com.amdocs.interf.Car;

/**
 * The Place command factory class.
 * @author Jiang Liu
 *
 */
public class PlaceCommandExecuterFactory implements ExecuterFactory,
		Serializable {

	/**
	 * Generated Serial Version UID.
	 */
	private static final long serialVersionUID = 8551374901096550949L;

	@Override
	public CommandExecuter buildExecuter(Command command, Car car) {
		return new PlaceCommandExecuter((PlaceCommand) command);
	}

}
