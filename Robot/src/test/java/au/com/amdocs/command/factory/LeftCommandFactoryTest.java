package au.com.amdocs.command.factory;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import au.com.amdocs.command.LeftCommand;
import au.com.amdocs.command.factory.LeftCommandFactory;
import au.com.amdocs.command.interf.Command;
import au.com.amdocs.command.interf.CommandFactory;

public class LeftCommandFactoryTest {

	@Test
	public void testBuildCommand() {
		CommandFactory commandFactory = new LeftCommandFactory();
		Command command = commandFactory.buildCommand(null);
		assertNotNull(command);
		assertTrue(command instanceof LeftCommand);
	}
}
