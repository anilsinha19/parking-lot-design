package com.gojek.sample.parking.ui.console;

import java.util.List;

import com.gojek.sample.parking.error.ParkingException;
import com.gojek.sample.parking.parkingmgr.ParkingEngine;
import com.gojek.sample.parking.parkingmgr.slot.Slot;

public class StatusCommand implements Command {

	@Override
	public void execute(ParkingEngine parkingEngine, String[] inputCmd) throws ParkingException {
		List<Slot> slots = parkingEngine.getParkingStatus();
		System.out.println("Slot No.\tRegistration No\t Colour");
		for (Slot slot : slots) {
			System.out.println(slot.getSlotNumber() +"\t\t " + slot.getVehicle().getRegistrationNumber() +"\t " +slot.getVehicle().getColor());
		}
	}

}
