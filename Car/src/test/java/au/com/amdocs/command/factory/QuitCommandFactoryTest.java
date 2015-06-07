package au.com.amdocs.command.factory;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import au.com.amdocs.command.QuitCommand;
import au.com.amdocs.command.interf.Command;

public class QuitCommandFactoryTest {

	@Test
	public void testBuildCommand() {
		QuitCommandFactory factory = new QuitCommandFactory();
		Command command = factory.buildCommand(null);
		assertNotNull(command);
		assertTrue(command instanceof QuitCommand);
	}
}
