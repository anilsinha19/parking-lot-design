package com.gojek.sample.parking.ui.console;

import com.gojek.sample.parking.parkingmgr.CarParkingEngine;
import com.gojek.sample.parking.parkingmgr.ParkingEngine;

public class CreateParkingLot  implements Command{

	@Override
	public void execute(ParkingEngine parkingEngine, String[] inputCmd) {
	//	parkingEngine = BaseEngine.init(Integer.valueOf(inputCmd[1]));
		parkingEngine = new CarParkingEngine(Integer.valueOf(inputCmd[1]));
		System.out.println("Created a parking lot with "+parkingEngine.getTotalNumberOfSlots()+" slots");
	}

}
