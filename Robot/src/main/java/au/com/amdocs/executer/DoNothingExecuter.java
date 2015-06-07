package au.com.amdocs.executer;

import java.io.Serializable;

import au.com.amdocs.command.interf.CommandExecuter;
import au.com.amdocs.interf.RobotTable;

/**
 * The do nothing executer.
 * @author Jiang Liu
 *
 */
public class DoNothingExecuter implements CommandExecuter, Serializable {

	/**
	 * Generated Serial Version UID. 
	 */
	private static final long serialVersionUID = 8495723075437017943L;

	@Override
	public void execute(RobotTable robotTable) {
		//Do Nothing.
	}

}
