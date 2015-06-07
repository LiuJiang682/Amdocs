package au.com.amdocs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.util.reflection.Whitebox;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import au.com.amdocs.command.QuitCommand;
import au.com.amdocs.command.factory.CommandConstructFactory;
import au.com.amdocs.command.interf.Command;
import au.com.amdocs.command.interf.CommandExecuter;
import au.com.amdocs.common.CommonConstants;
import au.com.amdocs.executer.factory.ExecuterConstructFactory;
import au.com.amdocs.interf.Car;
import au.com.amdocs.interf.CarTable;

@RunWith(PowerMockRunner.class)
@PrepareForTest({AmdocsCarTable.class, ExecuterConstructFactory.class, CommandConstructFactory.class})
public class AmdocsCarTableTest {
	
	private AmdocsCarTable instance;
	private Scanner scanner;
	
	@Mock
	private CommandExecuter mockExecuter;
	@Mock
	private Car mockCar;
	@Mock
	private Command mockCommand;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		this.instance = PowerMockito.mock(AmdocsCarTable.class);
		scanner = new Scanner(System.in);
		PowerMockito.doReturn(scanner).when(this.instance).getScanner();
	}
	
	@After
	public void tearDown() {
		this.instance = null;
		this.scanner = null;
	}
	
	/**
	 * This test case tests the getNextCommand returns a command object
	 * with invalid flag set to true. It expected the getCar method never
	 * get call.
	 */
	@Test
	public void testRunWithInvalidCommand() {
		Mockito.doReturn(false).when(mockCommand).isValidCommand();
		PowerMockito.when(this.instance.getNextCommand(this.scanner)).thenReturn(mockCommand).thenReturn(new QuitCommand());
		Mockito.doCallRealMethod().when(this.instance).run();
		
		this.instance.run();
		
		Mockito.verify(this.instance, Mockito.never()).getCar();
	}
	
	/**
	 * This test case tests the getNextCommand returns a command object
	 * with legal move flag set to true. It expected the getCar method 
	 * get call twice.
	 */
	@Test
	public void testRun() {
		PowerMockito.doReturn(true).when(mockCommand).isValidCommand();
		PowerMockito.doReturn(true).when(mockCommand).isLegitimateMove(Matchers.any(CarTable.class));
		PowerMockito.when(this.instance.getNextCommand(this.scanner)).thenReturn(mockCommand).thenReturn(new QuitCommand());
		
		PowerMockito.doReturn(mockCar).when(this.instance).getCar();
		PowerMockito.doReturn(mockExecuter).when(this.instance).getExecuter(Matchers.eq(mockCommand), Matchers.eq(mockCar));
		
		Mockito.doCallRealMethod().when(this.instance).run();
		
		this.instance.run();
		
		Mockito.verify(this.instance, Mockito.times(CommonConstants.ONE)).getCar();
		
		ArgumentCaptor<Car> carCaptor = ArgumentCaptor.forClass(Car.class);
		ArgumentCaptor<Command> commandCaptor = ArgumentCaptor.forClass(Command.class);
		Mockito.verify(this.instance).getExecuter(commandCaptor.capture(), carCaptor.capture());
		List<Car> captured = carCaptor.getAllValues();
		assertNotNull(captured);
		assertTrue(captured.size() == CommonConstants.ONE);
		
		List<Command> capturedCommands = commandCaptor.getAllValues();
		assertNotNull(capturedCommands);
		assertTrue(capturedCommands.size() == CommonConstants.ONE);
	}
	
	@Test
	public void testGetScanner() {
		PowerMockito.doCallRealMethod().when(this.instance).getScanner();
		assertNotNull(this.instance.getScanner());
	}
	
	@Test
	public void testGetScannerWithFileName() {
		this.instance = new AmdocsCarTable("src/test/resources/data.txt");
		assertNotNull(this.instance.getScanner());
		assertFalse(this.instance.isUserInativeMode());
	}
	
	@Test
	public void testGetScannerWithInvalidFileName() {
		this.instance = new AmdocsCarTable("abc");
		assertNotNull(this.instance.getScanner());
		assertTrue(this.instance.isUserInativeMode());
	}
	
	@Test
	public void testGetExecuter() throws Exception {
		PowerMockito.mockStatic(ExecuterConstructFactory.class);
		PowerMockito.doReturn(mockExecuter).when(ExecuterConstructFactory.class, "contructExecuter", Matchers.any(Command.class), Matchers.any(Car.class));
		PowerMockito.doCallRealMethod().when(this.instance).getExecuter(mockCommand, mockCar);
		
		assertEquals(this.mockExecuter, this.instance.getExecuter(mockCommand, mockCar));
	}
	
	@Test
	public void testGetNextCommand() throws Exception {
		Scanner mockScanner = PowerMockito.mock(Scanner.class);
		PowerMockito.doReturn("abc").when(mockScanner).nextLine();
		PowerMockito.mockStatic(CommandConstructFactory.class);
		PowerMockito.doReturn(mockCommand).when(CommandConstructFactory.class, "constructCommand", Matchers.anyString());
		PowerMockito.doCallRealMethod().when(this.instance, "getNextCommand", mockScanner);
		
		assertEquals(mockCommand, this.instance.getNextCommand(mockScanner));
	}
	
	@Test
	public void testGetNextCommandNullString() throws Exception {
		Scanner mockScanner = PowerMockito.mock(Scanner.class);
		PowerMockito.when(mockScanner.nextLine()).thenReturn(null, "abc");
		PowerMockito.mockStatic(CommandConstructFactory.class);
		PowerMockito.doReturn(mockCommand).when(CommandConstructFactory.class, "constructCommand", Matchers.anyString());
		PowerMockito.doCallRealMethod().when(this.instance, "getNextCommand", mockScanner);
		
		assertEquals(mockCommand, this.instance.getNextCommand(mockScanner));
	}
	
	@Test
	public void testGetNextCommandHashString() throws Exception {
		Scanner mockScanner = PowerMockito.mock(Scanner.class);
		PowerMockito.when(mockScanner.nextLine()).thenReturn("#", "abc");
		PowerMockito.mockStatic(CommandConstructFactory.class);
		PowerMockito.doReturn(mockCommand).when(CommandConstructFactory.class, "constructCommand", Matchers.anyString());
		PowerMockito.doCallRealMethod().when(this.instance, "getNextCommand", mockScanner);
		
		assertEquals(mockCommand, this.instance.getNextCommand(mockScanner));
	}
	
	@Test
	public void testGetNextCommandUserInactive() throws Exception {
		Scanner mockScanner = PowerMockito.mock(Scanner.class);
		PowerMockito.doReturn("abc").when(mockScanner).nextLine();
		PowerMockito.mockStatic(CommandConstructFactory.class);
		PowerMockito.doReturn(mockCommand).when(CommandConstructFactory.class, "constructCommand", Matchers.anyString());
		Whitebox.setInternalState(instance, "userInativeMode", true);
		PowerMockito.doCallRealMethod().when(this.instance, "getNextCommand", mockScanner);
		
		assertEquals(mockCommand, this.instance.getNextCommand(mockScanner));
	}
	
	@Test
	public void testGetNextCommandUserInactiveFalse() throws Exception {
		Scanner mockScanner = PowerMockito.mock(Scanner.class);
		PowerMockito.doReturn("abc").when(mockScanner).nextLine();
		PowerMockito.mockStatic(CommandConstructFactory.class);
		PowerMockito.doReturn(mockCommand).when(CommandConstructFactory.class, "constructCommand", Matchers.anyString());
		Whitebox.setInternalState(instance, "userInativeMode", false);
		PowerMockito.doCallRealMethod().when(this.instance, "getNextCommand", mockScanner);
		
		assertEquals(mockCommand, this.instance.getNextCommand(mockScanner));
	}
}
