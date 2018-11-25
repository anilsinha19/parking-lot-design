package com.gojek.sample.parking.ui.console;

import com.gojek.sample.parking.error.ParkingException;
import com.gojek.sample.parking.parkingmgr.ParkingEngine;

public class NoneCommand implements Command {

	@Override
	public void execute(ParkingEngine parkingEngine, String[] inputCmd) throws ParkingException {
		System.out.println("invalid operation");

	}

}
