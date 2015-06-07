package au.com.amdocs.executer;

import java.io.Serializable;

import au.com.amdocs.command.PlaceCommand;
import au.com.amdocs.command.interf.Command;
import au.com.amdocs.command.interf.CommandExecuter;
import au.com.amdocs.interf.Robot;
import au.com.amdocs.interf.RobotTable;
import au.com.amdocs.robot.BGLRobot;

/**
 * The command executer class.
 * @author Jiang Liu
 *
 */
public class PlaceCommandExecuter implements CommandExecuter, Serializable {

	/**
	 * Generated Serial Version UID.
	 */
	private static final long serialVersionUID = 8951888378145500628L;

	private Command command;
	
	public PlaceCommandExecuter(PlaceCommand command) {
		this.command = command;
	}
	
	@Override
	public void execute(RobotTable robotTable) {
		if ((this.command.isValidCommand())&&(this.command.isLegitimateMove(robotTable))) {
			Robot robot = robotTable.getRobot();
			if (robot == null) {
				//First command! Build the robot with parameters
				robot  = new BGLRobot();
				robot.setX(((PlaceCommand)this.command).getX());
				robot.setY(((PlaceCommand)this.command).getY());
				robot.setFacing(((PlaceCommand)this.command).getFacing());
				robotTable.setRobot(robot);
			} else {
				robot.setX(((PlaceCommand)this.command).getX());
				robot.setY(((PlaceCommand)this.command).getY());
				robot.setFacing(((PlaceCommand)this.command).getFacing());
			}
		}
	}

}
