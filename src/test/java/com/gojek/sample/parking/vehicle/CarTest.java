package om.gojek.sample.parking.vehicle;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.gojek.sample.parking.vehicles.Car;
import com.gojek.sample.parking.vehicles.Vehicle;

public class CarTest {

	@Test
	public void testCarProperties() {
		Vehicle vehicle = new Car("MH123", "Red");
		assertTrue(vehicle.getColor().equals("Red"));
		assertTrue(vehicle.getRegistrationNumber().equals("MH123"));
	}
}
