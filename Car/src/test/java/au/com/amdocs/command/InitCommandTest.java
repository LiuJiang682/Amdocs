package au.com.amdocs.command;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import au.com.amdocs.AmdocsCarTable;
import au.com.amdocs.command.InitCommand;
import au.com.amdocs.directions.Direction;

@RunWith(PowerMockRunner.class)
@PrepareForTest({Direction.class})
public class InitCommandTest {

	/**
	 * This test case tests the rubbish string
	 * constructor.
	 */
	@Test
	public void testInvalidCommandConstructor() {
		InitCommand command = new InitCommand("rubbish");
		assertEquals(CommandEnum.INIT, command.getCommand());
		assertFalse(command.isValidCommand());
	}
	
	/**
	 * This test case tests the string with rubbish parameter string
	 */
	@Test
	public void testConstructorWithRubbishParam() {
		InitCommand command = new InitCommand("rubbish rubbish", "rubbish");
		assertEquals(CommandEnum.INIT, command.getCommand());
		assertFalse(command.isValidCommand());
	}
	
	/**
	 * This test case tests the string with character x, y parameter string
	 */
	@Test
	public void testConstructorWithRubbishXYParam() {
		PowerMockito.mockStatic(Direction.class);
		
		InitCommand command = new InitCommand("place x, y, f", "x, y, f");
		assertEquals(CommandEnum.INIT, command.getCommand());
		assertFalse(command.isValidCommand());
		
		PowerMockito.verifyStatic(Mockito.never());
		Direction.valueOf(Matchers.anyString());
	}
	
	/**
	 * This test case tests the string with character x, y parameter string
	 */
	@Test
	public void testConstructorWithEmptyXYParam() {
		PowerMockito.mockStatic(Direction.class);
		
		InitCommand command = new InitCommand("place , , f", ", , f");
		assertEquals(CommandEnum.INIT, command.getCommand());
		assertFalse(command.isValidCommand());
		
		PowerMockito.verifyStatic(Mockito.never());
		Direction.valueOf(Matchers.anyString());
	}
	
	/**
	 * This test case tests the string with character x, y parameter string
	 */
	@Test
	public void testConstructorWithRubbishYParam() {
		PowerMockito.mockStatic(Direction.class);
		
		InitCommand command = new InitCommand("place 2, y, f", "2, y, f");
		assertEquals(CommandEnum.INIT, command.getCommand());
		assertFalse(command.isValidCommand());
		
		PowerMockito.verifyStatic(Mockito.never());
		Direction.valueOf(Matchers.anyString());
	}
	
	/**
	 * This test case tests the string with incorrect facing parameter string
	 */
	@Test
	public void testConstructorWithRubbishFacingParam() {

		InitCommand command = new InitCommand("place 2, 3, f", "2, 3, f");
		assertEquals(CommandEnum.INIT, command.getCommand());
		assertFalse(command.isValidCommand());
		
	}
	
	/**
	 * This test case tests the string with character x, y parameter string
	 */
	@Test
	public void testConstructor() {

		InitCommand command = new InitCommand("place 2, 3, north", "2, 3, north");
		assertEquals(CommandEnum.INIT, command.getCommand());
		assertTrue(command.isValidCommand());
	}
	
	/**
	 * This test case tests the isLegitimateMove flag.
	 */
	@Test
	public void testIsLegitimateMove() {
		InitCommand command = new InitCommand("place 2, 3, north", "2, 3, north");
		AmdocsCarTable table = new AmdocsCarTable();
		assertTrue(command.isLegitimateMove(table));
	}
	
	/**
	 * This test case tests the isLegitimateMove flag.
	 */
	@Test
	public void testIsLegitimateMoveFail() {
		InitCommand command = new InitCommand("place 7, 7, north", "7, 7, north");
		AmdocsCarTable table = new AmdocsCarTable();
		assertFalse(command.isLegitimateMove(table));
	}
	
	@Test
	public void testToString() {
		InitCommand command = new InitCommand("place 7, 7, north");
		assertEquals("place 7, 7, north, valid false", command.toString());
	}
}
