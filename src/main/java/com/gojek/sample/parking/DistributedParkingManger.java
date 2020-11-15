package com.gojek.sample.parking;

import java.util.HashMap;
import java.util.Map;

import com.gojek.sample.parking.parkingmgr.CarParkingEngine;

public class DistributedParkingManger    
{
	
 private DistributedParkingManger manger = new DistributedParkingManger();  
  private Map<Integer, CarParkingEngine>  parkingLotMap = new HashMap<>();
  private static int  lotCount =0;

  private DistributedParkingManger() {
	  
  }
  public boolean  createParking(int slot) {
		CarParkingEngine engine = new CarParkingEngine(slot);
		parkingLotMap.put(++lotCount, engine);
		return true;
	}
  
  public int numberOdParking() {
	return parkingLotMap.size();
	  
  }
}
