package au.com.amdocs.command.interf;

import au.com.amdocs.command.CommandEnum;
import au.com.amdocs.interf.RobotTable;

/**
 * The command interface for robot.
 * 
 * @author Jiang Liu
 *
 */
public interface Command {

	boolean isValidCommand();
	
	boolean isLegitimateMove(RobotTable robotTable);
	
	CommandEnum getCommand();
}
