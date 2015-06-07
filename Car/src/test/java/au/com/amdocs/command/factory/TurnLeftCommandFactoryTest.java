package au.com.amdocs.command.factory;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import au.com.amdocs.command.TurnLeftCommand;
import au.com.amdocs.command.factory.TurnLeftCommandFactory;
import au.com.amdocs.command.interf.Command;
import au.com.amdocs.command.interf.CommandFactory;

public class TurnLeftCommandFactoryTest {

	@Test
	public void testBuildCommand() {
		CommandFactory commandFactory = new TurnLeftCommandFactory();
		Command command = commandFactory.buildCommand(null);
		assertNotNull(command);
		assertTrue(command instanceof TurnLeftCommand);
	}
}
