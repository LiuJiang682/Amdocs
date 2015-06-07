package au.com.amdocs.executer.factory;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import au.com.amdocs.command.interf.Command;
import au.com.amdocs.command.interf.CommandExecuter;
import au.com.amdocs.directions.Direction;
import au.com.amdocs.executer.DoNothingExecuter;
import au.com.amdocs.executer.MoveEastCommandExecuter;
import au.com.amdocs.executer.MoveNorthCommandExecuter;
import au.com.amdocs.executer.MoveSouthCommandExecuter;
import au.com.amdocs.executer.MoveWestCommandExecuter;
import au.com.amdocs.executer.factory.MoveCommandExecuterFactory;
import au.com.amdocs.interf.Robot;

public class MoveCommandExecuterFactoryTest {

	private MoveCommandExecuterFactory testInstance;
	
	@Mock
	private Command mockCommand;
	@Mock
	private Robot mockRobot;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		this.testInstance = new MoveCommandExecuterFactory();
	}
	
	@After
	public void tearDown() {
		this.testInstance = null;
	}
	
	@Test
	public void testBuildExecuterNullRobot() {
		CommandExecuter executer = this.testInstance.buildExecuter(mockCommand, null);
		assertTrue (executer instanceof DoNothingExecuter);
	}
	
	@Test
	public void testBuildExecuterEast() {
		when(mockRobot.getFacing()).thenReturn(Direction.EAST);
		CommandExecuter executer = this.testInstance.buildExecuter(mockCommand, mockRobot);
		assertTrue (executer instanceof MoveEastCommandExecuter);
	}
	
	@Test
	public void testBuildExecuterNorth() {
		when(mockRobot.getFacing()).thenReturn(Direction.NORTH);
		CommandExecuter executer = this.testInstance.buildExecuter(mockCommand, mockRobot);
		assertTrue (executer instanceof MoveNorthCommandExecuter);
	}
	
	@Test
	public void testBuildExecuterWest() {
		when(mockRobot.getFacing()).thenReturn(Direction.WEST);
		CommandExecuter executer = this.testInstance.buildExecuter(mockCommand, mockRobot);
		assertTrue (executer instanceof MoveWestCommandExecuter);
	}
	
	@Test
	public void testBuildExecuterSouth() {
		when(mockRobot.getFacing()).thenReturn(Direction.SOUTH);
		CommandExecuter executer = this.testInstance.buildExecuter(mockCommand, mockRobot);
		assertTrue (executer instanceof MoveSouthCommandExecuter);
	}
}