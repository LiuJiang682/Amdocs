package au.com.amdocs.command.interf;

import au.com.amdocs.interf.Robot;


/**
 * The executor factory interface.
 * @author Jiang Liu
 *
 */
public interface ExecuterFactory {
	CommandExecuter buildExecuter(Command command, Robot robot);
}
