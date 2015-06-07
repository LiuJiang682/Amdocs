package au.com.amdocs.command.factory;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import au.com.amdocs.command.ForwardCommand;
import au.com.amdocs.command.factory.ForwardCommandFactory;
import au.com.amdocs.command.interf.Command;

public class ForwardCommandFactoryTest {

	@Test
	public void testBuildCommand() {
		ForwardCommandFactory factory = new ForwardCommandFactory();
		Command command = factory.buildCommand(null);
		assertNotNull(command);
		assertTrue(command instanceof ForwardCommand);
	}
}
