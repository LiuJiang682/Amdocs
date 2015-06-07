package au.com.amdocs.executer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import au.com.amdocs.AmdocsCarTable;
import au.com.amdocs.car.AmdocsCar;
import au.com.amdocs.command.interf.Command;
import au.com.amdocs.directions.Direction;
import au.com.amdocs.executer.DoNothingExecuter;
import au.com.amdocs.interf.CarTable;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ CarTable.class })
public class DoNothingExecuterTest {

	@Mock
	private Command mockCommand;

	private DoNothingExecuter testInstance;
	private AmdocsCarTable carTable;
	private AmdocsCar car;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		this.testInstance = new DoNothingExecuter();
		this.car = new AmdocsCar();
		this.carTable = new AmdocsCarTable();
		this.carTable.setCar(car);
	}

	@After
	public void tearDown() {
		this.testInstance = null;
		this.carTable = null;
		this.car = null;
	}

	@Test
	public void testConstructor() {
		assertNotNull(new DoNothingExecuter());
	}

	@Test
	public void testExecuteEast() {
		givenCommand();
		this.car.setFacing(Direction.EAST);

		this.testInstance.execute(carTable);

		assertEquals(Direction.EAST, this.car.getFacing());
	}

	private void givenCommand() {
		when(this.mockCommand.isValidCommand()).thenReturn(true);
		when(this.mockCommand.isLegitimateMove(carTable)).thenReturn(true);
	}

	@Test
	public void testExecuteNorth() {
		givenCommand();
		this.car.setFacing(Direction.NORTH);

		this.testInstance.execute(carTable);

		assertEquals(Direction.NORTH, this.car.getFacing());
	}

	@Test
	public void testExecuteWest() {
		givenCommand();
		this.car.setFacing(Direction.WEST);

		this.testInstance.execute(carTable);

		assertEquals(Direction.WEST, this.car.getFacing());
	}

	@Test
	public void testExecuteSouth() {
		givenCommand();
		this.car.setFacing(Direction.SOUTH);

		this.testInstance.execute(carTable);

		assertEquals(Direction.SOUTH, this.car.getFacing());
	}

	@Test
	public void testExecuteInvalidCommand() {
		when(this.mockCommand.isValidCommand()).thenReturn(false);
		when(this.mockCommand.isLegitimateMove(carTable)).thenReturn(true);

		this.car.setFacing(Direction.SOUTH);

		this.testInstance.execute(carTable);

		assertEquals(Direction.SOUTH, this.car.getFacing());
	}
	
	@Test
	public void testExecuteIllegalCommand() {
		when(this.mockCommand.isValidCommand()).thenReturn(true);
		when(this.mockCommand.isLegitimateMove(carTable)).thenReturn(false);

		this.car.setFacing(Direction.SOUTH);

		this.testInstance.execute(carTable);

		assertEquals(Direction.SOUTH, this.car.getFacing());
	}
	
	@Test
	public void testExecuteInvalidIllegalCommand() {
		when(this.mockCommand.isValidCommand()).thenReturn(false);
		when(this.mockCommand.isLegitimateMove(carTable)).thenReturn(false);

		this.car.setFacing(Direction.SOUTH);

		this.testInstance.execute(carTable);

		assertEquals(Direction.SOUTH, this.car.getFacing());
	}
}
