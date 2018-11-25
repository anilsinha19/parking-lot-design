package com.gojek.sample.parking.parkingmgr;

import java.util.List;

import com.gojek.sample.parking.parkingmgr.slot.Slot;
import com.gojek.sample.parking.vehicles.Vehicle;

public interface ParkingEngine {

	public int getTotalNumberOfSlots();
	
	public boolean isParkingAvailbel();

	public Slot getFreeSlot();

	public Slot parkVechicle(Vehicle vehicle);

	public Slot removeVechicle(Integer slotNumber);
	
	public Vehicle removeVechicle(Vehicle vehicle) ;
	
	public List<Slot> getVehiclesSlotsByColor(String color);
	
	public Slot getParkedVehiclesByRegNumber(String registrationNumber);
	
	public List<Slot> getParkingStatus();

}