package au.com.amdocs.command.factory;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import au.com.amdocs.command.MoveCommand;
import au.com.amdocs.command.factory.MoveCommandFactory;
import au.com.amdocs.command.interf.Command;

public class MoveCommandFactoryTest {

	@Test
	public void testBuildCommand() {
		MoveCommandFactory factory = new MoveCommandFactory();
		Command command = factory.buildCommand(null);
		assertNotNull(command);
		assertTrue(command instanceof MoveCommand);
	}
}
