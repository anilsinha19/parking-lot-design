package com.gojek.sample.parking.ui.console;

import com.gojek.sample.parking.error.ParkingException;
import com.gojek.sample.parking.parkingmgr.ParkingEngine;
import com.gojek.sample.parking.parkingmgr.slot.Slot;

public class VehicleByRegCommand implements Command {

	@Override
	public void execute(ParkingEngine parkingEngine, String[] inputCmd) throws ParkingException {

		 Slot slot = parkingEngine.getParkedVehiclesByRegNumber(inputCmd[1]);
		 if(slot != null) {
			 System.out.println(slot.getSlotNumber());
		 }else {
			 System.out.println("Not found");
		 }
	
	}

}
