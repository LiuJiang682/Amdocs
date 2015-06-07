package au.com.amdocs.command;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import au.com.amdocs.command.ForwardCommand;
import au.com.amdocs.directions.Direction;
import au.com.amdocs.interf.Car;
import au.com.amdocs.interf.CarTable;

public class ForwardCommandTest {

	private ForwardCommand testInstance;
	
	@Mock
	private CarTable mockCarTable;
	@Mock
	private Car mockCar;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		this.testInstance = new ForwardCommand();
	}
	
	@After
	public void tearDown() {
		this.testInstance = null;
	}
	
	@Test
	public void testGetCommand() {
		assertEquals(CommandEnum.FORWARD, this.testInstance.getCommand());
	}
	
	@Test
	public void testIsValid() {
		assertTrue(this.testInstance.isValidCommand());
	}
	
	@Test
	public void testIsLegitimateMoveNullCar() {
		assertFalse(this.testInstance.isLegitimateMove(mockCarTable));
	}
	
	@Test
	public void testIsLegitimateMoveEast() {
		when(mockCarTable.getCar()).thenReturn(mockCar);
		when(mockCarTable.getMaxX()).thenReturn(5);
		when(mockCar.getFacing()).thenReturn(Direction.EAST);
		when(mockCar.getX()).thenReturn(0);
		assertTrue(this.testInstance.isLegitimateMove(mockCarTable));
	}
	
	@Test
	public void testIsLegitimateMoveEastFalse() {
		when(mockCarTable.getCar()).thenReturn(mockCar);
		when(mockCarTable.getMaxX()).thenReturn(5);
		when(mockCar.getFacing()).thenReturn(Direction.EAST);
		when(mockCar.getX()).thenReturn(5);
		assertFalse(this.testInstance.isLegitimateMove(mockCarTable));
	}
	
	@Test
	public void testIsLegitimateMoveNorth() {
		when(mockCarTable.getCar()).thenReturn(mockCar);
		when(mockCarTable.getMaxY()).thenReturn(5);
		when(mockCar.getFacing()).thenReturn(Direction.NORTH);
		when(mockCar.getY()).thenReturn(0);
		assertTrue(this.testInstance.isLegitimateMove(mockCarTable));
	}
	
	@Test
	public void testIsLegitimateMoveNorthFail() {
		when(mockCarTable.getCar()).thenReturn(mockCar);
		when(mockCarTable.getMaxY()).thenReturn(5);
		when(mockCar.getFacing()).thenReturn(Direction.EAST);
		when(mockCar.getY()).thenReturn(5);
		assertFalse(this.testInstance.isLegitimateMove(mockCarTable));
	}
	
	@Test
	public void testIsLegitimateMoveWest() {
		when(mockCarTable.getCar()).thenReturn(mockCar);
		when(mockCar.getFacing()).thenReturn(Direction.WEST);
		when(mockCar.getX()).thenReturn(1);
		assertTrue(this.testInstance.isLegitimateMove(mockCarTable));
	}
	
	@Test
	public void testIsLegitimateMoveWestFalse() {
		when(mockCarTable.getCar()).thenReturn(mockCar);
		when(mockCar.getFacing()).thenReturn(Direction.WEST);
		when(mockCar.getX()).thenReturn(0);
		assertFalse(this.testInstance.isLegitimateMove(mockCarTable));
	}
	
	@Test
	public void testIsLegitimateMoveSouth() {
		when(mockCarTable.getCar()).thenReturn(mockCar);
		when(mockCar.getFacing()).thenReturn(Direction.SOUTH);
		when(mockCar.getY()).thenReturn(1);
		assertTrue(this.testInstance.isLegitimateMove(mockCarTable));
	}
	
	@Test
	public void testIsLegitimateMoveSouthFalse() {
		when(mockCarTable.getCar()).thenReturn(mockCar);
		when(mockCar.getFacing()).thenReturn(Direction.SOUTH);
		when(mockCar.getY()).thenReturn(0);
		assertFalse(this.testInstance.isLegitimateMove(mockCarTable));
	}
}
