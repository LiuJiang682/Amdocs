package au.com.amdocs.command;

import java.io.Serializable;

import au.com.amdocs.command.interf.Command;
import au.com.amdocs.common.CommonConstants;
import au.com.amdocs.directions.Direction;
import au.com.amdocs.interf.CarTable;

public class InitCommand implements Command, Serializable {

	/**
	 * Generated Serial Version UID. 
	 */
	private static final long serialVersionUID = 7705090543914283008L;

	private int x;
	private int y;
	private Direction facing;
	private boolean valid;
	private String orginal;
	
	// Constructor for invalid command.
	public InitCommand(String commandString) {
		this.orginal = commandString;
		this.valid = false;
	}
	
	// Constructor for correct format place command
	public InitCommand(String commandString, String paramString) {
		this.orginal = commandString;
		
		String[] params = paramString.split(CommonConstants.PARAM_DELIM);
		if ((params == null)||(params.length != CommonConstants.THREE)) {
			// The parameter string is not in correct format,
			// set the valid flag to false.
			this.valid = false;
		} else {
			try {
				this.x = Integer.parseInt(params[CommonConstants.ZERO].trim());
				this.y = Integer.parseInt(params[CommonConstants.ONE].trim());
			} catch (NumberFormatException e) {
				// Cannot convert to x and y, 
				// set the valid flag to false.
				this.valid = false;
				return;
			}
			
			// Do facing convention
			try {
				this.facing = Direction.valueOf(params[CommonConstants.TWO].trim().toUpperCase());
				this.valid = true;
			} catch (Exception e) {
				System.out.println("Unknown direction: " + params[CommonConstants.TWO]);
				// Cannot convent to facing
				// set the valid flag to false
				this.valid = false;
			}
		}
	}
	
	@Override
	public CommandEnum getCommand() {
		return CommandEnum.INIT;
	}

	@Override
	public boolean isLegitimateMove(CarTable carTable) {
		boolean valid = false;
		if ((CommonConstants.ZERO <= getX())&&(getX() <= carTable.getMaxX())) {
			if ((CommonConstants.ZERO <= getY())&&(getY() <= carTable.getMaxY())) {
				valid = true;
			}
		}
		return valid;
	}

	@Override
	public boolean isValidCommand() {
		return this.valid;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Direction getFacing() {
		return facing;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder(this.orginal);
		sb.append(", valid ");
		sb.append(this.valid);
		return sb.toString();
	}
}
