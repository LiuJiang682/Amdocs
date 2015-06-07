package au.com.amdocs.command;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import au.com.amdocs.command.DoNothingCommand;

public class DoNothingCommandTest {

	private DoNothingCommand testInstance;
	
	@Before
	public void setUp() {
		this.testInstance = new DoNothingCommand();
	}
	
	@After
	public void tearDown() {
		this.testInstance = null;
	}

	@Test
	public void testGetCommand() {
		assertEquals(CommandEnum.DONOTHING, this.testInstance.getCommand());
	}
	
	@Test
	public void testIsValid() {
		assertFalse(this.testInstance.isValidCommand());
	}
	
	@Test
	public void testIsLegitimateMoveNullCar() {
		assertFalse(this.testInstance.isLegitimateMove(null));
	}
}
