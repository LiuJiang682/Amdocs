package au.com.amdocs.executer;

import java.io.Serializable;

import au.com.amdocs.car.AmdocsCar;
import au.com.amdocs.command.InitCommand;
import au.com.amdocs.command.interf.Command;
import au.com.amdocs.command.interf.CommandExecuter;
import au.com.amdocs.interf.Car;
import au.com.amdocs.interf.CarTable;

/**
 * The Init command executer class.
 * @author Jiang Liu
 *
 */
public class InitCommandExecuter implements CommandExecuter, Serializable {

	/**
	 * Generated Serial Version UID.
	 */
	private static final long serialVersionUID = 8951888378145500628L;

	private Command command;
	
	public InitCommandExecuter(InitCommand command) {
		this.command = command;
	}
	
	@Override
	public void execute(CarTable carTable) {
		if ((this.command.isValidCommand())&&(this.command.isLegitimateMove(carTable))) {
			Car car = carTable.getCar();
			if (car == null) {
				//First command! Build the car with parameters
				car  = new AmdocsCar();
				car.setX(((InitCommand)this.command).getX());
				car.setY(((InitCommand)this.command).getY());
				car.setFacing(((InitCommand)this.command).getFacing());
				carTable.setCar(car);
			} else {
				car.setX(((InitCommand)this.command).getX());
				car.setY(((InitCommand)this.command).getY());
				car.setFacing(((InitCommand)this.command).getFacing());
			}
		}
	}

}
