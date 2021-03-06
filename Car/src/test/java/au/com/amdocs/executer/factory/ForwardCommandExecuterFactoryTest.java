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
import au.com.amdocs.executer.ForwardEastCommandExecuter;
import au.com.amdocs.executer.ForwardNorthCommandExecuter;
import au.com.amdocs.executer.ForwardSouthCommandExecuter;
import au.com.amdocs.executer.ForwardWestCommandExecuter;
import au.com.amdocs.executer.factory.ForwardCommandExecuterFactory;
import au.com.amdocs.interf.Car;

public class ForwardCommandExecuterFactoryTest {

	private ForwardCommandExecuterFactory testInstance;
	
	@Mock
	private Command mockCommand;
	@Mock
	private Car mockCar;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		this.testInstance = new ForwardCommandExecuterFactory();
	}
	
	@After
	public void tearDown() {
		this.testInstance = null;
	}
	
	@Test
	public void testBuildExecuterNullCar() {
		CommandExecuter executer = this.testInstance.buildExecuter(mockCommand, null);
		assertTrue (executer instanceof DoNothingExecuter);
	}
	
	@Test
	public void testBuildExecuterEast() {
		when(mockCar.getFacing()).thenReturn(Direction.EAST);
		CommandExecuter executer = this.testInstance.buildExecuter(mockCommand, mockCar);
		assertTrue (executer instanceof ForwardEastCommandExecuter);
	}
	
	@Test
	public void testBuildExecuterNorth() {
		when(mockCar.getFacing()).thenReturn(Direction.NORTH);
		CommandExecuter executer = this.testInstance.buildExecuter(mockCommand, mockCar);
		assertTrue (executer instanceof ForwardNorthCommandExecuter);
	}
	
	@Test
	public void testBuildExecuterWest() {
		when(mockCar.getFacing()).thenReturn(Direction.WEST);
		CommandExecuter executer = this.testInstance.buildExecuter(mockCommand, mockCar);
		assertTrue (executer instanceof ForwardWestCommandExecuter);
	}
	
	@Test
	public void testBuildExecuterSouth() {
		when(mockCar.getFacing()).thenReturn(Direction.SOUTH);
		CommandExecuter executer = this.testInstance.buildExecuter(mockCommand, mockCar);
		assertTrue (executer instanceof ForwardSouthCommandExecuter);
	}
}
