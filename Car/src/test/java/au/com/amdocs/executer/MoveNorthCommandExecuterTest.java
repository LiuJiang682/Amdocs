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
import au.com.amdocs.executer.MoveNorthCommandExecuter;
import au.com.amdocs.interf.CarTable;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ CarTable.class })
public class MoveNorthCommandExecuterTest {

	@Mock
	private Command mockCommand;

	private MoveNorthCommandExecuter testInstance;
	private AmdocsCarTable carTable;
	private AmdocsCar car;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		this.testInstance = new MoveNorthCommandExecuter(this.mockCommand);
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
		assertNotNull(new MoveNorthCommandExecuter(this.mockCommand));
	}

	@Test
	public void testExecute() {
		givenCommand();
		assertEquals(0, this.car.getY());

		this.testInstance.execute(carTable);

		assertEquals(1, this.car.getY());
	}

	private void givenCommand() {
		when(this.mockCommand.isValidCommand()).thenReturn(true);
		when(this.mockCommand.isLegitimateMove(carTable)).thenReturn(true);
	}

	@Test
	public void testExecuteInvalidCommand() {
		when(this.mockCommand.isValidCommand()).thenReturn(false);
		when(this.mockCommand.isLegitimateMove(carTable)).thenReturn(true);

		assertEquals(0, this.car.getY());

		this.testInstance.execute(carTable);

		assertEquals(0, this.car.getY());
	}
	
	@Test
	public void testExecuteIllegalCommand() {
		when(this.mockCommand.isValidCommand()).thenReturn(true);
		when(this.mockCommand.isLegitimateMove(carTable)).thenReturn(false);

		assertEquals(0, this.car.getY());

		this.testInstance.execute(carTable);

		assertEquals(0, this.car.getY());
	}
	
	@Test
	public void testExecuteInvalidIllegalCommand() {
		when(this.mockCommand.isValidCommand()).thenReturn(false);
		when(this.mockCommand.isLegitimateMove(carTable)).thenReturn(false);

		assertEquals(0, this.car.getY());

		this.testInstance.execute(carTable);

		assertEquals(0, this.car.getY());
	}
}
