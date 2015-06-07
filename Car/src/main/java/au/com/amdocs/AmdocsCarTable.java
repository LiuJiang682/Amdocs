package au.com.amdocs;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.Scanner;

import au.com.amdocs.command.QuitCommand;
import au.com.amdocs.command.factory.CommandConstructFactory;
import au.com.amdocs.command.interf.Command;
import au.com.amdocs.command.interf.CommandExecuter;
import au.com.amdocs.common.CommonConstants;
import au.com.amdocs.common.StringUtils;
import au.com.amdocs.executer.factory.ExecuterConstructFactory;
import au.com.amdocs.interf.Car;
import au.com.amdocs.interf.CarTable;

public class AmdocsCarTable implements CarTable, Serializable {

	/**
	 * Generated Serial Version UID.
	 */
	private static final long serialVersionUID = -7453796625968290202L;

	private static final String COMMENT_PREFIX = "#";

	private static final int MAX_X = 5;
	private static final int MAX_Y = 5;

	private Car car;
	private String dataFileName;
	private boolean userInativeMode = true;

	// default constructor
	public AmdocsCarTable() {

	}

	public AmdocsCarTable(final String dataFileName) {
		this.dataFileName = dataFileName;
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

		if (this.userInativeMode) {
			// User interactive mode
			System.out.println("Please enter your command: ");
		}
	
		String data = null;
		do {
			data = scanner.nextLine();
		}
		while ((StringUtils.isNullOrEmpty(data)) || (data.startsWith(COMMENT_PREFIX)));
			
		command = CommandConstructFactory.constructCommand(data);

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
		Scanner scanner = null;

		if (StringUtils.isNullOrEmpty(this.dataFileName)) {
			scanner = new Scanner(System.in);
		} else {
			File dataFile = new File(this.dataFileName);

			try {
				scanner = new Scanner(dataFile);
				this.userInativeMode = false;
			} catch (FileNotFoundException e) {
				System.out.println("Cannot load data file: "
						+ this.dataFileName + "! Default to user enter mode.");
				scanner = new Scanner(System.in);
			}
		}
		return scanner;
	}

	public boolean isUserInativeMode() {
		return userInativeMode;
	}

	public void run() {
		Command command = null;

		Scanner scanner = getScanner();
		try {
			do {
				command = getNextCommand(scanner);
				if (command.isValidCommand()) {
					CommandExecuter executer = getExecuter(command, getCar());
					executer.execute(this);
				}
			} while (!(command instanceof QuitCommand));
		} finally {
			scanner.close();
		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AmdocsCarTable table = null;
		if (StringUtils.isNullOrEmptyArray(args)) {
			table = new AmdocsCarTable();
		} else {
			table = new AmdocsCarTable(args[CommonConstants.ZERO]);
		}

		table.run();
	}

}
