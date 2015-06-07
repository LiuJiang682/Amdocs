package au.com.amdocs.executer.factory;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import au.com.amdocs.command.interf.CommandExecuter;
import au.com.amdocs.command.interf.ExecuterFactory;
import au.com.amdocs.executer.DoNothingExecuter;
import au.com.amdocs.executer.factory.DoNothingExecutorFactory;

public class DoNothingExecuterFactoryTest {

	@Test
	public void testBuildExecuter() {
		ExecuterFactory factory = new DoNothingExecutorFactory();
		CommandExecuter executer = factory.buildExecuter(null, null);
		assertNotNull(executer);
		assertTrue(executer instanceof DoNothingExecuter);
	}
}
