package au.com.amdocs.executer;

import java.io.Serializable;

import au.com.amdocs.command.interf.Command;
import au.com.amdocs.command.interf.CommandExecuter;
import au.com.amdocs.interf.Car;
import au.com.amdocs.interf.CarTable;

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
	public void execute(CarTable carTable) {
		if ((this.command.isValidCommand())&&(this.command.isLegitimateMove(carTable))) {
			Car car = carTable.getCar();
			System.out.println(car.getX() + ", " + car.getY() + ", " + car.getFacing());
		}
	}

}
