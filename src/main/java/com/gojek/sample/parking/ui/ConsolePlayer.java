package com.gojek.sample.parking.ui;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import com.gojek.sample.parking.error.ParkingException;
import com.gojek.sample.parking.parkingmgr.BaseEngine;
import com.gojek.sample.parking.parkingmgr.ParkingEngine;
import com.gojek.sample.parking.ui.console.CommandHandler;
import com.gojek.sample.parking.ui.console.ConsoleCommandHandler;

public class ConsolePlayer {

	private static ParkingEngine parkingEngine = null;
	
	
	public static void main(String[] args)  {
		String fileName = args[0];
		//System.out.println("input arguments .." + fileName);
		if(fileName != null && !(fileName.trim().equals(""))) {
			handleFileInput(fileName);
		}else {
			Scanner scanner = new Scanner(System.in);
			while(scanner.hasNext()) {
				String inputCmd = scanner.nextLine();
			//	System.out.println("input command .." + inputCmd);

				try {
					if(checkIfExit(inputCmd)) break;
					processCommand(inputCmd.split(" "));
				} catch (ParkingException e) {
					e.printStackTrace();
				}
			}
		}
	}


	public static void processCommand(String[] inputCmd) throws ParkingException {
		String command = inputCmd[0];
		CommandHandler handler = new ConsoleCommandHandler();
		
		if("create_parking_lot".equals(command)) {
			parkingEngine = BaseEngine.init(Integer.valueOf(inputCmd[1]));
			System.out.println("Created a parking lot with "+parkingEngine.getTotalNumberOfSlots()+" slots");
		}else {
			handler.invoke(command).execute(parkingEngine, inputCmd);	
		}
	}
		
	private static boolean checkIfExit(String inputCmd) {
		if("exit".equalsIgnoreCase(inputCmd)) {
			return true;
		}
		return false;
	}

	private static void handleFileInput(String fileName) {

		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

			String inputCommand;

			while ((inputCommand = br.readLine()) != null) {
				inputCommand = inputCommand.trim();
				processCommand(inputCommand.split(" "));
			}

		} catch (IOException | ParkingException e) {
			e.printStackTrace();
		}
	}
}
