package au.com.amdocs.executer.factory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import au.com.amdocs.command.DoNothingCommand;
import au.com.amdocs.command.TurnLeftCommand;
import au.com.amdocs.command.ForwardCommand;
import au.com.amdocs.command.InitCommand;
import au.com.amdocs.command.GPSReportCommand;
import au.com.amdocs.command.TurnRightCommand;
import au.com.amdocs.command.interf.Command;
import au.com.amdocs.command.interf.CommandExecuter;
import au.com.amdocs.command.interf.ExecuterFactory;
import au.com.amdocs.executer.factory.DoNothingExecutorFactory;
import au.com.amdocs.executer.factory.ExecuterConstructFactory;
import au.com.amdocs.executer.factory.TurnLeftCommandExecuterFactory;
import au.com.amdocs.executer.factory.ForwardCommandExecuterFactory;
import au.com.amdocs.executer.factory.InitCommandExecuterFactory;
import au.com.amdocs.executer.factory.GPSReportCommandExecuterFactory;
import au.com.amdocs.executer.factory.TurnRightCommandExecuterFactory;
import au.com.amdocs.interf.Car;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ ExecuterConstructFactory.class, ExecuterFactory.class, CommandExecuter.class})
public class ExecuterConstructFactoryTest {

	@Test
	public void testFindExecuterFactory() {
		Command command = new DoNothingCommand();
		ExecuterFactory factory = ExecuterConstructFactory.findExecuterFactory(command);
		assertNotNull(factory);
		assertTrue(factory instanceof DoNothingExecutorFactory);
	}
	
	@Test
	public void testFindExecuterFactoryPlace() {
		Command command = new InitCommand(null);
		ExecuterFactory factory = ExecuterConstructFactory.findExecuterFactory(command);
		assertNotNull(factory);
		assertTrue(factory instanceof InitCommandExecuterFactory);
	}
	
	@Test
	public void testFindExecuterFactoryMove() {
		Command command = new ForwardCommand();
		ExecuterFactory factory = ExecuterConstructFactory.findExecuterFactory(command);
		assertNotNull(factory);
		assertTrue(factory instanceof ForwardCommandExecuterFactory);
	}
	
	@Test
	public void testFindExecuterFactoryLeft() {
		Command command = new TurnLeftCommand();
		ExecuterFactory factory = ExecuterConstructFactory.findExecuterFactory(command);
		assertNotNull(factory);
		assertTrue(factory instanceof TurnLeftCommandExecuterFactory);
	}
	
	@Test
	public void testFindExecuterFactoryRight() {
		Command command = new TurnRightCommand();
		ExecuterFactory factory = ExecuterConstructFactory.findExecuterFactory(command);
		assertNotNull(factory);
		assertTrue(factory instanceof TurnRightCommandExecuterFactory);
	}
	
	@Test
	public void testFindExecuterFactoryReport() {
		Command command = new GPSReportCommand();
		ExecuterFactory factory = ExecuterConstructFactory.findExecuterFactory(command);
		assertNotNull(factory);
		assertTrue(factory instanceof GPSReportCommandExecuterFactory);
	}
	
	@Test
	public void testContructExecuter() throws Exception {
		PowerMockito.mockStatic(ExecuterConstructFactory.class);
		PowerMockito.doCallRealMethod().when(ExecuterConstructFactory.class, "contructExecuter", Matchers.any(Command.class), Matchers.any(Car.class));
		ExecuterFactory mockExecuterFactory = PowerMockito.mock(ExecuterFactory.class);
		PowerMockito.doReturn(mockExecuterFactory).when(ExecuterConstructFactory.class, "findExecuterFactory", Matchers.any(Command.class));
		CommandExecuter mockCommandExecuter = PowerMockito.mock(CommandExecuter.class);
		PowerMockito.doReturn(mockCommandExecuter).when(mockExecuterFactory, "buildExecuter", Matchers.any(Command.class), Matchers.any(Car.class));
		
		assertEquals(mockCommandExecuter, ExecuterConstructFactory.contructExecuter(null, null));
	}
}
