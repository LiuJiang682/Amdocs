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

import au.com.amdocs.command.GPSReportCommand;
import au.com.amdocs.interf.Car;
import au.com.amdocs.interf.CarTable;

public class GPSReportCommandTest {

	private GPSReportCommand testInstance;
	
	@Mock
	private CarTable mockCarTable;
	@Mock
	private Car mockCar;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		this.testInstance = new GPSReportCommand();
	}
	
	@After
	public void tearDown() {
		this.testInstance = null;
	}

	@Test
	public void testGetCommand() {
		assertEquals(CommandEnum.GPS_REPORT, this.testInstance.getCommand());
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
	public void testIsLegitimateMove() {
		when(this.mockCarTable.getCar()).thenReturn(mockCar);
		assertTrue(this.testInstance.isLegitimateMove(mockCarTable));
	}
}
