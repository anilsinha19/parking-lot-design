package com.gojek.sample.parking.parkingmgr;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import com.gojek.sample.parking.error.ParkingException;
import com.gojek.sample.parking.parkingmgr.slot.ParkingSlot;
import com.gojek.sample.parking.parkingmgr.slot.Slot;
import com.gojek.sample.parking.vehicles.Vehicle;

public class BaseEngine implements ParkingEngine {

	private List<Slot> slotList ;
	private Map<Integer, Slot> freeSlotMap;
	private Integer totalNosOfSlots ;
	
	private static BaseEngine baseEngine = null;
	
	private BaseEngine() {
		
	}
	
	public static synchronized ParkingEngine init(Integer totalNosOfSlots) {
	  baseEngine = new BaseEngine();	
	  baseEngine.totalNosOfSlots = totalNosOfSlots;
	  baseEngine.slotList = new ArrayList<Slot>(totalNosOfSlots);
	  baseEngine.freeSlotMap = new TreeMap<Integer, Slot>();
	  for (int i = 1; i <= totalNosOfSlots; i++) {
		  Slot slot = new ParkingSlot(i);
		  baseEngine.freeSlotMap.put(slot.getSlotNumber(), slot);
		  baseEngine.slotList.add(slot);
	  }
	  return baseEngine;
	} 
	
	public static ParkingEngine getInstance() throws ParkingException{
		if(baseEngine == null) throw new ParkingException("Paking Engine is not initilized , please cal init first");
		return baseEngine;
	}
	
	@Override
	public int getTotalNumberOfSlots() {
		return totalNosOfSlots;
	}
	
	@Override
	public boolean isParkingAvailbel() {
		if(freeSlotMap.isEmpty()) return false;
		return true;
	}
	
	@Override
	public synchronized Slot getFreeSlot() {
		if(freeSlotMap.isEmpty()) return null;
		TreeMap<Integer, Slot> tMap = (TreeMap<Integer, Slot>) freeSlotMap;
		Slot freeSlot = tMap.firstEntry().getValue();
		freeSlotMap.remove(freeSlot.getSlotNumber());
		return freeSlot.copy();
	}
	
	@Override
	public synchronized Slot parkVechicle(Vehicle vehicle) {
		Slot slot = getFreeSlot();
		if(slot != null) {
			slot.setVehicle(vehicle);
			slot.setAvailable(false);
			slotList.add(getSlotListIndex(slot),slot);
			return slot.copy();
		}
		return null;
	}
	
	@Override
	public synchronized Slot removeVechicle(Integer slotNumber) {
		Slot oldSlot =  slotList.remove(getSlotListIndex(slotNumber));
		oldSlot.setAvailable(true);
		oldSlot.setVehicle(null);
		freeSlotMap.put(slotNumber, oldSlot);
		return oldSlot.copy();
	}
	
	@Override
	public synchronized Vehicle removeVechicle(Vehicle vehicle) {
		Slot currentParkingSLot =findVechicleParkingSlot(vehicle);
		slotList.remove(getSlotListIndex(currentParkingSLot));
		currentParkingSLot.setAvailable(true);
		currentParkingSLot.setVehicle(null);
		freeSlotMap.put(currentParkingSLot.getSlotNumber(), currentParkingSLot);
		return currentParkingSLot.getVehicle();
	}
	
	@Override
	public synchronized List<Slot> getVehiclesSlotsByColor(String color){
		List<Slot> occupiedSlotList = slotList.stream().filter(x -> x.getVehicle() != null && x.getVehicle().getColor().equals(color)).map(Slot::copy).collect(Collectors.toList());
		return occupiedSlotList;
	}
	
	@Override
	public synchronized  Slot getParkedVehiclesByRegNumber(String registrationNumber){
		List<Slot> occupiedSlotList = slotList.stream().filter(x -> x.getVehicle() != null && x.getVehicle().getRegistrationNumber().equals(registrationNumber)).map(Slot::copy).collect(Collectors.toList());
		if(occupiedSlotList.size() >0) return occupiedSlotList.get(0);
		return null;
	}
	
	@Override
	public List<Slot> getParkingStatus() {
		List<Slot> occupiedSlotList = slotList.stream().filter(x -> x.isAvailable() == false).map(Slot::copy).collect(Collectors.toList());
		return occupiedSlotList;
	}
	
	private Slot findVechicleParkingSlot(Vehicle vehicle) {
		List<Slot> occupiedSlotList = slotList.stream().filter(x -> x.getVehicle() != null && x.getVehicle().getRegistrationNumber().equals(vehicle.getRegistrationNumber())).collect(Collectors.toList());
		if(occupiedSlotList.size() >0) return occupiedSlotList.get(0);
		return null;
	}

	private int getSlotListIndex(Slot slot) {
		return slot.getSlotNumber()-1;
	}
	
	private int getSlotListIndex(Integer slotNumber) {
		return slotNumber-1;
	}


}
