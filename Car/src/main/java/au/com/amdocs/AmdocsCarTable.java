package au.com.amdocs;

import java.io.Serializable;
import java.util.Scanner;

import au.com.amdocs.command.factory.CommandConstructFactory;
import au.com.amdocs.command.interf.Command;
import au.com.amdocs.command.interf.CommandExecuter;
import au.com.amdocs.executer.factory.ExecuterConstructFactory;
import au.com.amdocs.interf.Car;
import au.com.amdocs.interf.CarTable;

public class AmdocsCarTable implements CarTable, Serializable {

	/**
	 * Generated Serial Version UID.
	 */
	private static final long serialVersionUID = -7453796625968290202L;

	private static final int MAX_X = 5;
	private static final int MAX_Y = 5;

	private Car car;

	// default constructor
	public AmdocsCarTable() {

	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	@Override
	public int getMaxX() {
		return MAX_X;
	}

	@Override
	public int getMaxY() {
		return MAX_Y;
	}

	/**
	 * This method returns a command object. It use abstract factory pattern to
	 * create factory object and than the factory object creates command object.
	 *
	 * @return command object.
	 */
	public Command getNextCommand(final Scanner scanner) {
		Command command = null;

		// User interactive mode
		System.out.println("Please enter your command: ");
		String userEntered = scanner.nextLine();
		command = CommandConstructFactory.constructCommand(userEntered);

		return command;
	}

	/**
	 * This method returns a command executer object which will execute the
	 * command.
	 * 
	 * @param command
	 *            the command.
	 * @param car
	 *            the car.
	 * @return the executer.
	 */
	public CommandExecuter getExecuter(Command command, Car car) {

		return ExecuterConstructFactory.contructExecuter(command, car);
	}
	
	public Scanner getScanner() {
		Scanner scanner = new Scanner(System.in);
		return scanner;
	}

	public void run() {
		Command command = null;

		Scanner scanner = getScanner();
		try {
			/**
			 * May consider use queue here for large work load.
			 */
			while ((command = getNextCommand(scanner)) != null) {
				if (command.isValidCommand()) {
					CommandExecuter executer = getExecuter(command, getCar());
					executer.execute(this);
				}
			}
		} finally {
			scanner.close();
		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AmdocsCarTable table = new AmdocsCarTable();
		table.run();
	}

}
