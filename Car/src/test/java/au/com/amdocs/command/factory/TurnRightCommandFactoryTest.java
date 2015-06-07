package au.com.amdocs.command.factory;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import au.com.amdocs.command.TurnRightCommand;
import au.com.amdocs.command.factory.TurnRightCommandFactory;
import au.com.amdocs.command.interf.Command;
import au.com.amdocs.command.interf.CommandFactory;

public class TurnRightCommandFactoryTest {

	@Test
	public void testBuildCommand() {
		CommandFactory commandFactory = new TurnRightCommandFactory();
		Command command = commandFactory.buildCommand(null);
		assertNotNull(command);
		assertTrue(command instanceof TurnRightCommand);
	}
}
