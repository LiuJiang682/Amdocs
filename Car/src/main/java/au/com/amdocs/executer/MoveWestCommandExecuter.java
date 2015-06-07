package au.com.amdocs.executer;

import java.io.Serializable;

import au.com.amdocs.command.interf.Command;
import au.com.amdocs.command.interf.CommandExecuter;
import au.com.amdocs.interf.Car;
import au.com.amdocs.interf.CarTable;

public class MoveWestCommandExecuter implements CommandExecuter, Serializable {

	/**
	 * Generated Serial Version UID.
	 */
	private static final long serialVersionUID = -6280454842884735930L;

	private Command command;
	
	public MoveWestCommandExecuter(Command command) {
		this.command = command;
	}
	
	@Override
	public void execute(CarTable carTable) {
		if ((this.command.isValidCommand())&&(this.command.isLegitimateMove(carTable))) {
			Car car = carTable.getCar();
			int x = car.getX();
			--x;
			car.setX(x);
		}
	}

}
