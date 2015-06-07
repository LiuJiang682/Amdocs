package au.com.amdocs.command.interf;

import au.com.amdocs.interf.Car;


/**
 * The executor factory interface.
 * @author Jiang Liu
 *
 */
public interface ExecuterFactory {
	CommandExecuter buildExecuter(Command command, Car car);
}
