package au.com.amdocs.executer;

import java.io.Serializable;

import au.com.amdocs.car.AmdocsCar;
import au.com.amdocs.command.PlaceCommand;
import au.com.amdocs.command.interf.Command;
import au.com.amdocs.command.interf.CommandExecuter;
import au.com.amdocs.interf.Car;
import au.com.amdocs.interf.CarTable;

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
	public void execute(CarTable carTable) {
		if ((this.command.isValidCommand())&&(this.command.isLegitimateMove(carTable))) {
			Car car = carTable.getCar();
			if (car == null) {
				//First command! Build the car with parameters
				car  = new AmdocsCar();
				car.setX(((PlaceCommand)this.command).getX());
				car.setY(((PlaceCommand)this.command).getY());
				car.setFacing(((PlaceCommand)this.command).getFacing());
				carTable.setCar(car);
			} else {
				car.setX(((PlaceCommand)this.command).getX());
				car.setY(((PlaceCommand)this.command).getY());
				car.setFacing(((PlaceCommand)this.command).getFacing());
			}
		}
	}

}
