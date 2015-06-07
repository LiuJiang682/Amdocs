package au.com.amdocs.command.factory;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import au.com.amdocs.command.GPSReportCommand;
import au.com.amdocs.command.factory.GPSReportCommandFactory;
import au.com.amdocs.command.interf.Command;
import au.com.amdocs.command.interf.CommandFactory;

public class GPSReportCommandFactoryTest {

	@Test
	public void testBuildCommand() {
		CommandFactory commandFactory = new GPSReportCommandFactory();
		Command command = commandFactory.buildCommand(null);
		assertNotNull(command);
		assertTrue(command instanceof GPSReportCommand);
	}

}
