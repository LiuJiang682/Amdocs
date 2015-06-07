package au.com.amdocs.command.factory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Matchers;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import au.com.amdocs.command.factory.CommandConstructFactory;
import au.com.amdocs.command.factory.DoNothingCommandFactory;
import au.com.amdocs.command.factory.TurnLeftCommandFactory;
import au.com.amdocs.command.factory.ForwardCommandFactory;
import au.com.amdocs.command.factory.InitCommandFactory;
import au.com.amdocs.command.factory.GPSReportCommandFactory;
import au.com.amdocs.command.factory.TurnRightCommandFactory;
import au.com.amdocs.command.interf.Command;
import au.com.amdocs.command.interf.CommandFactory;

@RunWith(PowerMockRunner.class)
@PrepareForTest({CommandConstructFactory.class})
public class CommandConstructFactoryTest {

	/**
	 * This test case tests the constructCommand method.
	 * 
	 * @throws Throwable
	 */
	@Test
	public void testConstructCommand() throws Throwable {
		Command mockCommand = PowerMockito.mock(Command.class);
		CommandFactory mockCommandFactory = PowerMockito.mock(CommandFactory.class);
		PowerMockito.mockStatic(CommandConstructFactory.class);
		PowerMockito.doCallRealMethod().when(CommandConstructFactory.class, "constructCommand", Matchers.anyString());
		PowerMockito.doReturn(mockCommandFactory).when(CommandConstructFactory.class, "findCommandFactory", Matchers.anyString());
		PowerMockito.doReturn(mockCommand).when(mockCommandFactory, "buildCommand", Matchers.anyString());
		Command command = CommandConstructFactory.constructCommand("rubbish");
		assertNotNull(command);
		assertEquals(mockCommand, command);
		
		ArgumentCaptor<String> paramCaptor = ArgumentCaptor.forClass(String.class);
		PowerMockito.verifyStatic();
		CommandConstructFactory.constructCommand(paramCaptor.capture());
		assertEquals("rubbish", paramCaptor.getValue());
	}
	
	/**
	 * This test case tests the findCommandFactory method with null string
	 * @throws Throwable
	 */
	@Test
	public void testFindCommandFactoryWithNullString() throws Throwable {
		CommandFactory commandFactory = CommandConstructFactory.findCommandFactory(null);
		assertNotNull(commandFactory);
		assertTrue(commandFactory instanceof DoNothingCommandFactory);
	}
	
	/**
	 * This test case tests the findCommandFactory method with empty string
	 * @throws Throwable
	 */
	@Test
	public void testFindCommandFactoryWithEmptyString() throws Throwable {
		CommandFactory commandFactory = CommandConstructFactory.findCommandFactory("");
		assertNotNull(commandFactory);
		assertTrue(commandFactory instanceof DoNothingCommandFactory);
	}
	
	/**
	 * This test case tests the findCommandFactory method with empty string
	 * @throws Throwable
	 */
	@Test
	public void testFindCommandFactoryWithRubbishString() throws Throwable {
		CommandFactory commandFactory = CommandConstructFactory.findCommandFactory("rubbish");
		assertNotNull(commandFactory);
		assertTrue(commandFactory instanceof DoNothingCommandFactory);
	}
	
	/**
	 * This test case tests the findCommandFactory method with place string
	 * @throws Throwable
	 */
	@Test
	public void testFindCommandFactoryWithInitString() throws Throwable {
		CommandFactory commandFactory = CommandConstructFactory.findCommandFactory("init");
		assertNotNull(commandFactory);
		assertTrue(commandFactory instanceof InitCommandFactory);
	}
	
	/**
	 * This test case tests the findCommandFactory method with move string
	 * @throws Throwable
	 */
	@Test
	public void testFindCommandFactoryWithForwardString() throws Throwable {
		CommandFactory commandFactory = CommandConstructFactory.findCommandFactory("forward");
		assertNotNull(commandFactory);
		assertTrue(commandFactory instanceof ForwardCommandFactory);
	}
	
	/**
	 * This test case tests the findCommandFactory method with move string
	 * @throws Throwable
	 */
	@Test
	public void testFindCommandFactoryWithIncorrectForwardString() throws Throwable {
		CommandFactory commandFactory = CommandConstructFactory.findCommandFactory("Forward xx");
		assertNotNull(commandFactory);
		assertTrue(commandFactory instanceof DoNothingCommandFactory);
	}
	
	/**
	 * This test case tests the findCommandFactory method with left string
	 * @throws Throwable
	 */
	@Test
	public void testFindCommandFactoryWithTurnLeftString() throws Throwable {
		CommandFactory commandFactory = CommandConstructFactory.findCommandFactory("turn_left");
		assertNotNull(commandFactory);
		assertTrue(commandFactory instanceof TurnLeftCommandFactory);
	}
	
	/**
	 * This test case tests the findCommandFactory method with left string
	 * @throws Throwable
	 */
	@Test
	public void testFindCommandFactoryWithIncorrectTurnLeftString() throws Throwable {
		CommandFactory commandFactory = CommandConstructFactory.findCommandFactory("turn_left xx");
		assertNotNull(commandFactory);
		assertTrue(commandFactory instanceof DoNothingCommandFactory);
	}
	
	/**
	 * This test case tests the findCommandFactory method with right string
	 * @throws Throwable
	 */
	@Test
	public void testFindCommandFactoryWithTurnRightString() throws Throwable {
		CommandFactory commandFactory = CommandConstructFactory.findCommandFactory("turn_right");
		assertNotNull(commandFactory);
		assertTrue(commandFactory instanceof TurnRightCommandFactory);
	}
	
	/**
	 * This test case tests the findCommandFactory method with right string
	 * @throws Throwable
	 */
	@Test
	public void testFindCommandFactoryWithIncorrectTurnRightString() throws Throwable {
		CommandFactory commandFactory = CommandConstructFactory.findCommandFactory("turn_right xx");
		assertNotNull(commandFactory);
		assertTrue(commandFactory instanceof DoNothingCommandFactory);
	}
	
	/**
	 * This test case tests the findCommandFactory method with right string
	 * @throws Throwable
	 */
	@Test
	public void testFindCommandFactoryWithGPSReportString() throws Throwable {
		CommandFactory commandFactory = CommandConstructFactory.findCommandFactory("GPS_report");
		assertNotNull(commandFactory);
		assertTrue(commandFactory instanceof GPSReportCommandFactory);
	}
	
	/**
	 * This test case tests the findCommandFactory method with right string
	 * @throws Throwable
	 */
	@Test
	public void testFindCommandFactoryWithIncorrectGPSReportString() throws Throwable {
		CommandFactory commandFactory = CommandConstructFactory.findCommandFactory("gps_report xx");
		assertNotNull(commandFactory);
		assertTrue(commandFactory instanceof DoNothingCommandFactory);
	}
}
