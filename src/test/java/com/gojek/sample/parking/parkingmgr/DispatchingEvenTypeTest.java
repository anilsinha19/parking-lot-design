package com.gojek.sample.parking.parkingmgr;

import static org.junit.Assert.assertSame;

import org.junit.Test;

import com.gojek.sample.parking.DispatchingEvenType;

public class DispatchingEvenTypeTest {

	private DispatchingEvenType eventType =  DispatchingEvenType.getDispatchingEvenType();
	
	@Test
	public void testEventType() {
		eventType.setEventType("weekdays");
		assertSame("weekdays", eventType.getEventType());
	}
}
