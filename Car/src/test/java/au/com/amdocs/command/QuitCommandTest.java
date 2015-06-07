package au.com.amdocs.command;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import au.com.amdocs.interf.CarTable;

public class QuitCommandTest {

	private QuitCommand testInstance;
	
	@Mock 
	private CarTable mockTable;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		this.testInstance = new QuitCommand();
	}
	
	@After
	public void tearDown() {
		this.testInstance = null;
	}

	@Test
	public void testGetCommand() {
		assertEquals(CommandEnum.QUIT, this.testInstance.getCommand());
	}
	
	@Test
	public void testIsValid() {
		assertFalse(this.testInstance.isValidCommand());
	}
	
	@Test
	public void testIsLegitimateMoveNullCar() {
		assertFalse(this.testInstance.isLegitimateMove(null));
	}
	
	@Test
	public void testIsLegitimateMove() {
		assertFalse(this.testInstance.isLegitimateMove(this.mockTable));
	}
}
