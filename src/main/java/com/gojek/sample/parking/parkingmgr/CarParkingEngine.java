package com.gojek.sample.parking.parkingmgr;

import java.util.List;

import com.gojek.sample.parking.parkingmgr.slot.Slot;
import com.gojek.sample.parking.vehicles.Vehicle;

public class CarParkingEngine  implements ParkingEngine{

	private BaseEngine baseEngine;
	
	public CarParkingEngine(int totalNosOfSlots) {
		baseEngine = new BaseEngine();
		baseEngine.init(totalNosOfSlots);
	}
	
	
	public BaseEngine getBaseEngine() {
		return baseEngine;
	}

	@Override
	public int getTotalNumberOfSlots() {
		// TODO Auto-generated method stub
		return baseEngine.getTotalNumberOfSlots();
	}

	@Override
	public boolean isParkingAvailbel() {
		// TODO Auto-generated method stub
		return baseEngine.isParkingAvailbel();
	}

	@Override
	public Slot getFreeSlot() {
		// TODO Auto-generated method stub
		return baseEngine.getFreeSlot();
	}

	@Override
	public Slot parkVechicle(Vehicle vehicle) {
		// TODO Auto-generated method stub
		return baseEngine.parkVechicle(vehicle);
	}

	@Override
	public Slot removeVechicle(Integer slotNumber) {
		// TODO Auto-generated method stub
		return baseEngine.removeVechicle(slotNumber);
	}

	@Override
	public Vehicle removeVechicle(Vehicle vehicle) {
		// TODO Auto-generated method stub
		return baseEngine.removeVechicle(vehicle);
	}

	@Override
	public List<Slot> getVehiclesSlotsByColor(String color) {
		// TODO Auto-generated method stub
		return baseEngine.getVehiclesSlotsByColor(color);
	}

	@Override
	public Slot getParkedVehiclesByRegNumber(String registrationNumber) {
		// TODO Auto-generated method stub
		return baseEngine.getParkedVehiclesByRegNumber(registrationNumber);
	}

	@Override
	public List<Slot> getParkingStatus() {
		// TODO Auto-generated method stub
		return baseEngine.getParkingStatus();
	}

}
