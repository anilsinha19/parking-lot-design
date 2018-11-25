package com.gojek.sample.parking.parkingmgr.slot;

import com.gojek.sample.parking.vehicles.Vehicle;

public class ParkingSlot implements Slot {

	private final int slotNumber;
	private Vehicle vehicle;
	private boolean isAvailable = true; // default is true
	
	public ParkingSlot(int slotNumber) {
		this.slotNumber = slotNumber;
	}
	
	@Override
	public int getSlotNumber() {
		return slotNumber;
	}
	
	@Override
	public Vehicle getVehicle() {
		return vehicle;
	}
	
	@Override
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	@Override
	public boolean isAvailable() {
		return isAvailable;
	}

	@Override
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	
	public Slot copy() {
		ParkingSlot ps = new ParkingSlot(slotNumber);
		ps.setAvailable(isAvailable);
		ps.setVehicle(vehicle);
		return ps;
	}
}
