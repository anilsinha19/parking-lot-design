package com.gojek.sample.parking.ui;

import com.gojek.sample.parking.parkingmgr.slot.Slot;
import com.gojek.sample.parking.vehicles.Vehicle;

public interface ParkingLot {

	public boolean isParkingAvailble();
	
	public Slot parkVehicle(Vehicle vehicle );
}
