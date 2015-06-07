package au.com.amdocs.executer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import au.com.amdocs.car.AmdocsCar;
import au.com.amdocs.command.PlaceCommand;
import au.com.amdocs.common.CommonConstants;
import au.com.amdocs.directions.Direction;
import au.com.amdocs.executer.PlaceCommandExecuter;
import au.com.amdocs.interf.Car;
import au.com.amdocs.interf.CarTable;

@RunWith(PowerMockRunner.class)
@PrepareForTest({CarTable.class})
public class PlaceCommandExecuterTest {

	private PlaceCommandExecuter instance;
	
	@Before
	public void setUp() {
		PlaceCommand placeCommand = new PlaceCommand("place 2, 3, north", "2, 3, north");
		this.instance = new PlaceCommandExecuter(placeCommand);
	}
	
	@After
	public void tearDown() {
		this.instance = null;
	}
	
	/**
	 * This test case tests the first time place command execute.
	 */
	@Test
	public void testExecuteAsFirtTime() {
		CarTable mockCarTable = PowerMockito.mock(CarTable.class);
		PowerMockito.doReturn(5).when(mockCarTable).getMaxX();
		PowerMockito.doReturn(5).when(mockCarTable).getMaxY();
		this.instance.execute(mockCarTable);
		
		ArgumentCaptor<Car> carCaptor = ArgumentCaptor.forClass(Car.class);
		Mockito.verify(mockCarTable).setCar(carCaptor.capture());
		List<Car> allcaptured = carCaptor.getAllValues();
		assertNotNull(allcaptured);
		assertTrue(allcaptured.size() == CommonConstants.ONE);
	}
	
	/**
	 * This test case tests the first time place command execute.
	 * @throws Throwable 
	 */
	@Test
	public void testExecute() throws Throwable {
		CarTable mockCarTable = PowerMockito.mock(CarTable.class);
		PowerMockito.doReturn(5).when(mockCarTable).getMaxX();
		PowerMockito.doReturn(5).when(mockCarTable).getMaxY();
		Car car = new AmdocsCar();
		PowerMockito.doReturn(car ).when(mockCarTable, "getCar");
		this.instance.execute(mockCarTable);
		
		assertEquals(2, car.getX());
		assertEquals(3, car.getY());
		assertEquals(Direction.NORTH, car.getFacing());
	}
}
