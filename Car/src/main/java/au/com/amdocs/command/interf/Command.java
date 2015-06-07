package au.com.amdocs.command.interf;

import au.com.amdocs.command.CommandEnum;
import au.com.amdocs.interf.CarTable;

/**
 * The command interface for car.
 * 
 * @author Jiang Liu
 *
 */
public interface Command {

	boolean isValidCommand();
	
	boolean isLegitimateMove(CarTable carTable);
	
	CommandEnum getCommand();
}
