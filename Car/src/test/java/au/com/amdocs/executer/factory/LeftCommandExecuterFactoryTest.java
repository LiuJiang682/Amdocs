package au.com.amdocs.executer.factory;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import au.com.amdocs.command.interf.CommandExecuter;
import au.com.amdocs.command.interf.ExecuterFactory;
import au.com.amdocs.executer.LeftCommandExecuter;
import au.com.amdocs.executer.factory.LeftCommandExecuterFactory;

public class LeftCommandExecuterFactoryTest {

	@Test
	public void testBuildExecuter() {
		ExecuterFactory factory = new LeftCommandExecuterFactory();
		CommandExecuter executer = factory.buildExecuter(null, null);
		assertNotNull(executer);
		assertTrue(executer instanceof LeftCommandExecuter);
	}
}
