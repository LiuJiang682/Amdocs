package au.com.amdocs.command;

import java.io.Serializable;

import au.com.amdocs.command.interf.Command;
import au.com.amdocs.interf.Car;
import au.com.amdocs.interf.CarTable;

/**
 * The turn left command class.
 * @author Jiang Liu
 *
 */
public class TurnLeftCommand implements Command, Serializable {

	/**
	 *  Generated Serial Version UID.
	 */
	private static final long serialVersionUID = 3892370573008240544L;

	@Override
	public CommandEnum getCommand() {
		return CommandEnum.TURN_LEFT;
	}

	@Override
	public boolean isLegitimateMove(CarTable carTable) {
		boolean valid = false;
		Car car = carTable.getCar();
		if (car != null) {
			valid = true;
		}
		return valid;
	}

	@Override
	public boolean isValidCommand() {
		return true;
	}

}
