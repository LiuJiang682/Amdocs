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
import au.com.amdocs.command.LeftCommand;
import au.com.amdocs.command.MoveCommand;
import au.com.amdocs.command.PlaceCommand;
import au.com.amdocs.command.ReportCommand;
import au.com.amdocs.command.RightCommand;
import au.com.amdocs.command.interf.Command;
import au.com.amdocs.command.interf.CommandExecuter;
import au.com.amdocs.command.interf.ExecuterFactory;
import au.com.amdocs.executer.factory.DoNothingExecutorFactory;
import au.com.amdocs.executer.factory.ExecuterConstructFactory;
import au.com.amdocs.executer.factory.LeftCommandExecuterFactory;
import au.com.amdocs.executer.factory.MoveCommandExecuterFactory;
import au.com.amdocs.executer.factory.PlaceCommandExecuterFactory;
import au.com.amdocs.executer.factory.ReportCommandExecuterFactory;
import au.com.amdocs.executer.factory.RightCommandExecuterFactory;
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
		Command command = new PlaceCommand(null);
		ExecuterFactory factory = ExecuterConstructFactory.findExecuterFactory(command);
		assertNotNull(factory);
		assertTrue(factory instanceof PlaceCommandExecuterFactory);
	}
	
	@Test
	public void testFindExecuterFactoryMove() {
		Command command = new MoveCommand();
		ExecuterFactory factory = ExecuterConstructFactory.findExecuterFactory(command);
		assertNotNull(factory);
		assertTrue(factory instanceof MoveCommandExecuterFactory);
	}
	
	@Test
	public void testFindExecuterFactoryLeft() {
		Command command = new LeftCommand();
		ExecuterFactory factory = ExecuterConstructFactory.findExecuterFactory(command);
		assertNotNull(factory);
		assertTrue(factory instanceof LeftCommandExecuterFactory);
	}
	
	@Test
	public void testFindExecuterFactoryRight() {
		Command command = new RightCommand();
		ExecuterFactory factory = ExecuterConstructFactory.findExecuterFactory(command);
		assertNotNull(factory);
		assertTrue(factory instanceof RightCommandExecuterFactory);
	}
	
	@Test
	public void testFindExecuterFactoryReport() {
		Command command = new ReportCommand();
		ExecuterFactory factory = ExecuterConstructFactory.findExecuterFactory(command);
		assertNotNull(factory);
		assertTrue(factory instanceof ReportCommandExecuterFactory);
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
