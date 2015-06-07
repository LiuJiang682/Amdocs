package au.com.amdocs.executer;

import java.io.Serializable;

import au.com.amdocs.command.interf.Command;
import au.com.amdocs.command.interf.CommandExecuter;
import au.com.amdocs.interf.Robot;
import au.com.amdocs.interf.RobotTable;

/**
 * Move command executer.
 * @author Jiang Liu
 *
 */
public class MoveEastCommandExecuter implements CommandExecuter, Serializable {

	/**
	 * Generated Serial Version UID.
	 */
	private static final long serialVersionUID = 775919649771492709L;

	private Command command;
	
	public MoveEastCommandExecuter(Command command) {
		this.command = command;
	}
	
	@Override
	public void execute(RobotTable robotTable) {
		if ((this.command.isValidCommand())&&(this.command.isLegitimateMove(robotTable))) {
			Robot robot = robotTable.getRobot();
			int x = robot.getX();
			++x;
			robot.setX(x);
		}

	}

}
