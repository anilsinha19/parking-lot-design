package com.gojek.sample.parking;

import java.util.List;

import com.gojek.sample.parking.parkingmgr.ParkingEngine;
import com.gojek.sample.parking.parkingmgr.slot.Slot;
import com.gojek.sample.parking.vehicles.Vehicle;

public class ParkingAggregatorEngine implements ParkingEngine {
	
	private DispatchingEvenType eventType = DispatchingEvenType.getDispatchingEvenType();
	private DistributedParkingManger distParkingMgr ;

	@Override
	public int getTotalNumberOfSlots() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isParkingAvailbel() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Slot getFreeSlot() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Slot parkVechicle(Vehicle vehicle) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Slot removeVechicle(Integer slotNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vehicle removeVechicle(Vehicle vehicle) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Slot> getVehiclesSlotsByColor(String color) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Slot getParkedVehiclesByRegNumber(String registrationNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Slot> getParkingStatus() {
		// TODO Auto-generated method stub
		return null;
	}

}
