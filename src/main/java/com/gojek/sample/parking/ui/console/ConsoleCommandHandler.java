package com.gojek.sample.parking.ui.console;

import java.util.HashMap;
import java.util.Map;

public class ConsoleCommandHandler implements CommandHandler {

	private static Map<String, Command> commandMap = new HashMap<>();
	private static volatile boolean  initlized = false;
	
	public ConsoleCommandHandler() {
		init();
	}
	
	private void init() {
		if(!(initlized)) {
			commandMap.put("create_parking_lot", new CreateParkingLot());
			commandMap.put("park", new Park());
			commandMap.put("leave", new LeaveCommand());
			commandMap.put("status", new StatusCommand());
			commandMap.put("registration_numbers_for_cars_with_colour", new VehicleByColorCommand("registrationNumber"));
			commandMap.put("slot_numbers_for_cars_with_colour", new VehicleByColorCommand("slot"));
			commandMap.put("slot_number_for_registration_number", new VehicleByRegCommand());
		}
		initlized = true;
	}
	
	@Override
	public Command invoke(String cmdName) {
		Command command = commandMap.get(cmdName);
		if(command == null) return new NoneCommand();
		return command;
	}
}
