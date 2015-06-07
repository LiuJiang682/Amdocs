package au.com.amdocs.executer.factory;

import java.io.Serializable;

import au.com.amdocs.command.interf.Command;
import au.com.amdocs.command.interf.CommandExecuter;
import au.com.amdocs.command.interf.ExecuterFactory;
import au.com.amdocs.executer.DoNothingExecuter;
import au.com.amdocs.interf.Car;

/**
 * The DoNothingExecuter factory class.
 * @author Jiang Liu
 *
 */
public class DoNothingExecutorFactory implements ExecuterFactory, Serializable {

	/**
	 * Generated Serial Version UID.
	 */
	private static final long serialVersionUID = -9038719739747487275L;

	@Override
	public CommandExecuter buildExecuter(Command command, Car car) {
		return new DoNothingExecuter();
	}

}
