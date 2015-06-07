package au.com.amdocs.executer.factory;

import java.io.Serializable;

import au.com.amdocs.command.interf.Command;
import au.com.amdocs.command.interf.CommandExecuter;
import au.com.amdocs.command.interf.ExecuterFactory;
import au.com.amdocs.interf.Car;

/**
 * The executor factory class.
 * 
 * @author Jiang Liu
 *
 */
public class ExecuterConstructFactory implements Serializable {

	/**
	 * Generated Serial Version UID.
	 */
	private static final long serialVersionUID = 7338274324833597485L;

	private ExecuterConstructFactory() {
		//prevent instantiation
	}

	public static CommandExecuter contructExecuter(Command command, Car car) {
		ExecuterFactory executerFactory = findExecuterFactory(command);
		return executerFactory.buildExecuter(command, car);
	}

	public static ExecuterFactory findExecuterFactory(Command command) {
		ExecuterFactory factory = null;
		switch (command.getCommand()) {
			case INIT:
				factory = new InitCommandExecuterFactory();
				break;
				
			case FORWARD:
				factory = new ForwardCommandExecuterFactory();
				break;
			
			case TURN_LEFT:
			    factory = new TurnLeftCommandExecuterFactory();
			    break;
			    
			case TURN_RIGHT:
				factory = new TurnRightCommandExecuterFactory();
				break;
				
			case GPS_REPORT:
				factory = new GPSReportCommandExecuterFactory();
				break;
				
			case DONOTHING:
			default:
				factory = new DoNothingExecutorFactory();
		}
		return factory;
	}
}
