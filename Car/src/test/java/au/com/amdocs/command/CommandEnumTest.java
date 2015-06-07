package au.com.amdocs.command;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import au.com.amdocs.command.CommandEnum;

public class CommandEnumTest {

	@Test
	public void testFromString() {
		assertEquals(CommandEnum.DONOTHING, CommandEnum.fromString(null));
		assertEquals(CommandEnum.DONOTHING, CommandEnum.fromString(""));
		assertEquals(CommandEnum.DONOTHING, CommandEnum.fromString("abc"));
		
		assertEquals(CommandEnum.FORWARD, CommandEnum.fromString("Forward"));
		assertEquals(CommandEnum.TURN_LEFT, CommandEnum.fromString("TURN_LEFT"));
		assertEquals(CommandEnum.GPS_REPORT, CommandEnum.fromString("GPS_Report"));
		assertEquals(CommandEnum.TURN_RIGHT, CommandEnum.fromString("turn_right"));
	}
	
	@Test
	public void testFromStringInit() {
		assertEquals(CommandEnum.INIT, CommandEnum.fromString("init"));
		assertEquals(CommandEnum.INIT, CommandEnum.fromString("INIT 0,0,NORTH"));
	}
}
