package au.com.amdocs.command.factory;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import au.com.amdocs.command.ReportCommand;
import au.com.amdocs.command.factory.ReportCommandFactory;
import au.com.amdocs.command.interf.Command;
import au.com.amdocs.command.interf.CommandFactory;

public class ReportCommandFactoryTest {

	@Test
	public void testBuildCommand() {
		CommandFactory commandFactory = new ReportCommandFactory();
		Command command = commandFactory.buildCommand(null);
		assertNotNull(command);
		assertTrue(command instanceof ReportCommand);
	}

}
