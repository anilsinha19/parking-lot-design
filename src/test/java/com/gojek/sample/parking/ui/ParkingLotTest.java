package om.gojek.sample.parking.ui;

import org.junit.Test;

import com.gojek.sample.parking.ui.ParkingLot;
import com.gojek.sample.parking.ui.ParkingLotManager;
import com.gojek.sample.parking.vehicles.Car;
import com.gojek.sample.parking.vehicles.Vehicle;

public class ParkingLotTest {

	private ParkingLot parkingLot = new ParkingLotManager();
	
	@Test
	public void testParkingAvaibility() {
		parkingLot.isParkingAvailble();
	}
	
	@Test
	public void testParkCar() {
		Vehicle vehicle = new Car("MH 14 DX9956", "White");
		parkingLot.parkVehicle(vehicle);
	}
	
	@Test
	public void getRegNumOfAllWhiteCar() {
		
	}
	
	@Test
	public void testCarParkingSlot() {
		
	}
	
	@Test
	public void testSLotNumberOfWhiteCars() {
		
	}
}
