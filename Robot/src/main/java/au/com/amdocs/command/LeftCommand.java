package au.com.amdocs.command;

import java.io.Serializable;

import au.com.amdocs.command.interf.Command;
import au.com.amdocs.interf.Robot;
import au.com.amdocs.interf.RobotTable;

/**
 * The left command class.
 * @author Jiang Liu
 *
 */
public class LeftCommand implements Command, Serializable {

	/**
	 *  Generated Serial Version UID.
	 */
	private static final long serialVersionUID = 3892370573008240544L;

	@Override
	public CommandEnum getCommand() {
		return CommandEnum.LEFT;
	}

	@Override
	public boolean isLegitimateMove(RobotTable robotTable) {
		boolean valid = false;
		Robot robot = robotTable.getRobot();
		if (robot != null) {
			valid = true;
		}
		return valid;
	}

	@Override
	public boolean isValidCommand() {
		return true;
	}

}
