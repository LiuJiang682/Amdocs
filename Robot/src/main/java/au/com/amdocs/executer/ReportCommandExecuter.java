package au.com.amdocs.executer;

import java.io.Serializable;

import au.com.amdocs.command.interf.Command;
import au.com.amdocs.command.interf.CommandExecuter;
import au.com.amdocs.interf.Robot;
import au.com.amdocs.interf.RobotTable;

public class ReportCommandExecuter implements CommandExecuter, Serializable {

	/**
	 * Generated Serial Version UID.
	 */
	private static final long serialVersionUID = 4243174115012119781L;

	private Command command;
	
	public ReportCommandExecuter(Command command) {
		this.command = command;
	}
	
	@Override
	public void execute(RobotTable robotTable) {
		if ((this.command.isValidCommand())&&(this.command.isLegitimateMove(robotTable))) {
			Robot robot = robotTable.getRobot();
			System.out.println(robot.getX() + ", " + robot.getY() + ", " + robot.getFacing());
		}
	}

}
