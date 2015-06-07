package au.com.amdocs.command;

import java.io.Serializable;

import au.com.amdocs.command.interf.Command;
import au.com.amdocs.interf.CarTable;

public class QuitCommand implements Command, Serializable {

	/**
	 * Generated serial version UID.
	 */
	private static final long serialVersionUID = -4966488908536364765L;

	@Override
	public boolean isValidCommand() {
		return false;
	}

	@Override
	public boolean isLegitimateMove(CarTable carTable) {
		return false;
	}

	@Override
	public CommandEnum getCommand() {
		return CommandEnum.QUIT;
	}

}
