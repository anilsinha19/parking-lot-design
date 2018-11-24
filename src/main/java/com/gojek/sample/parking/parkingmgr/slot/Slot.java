package com.gojek.sample.parking.parkingmgr.slot;

import com.gojek.sample.parking.vehicles.Vehicle;

public interface Slot {

	int getSlotNumber();

	Vehicle getVehicle();

	void setVehicle(Vehicle vehicle);

	boolean isAvailable();

	void setAvailable(boolean isAvailable);

}