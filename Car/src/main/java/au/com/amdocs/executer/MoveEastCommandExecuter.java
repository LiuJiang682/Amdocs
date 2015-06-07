package au.com.amdocs.executer;

import java.io.Serializable;

import au.com.amdocs.command.interf.Command;
import au.com.amdocs.command.interf.CommandExecuter;
import au.com.amdocs.interf.Car;
import au.com.amdocs.interf.CarTable;

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
	public void execute(CarTable carTable) {
		if ((this.command.isValidCommand())&&(this.command.isLegitimateMove(carTable))) {
			Car car = carTable.getCar();
			int x = car.getX();
			++x;
			car.setX(x);
		}

	}

}
