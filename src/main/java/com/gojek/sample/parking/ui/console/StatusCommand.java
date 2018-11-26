package com.gojek.sample.parking.ui.console;

import java.util.List;

import com.gojek.sample.parking.error.ParkingException;
import com.gojek.sample.parking.parkingmgr.ParkingEngine;
import com.gojek.sample.parking.parkingmgr.slot.Slot;

public class StatusCommand implements Command {

	@Override
	public void execute(ParkingEngine parkingEngine, String[] inputCmd) throws ParkingException {
		List<Slot> slots = parkingEngine.getParkingStatus();
		
		System.out.print(String.format("%-12s", "Slot No."));
		System.out.print(String.format("%-19s", "Registration No"));
		System.out.print(String.format("%-6s", "Colour" +"\n"));
		for (Slot slot : slots) {
			System.out.print(String.format("%-12s", slot.getSlotNumber()));
			System.out.print(String.format("%-19s", slot.getVehicle().getRegistrationNumber()));
			System.out.print(String.format("%s", slot.getVehicle().getColor())+"\n");
		}
	}

}
