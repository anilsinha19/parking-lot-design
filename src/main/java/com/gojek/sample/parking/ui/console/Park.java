package com.gojek.sample.parking.ui.console;

import com.gojek.sample.parking.error.ParkingException;
import com.gojek.sample.parking.parkingmgr.ParkingEngine;
import com.gojek.sample.parking.parkingmgr.slot.Slot;
import com.gojek.sample.parking.vehicles.Car;

public class Park implements Command {

	@Override
	public void execute(ParkingEngine parkingEngine, String[] inputCmd) throws ParkingException {
		Slot parkedSlot =  parkingEngine.parkVechicle(new Car(inputCmd[1], inputCmd[2]));
		if(parkedSlot != null) {
			System.out.println("Allocated slot number: "+parkedSlot.getSlotNumber());	
		}else {
			System.out.println("Sorry, parking lot is full");
		}
	
	}

}
