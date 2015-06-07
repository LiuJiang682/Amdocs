package au.com.amdocs.executer;

import java.io.Serializable;
import java.util.HashMap;

import au.com.amdocs.command.interf.Command;
import au.com.amdocs.command.interf.CommandExecuter;
import au.com.amdocs.directions.Direction;
import au.com.amdocs.interf.Car;
import au.com.amdocs.interf.CarTable;

public class RightCommandExecuter implements CommandExecuter, Serializable {

	/**
	 * Generated Serial Version UID.
	 */
	private static final long serialVersionUID = 5711625235224168180L;
	
	private static final HashMap<Direction, Direction> directionMap;
	
	private Command command;
	
	public RightCommandExecuter(Command command) {
		this.command = command;
	}
	
	@Override
	public void execute(CarTable carTable) {
		if ((this.command.isValidCommand())&&(this.command.isLegitimateMove(carTable))) {
			Car car = carTable.getCar();
			Direction next = directionMap.get(car.getFacing());
			car.setFacing(next);
		}

	}

	static {
		directionMap = new HashMap<Direction, Direction>();
		directionMap.put(Direction.EAST, Direction.SOUTH);
		directionMap.put(Direction.SOUTH, Direction.WEST);
		directionMap.put(Direction.WEST, Direction.NORTH);
		directionMap.put(Direction.NORTH, Direction.EAST);
	}
}
