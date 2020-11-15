package com.gojek.sample.parking.parkingmgr;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.gojek.sample.parking.parkingmgr.slot.Slot;
import com.gojek.sample.parking.vehicles.Car;
import com.gojek.sample.parking.vehicles.Vehicle;

import junit.framework.TestCase;

public class ParkingEngineTest extends TestCase{
	
	ParkingEngine parkingEngine = null;

	@Before
    public void setUp() {
		 parkingEngine = new CarParkingEngine(5);
    }
	
	@After
	public void tearDown()  {
		parkingEngine = null;
	 }
	
	@Test
	public void testParkingSlotCount() {
		assertSame(5, parkingEngine.getTotalNumberOfSlots());
	}
	
	@Test
	public void testParkingAvaibility() {
		assertSame(true, parkingEngine.isParkingAvailbel());
	}
	
	@Test
	public void testCarParking() {
		Vehicle vehicle = new Car("MH 14 DX9956", "White");
		Slot parkedSlot = parkingEngine.parkVechicle(vehicle);
		assertNotNull(parkedSlot);
		assertSame(parkedSlot.getVehicle().getColor(), "White");
	}
	
	@Test
	public void getRegNumOfAllWhiteCar() {
		
		parkingEngine.parkVechicle(new Car("Reg 1", "White"));
		parkingEngine.parkVechicle(new Car("Reg 2", "White"));
		parkingEngine.parkVechicle(new Car("Reg 3", "White"));
		parkingEngine.parkVechicle(new Car("Reg 4", "Black"));
		
		List<Slot> carList = parkingEngine.getVehiclesSlotsByColor("White");
		assertNotNull(carList);
		assertSame(3,carList.size());
		
	}
	
	@Test
	public void testCarParkingSlot() {
		String regNumber = "Reg XYZ";
		parkingEngine.parkVechicle(new Car("Reg 3", "White"));
		parkingEngine.parkVechicle(new Car(regNumber, "White"));
		Slot vehicleSlot = parkingEngine.getParkedVehiclesByRegNumber(regNumber);
		assertSame(regNumber, vehicleSlot.getVehicle().getRegistrationNumber());
	}
	
	@Test
	public void testNearestSlotAllocated() {
		Slot s1 = parkingEngine.parkVechicle(new Car("Reg 1", "White"));
		assertSame(1, s1.getSlotNumber());
		Slot s2 = parkingEngine.parkVechicle(new Car("Reg 2", "White"));
		assertSame(2, s2.getSlotNumber());
		Slot s3 = parkingEngine.parkVechicle(new Car("Reg 3", "White"));
		assertSame(3, s3.getSlotNumber());
		Slot s4 = parkingEngine.parkVechicle(new Car("Reg 4", "Black"));
		assertSame(4, s4.getSlotNumber());
		
		parkingEngine.removeVechicle(new Car("Reg 2", "White"));
		
		Slot s22 = parkingEngine.parkVechicle(new Car("Reg 22", "Black"));
		assertSame(2, s22.getSlotNumber());
	}
	
	@Test
	public void testParkingLimit() {
		parkingEngine = new CarParkingEngine(3);
		Slot s1 = parkingEngine.parkVechicle(new Car("Reg 1", "White"));
		assertNotNull(s1);
		Slot s2 = parkingEngine.parkVechicle(new Car("Reg 2", "White"));
		assertNotNull(s2);
		Slot s3 = parkingEngine.parkVechicle(new Car("Reg 3", "White"));
		assertNotNull(s3);
		Slot s4 = parkingEngine.parkVechicle(new Car("Reg 4", "Black"));
		assertNull(s4);
		
	}
}
