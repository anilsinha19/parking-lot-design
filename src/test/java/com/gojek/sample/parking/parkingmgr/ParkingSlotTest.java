package com.gojek.sample.parking.parkingmgr;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.gojek.sample.parking.parkingmgr.slot.ParkingSlot;
import com.gojek.sample.parking.parkingmgr.slot.Slot;

public class ParkingSlotTest {

	@Test
	public void testParkingSlotProperties() {
		Slot slot = new ParkingSlot(10);
		assertTrue(slot.getSlotNumber() == 10);
		assertTrue(slot.isAvailable());
	}
	
	@Test
	public void testParkingSlotAvaibility() {
		Slot slot = new ParkingSlot(10);
		slot.setAvailable(false);
	
		assertTrue(!(slot.isAvailable()));
	}
}
