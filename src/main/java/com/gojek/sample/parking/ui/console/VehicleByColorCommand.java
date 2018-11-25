package com.gojek.sample.parking.ui.console;

import java.util.List;

import com.gojek.sample.parking.error.ParkingException;
import com.gojek.sample.parking.parkingmgr.ParkingEngine;
import com.gojek.sample.parking.parkingmgr.slot.Slot;

public class VehicleByColorCommand implements Command{

	private String printDataType ;
	
	public VehicleByColorCommand(String printDataType) {
		this.printDataType = printDataType;
	}
	
	@Override
	public void execute(ParkingEngine parkingEngine, String[] inputCmd) throws ParkingException {

		List<Slot> slots = parkingEngine.getVehiclesSlotsByColor(inputCmd[1]);
		StringBuilder sb = new StringBuilder();
		for (Slot slot : slots) {
			if(printDataType != null && printDataType.equals("slot")) {
				sb.append(slot.getSlotNumber()).append(", ");
			}else {
				sb.append(slot.getVehicle().getRegistrationNumber()).append(", ");	
			}
			
		}
		printResult(sb);
	
	}

	private static void printResult(StringBuilder sb) {
		String result = sb.toString();
	
		if(sb.lastIndexOf(",") != -1) {
			 result = sb.deleteCharAt(sb.lastIndexOf(",")).toString();	
		}
		System.out.println(result + "\n");
	}
}
