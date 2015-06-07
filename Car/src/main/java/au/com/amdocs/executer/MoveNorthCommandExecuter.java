package au.com.amdocs.executer;

import java.io.Serializable;

import au.com.amdocs.command.interf.Command;
import au.com.amdocs.command.interf.CommandExecuter;
import au.com.amdocs.interf.Car;
import au.com.amdocs.interf.CarTable;

public class MoveNorthCommandExecuter implements CommandExecuter, Serializable {

	/**
	 * Generated Serial Version UID.
	 */
	private static final long serialVersionUID = -2860515768804752231L;

	private Command command;
	
	public MoveNorthCommandExecuter(Command command) {
		this.command = command;
	}
	
	@Override
	public void execute(CarTable carTable) {
		if ((this.command.isValidCommand())&&(this.command.isLegitimateMove(carTable))) {
			Car car = carTable.getCar();
			int y = car.getY();
			++y;
			car.setY(y);
		}

	}

}
