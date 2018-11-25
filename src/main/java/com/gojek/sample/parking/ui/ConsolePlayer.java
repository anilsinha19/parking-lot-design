package com.gojek.sample.parking.ui;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.gojek.sample.parking.error.ParkingException;
import com.gojek.sample.parking.parkingmgr.BaseEngine;
import com.gojek.sample.parking.parkingmgr.ParkingEngine;
import com.gojek.sample.parking.ui.console.CommandHandler;
import com.gojek.sample.parking.ui.console.ConsoleCommandHandler;

public class ConsolePlayer {

	private static ParkingEngine parkingEngine = null;
	
	public static void main(String[] args) throws ParkingException {
		String fileName = args[0];
		
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

			String inputCommand;

			while ((inputCommand = br.readLine()) != null) {
				inputCommand = inputCommand.trim();
				processCommand(inputCommand.split(" "));
			}

		} catch (IOException e) {
			throw new ParkingException("input file cound't be read , file name :" + fileName , e);
		}

	}

	public static void processCommand(String[] inputCmd) throws ParkingException {
		String command = inputCmd[0];
		CommandHandler handler = new ConsoleCommandHandler();
		
		if("create_parking_lot".equals(command)) {
			parkingEngine = BaseEngine.init(Integer.valueOf(inputCmd[1]));
			System.out.println("Created a parking lot with "+parkingEngine.getTotalNumberOfSlots()+" slots\n");
		}else {
			handler.invoke(command).execute(parkingEngine, inputCmd);	
		}
		
		
		/*else if("park".equals(command)) {
			Slot parkedSlot =  parkingEngine.parkVechicle(new Car(inputCmd[1], inputCmd[2]));
			if(parkedSlot != null) {
				System.out.println("Allocated slot number: "+parkedSlot.getSlotNumber()+"\n");	
			}else {
				System.out.println("Sorry, parking lot is full\n");
			}
		}
		else if("leave".equals(command)) {
			Slot slot = parkingEngine.removeVechicle(Integer.valueOf(inputCmd[1]));
			System.out.println("Slot number "+slot.getSlotNumber()+" is free\n");
		}
		else if("status".equals(command)) {
			List<Slot> slots = parkingEngine.getParkingStatus();
		}
		else if("registration_numbers_for_cars_with_colour".equals(command)) {
			List<Slot> slots = parkingEngine.getVehiclesSlotsByColor(inputCmd[1]);
			StringBuilder sb = new StringBuilder();
			for (Slot slot : slots) {
				sb.append(slot.getVehicle().getRegistrationNumber()).append(", ");
			}
			printResult(sb);
		}
		else if("slot_numbers_for_cars_with_colour".equals(command)) {
			List<Slot> slots = parkingEngine.getVehiclesSlotsByColor(inputCmd[1]);
			StringBuilder sb = new StringBuilder();
			for (Slot slot : slots) {
				sb.append(slot.getSlotNumber()).append(", ");
			}
			printResult(sb);
		}
		else if("slot_number_for_registration_number".equals(command)) {
			 Slot slot = parkingEngine.getParkedVehiclesByRegNumber(inputCmd[1]);
			 if(slot != null) {
				 System.out.println(slot.getSlotNumber() +"\n");
			 }else {
				 System.out.println("Not found");
			 }
		}*/
	}
		
}
