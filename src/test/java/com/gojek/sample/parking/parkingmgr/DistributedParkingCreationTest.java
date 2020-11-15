package com.gojek.sample.parking.parkingmgr;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.gojek.sample.parking.DistributedParkingManger;

public class DistributedParkingCreationTest {
	
	private DistributedParkingManger manger = new DistributedParkingManger();
	
	@Test
	public void testParkingCreating() {
		boolean  parkingid = manger.createParking(10);
		assertTrue(parkingid);
	}
	
	
	@Test
	public void testParkingLotCount() {
		manger.createParking(10);
		manger.createParking(2);
		assertEquals(2, manger.numberOdParking());
	}

}
