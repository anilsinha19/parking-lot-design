package com.gojek.sample.parking.parkingmgr;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.gojek.sample.parking.ParkingAggregatorEngine;
import com.gojek.sample.parking.parkingmgr.slot.Slot;
import com.gojek.sample.parking.vehicles.Car;
import com.gojek.sample.parking.vehicles.Vehicle;

import junit.framework.TestCase;

public class ParkingAggregatorEngineTest  extends TestCase{

	ParkingEngine parkingEngine = null;

	@Before
    public void setUp() {
		 parkingEngine = new ParkingAggregatorEngine();
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
}
