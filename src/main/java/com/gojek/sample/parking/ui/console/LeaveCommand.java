package com.gojek.sample.parking.ui.console;

import com.gojek.sample.parking.error.ParkingException;
import com.gojek.sample.parking.parkingmgr.ParkingEngine;
import com.gojek.sample.parking.parkingmgr.slot.Slot;

public class LeaveCommand implements Command {

	@Override
	public void execute(ParkingEngine parkingEngines, String[] inputCmd) throws ParkingException {
		Slot slot = parkingEngines.removeVechicle(Integer.valueOf(inputCmd[1]));
		System.out.println("Slot number "+slot.getSlotNumber()+" is free\n");
	}

}
