package au.com.amdocs.command;

import java.io.Serializable;

import au.com.amdocs.command.interf.Command;
import au.com.amdocs.common.CommonConstants;
import au.com.amdocs.interf.Car;
import au.com.amdocs.interf.CarTable;

public class ForwardCommand implements Command, Serializable {

	/**
	 * Generated Serial Version UID.
	 */
	private static final long serialVersionUID = -3135367800096411110L;

	@Override
	public CommandEnum getCommand() {
		return CommandEnum.FORWARD;
	}

	@Override
	public boolean isLegitimateMove(CarTable carTable) {
		boolean valid = false;
		Car car = carTable.getCar();
		if (car != null) {
			//only work when car on table.
			switch (car.getFacing()) {
				case EAST:
					if (car.getX() < carTable.getMaxX()) {
						valid = true;
					}
					break;
					
				case NORTH:
					if (car.getY() < carTable.getMaxY()) {
						valid = true;
					}
					break;
					
				case WEST:
					if (CommonConstants.ZERO < car.getX()) {
						valid = true;
					}
					break;
					
				case SOUTH:
					if (CommonConstants.ZERO < car.getY()) {
						valid = true;
					}
					break;
						
				default:
					valid = false;
			}
		}
		return valid;
	}

	@Override
	public boolean isValidCommand() {
		return true;
	}

}
