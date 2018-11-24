package com.gojek.sample.parking.parkingmgr.slot;

import com.gojek.sample.parking.vehicles.Vehicle;

public class ParkingSlot implements Slot {

	private final int slotNumber;
	private Vehicle vehicle;
	private boolean isAvailable = true; // default is true
	
	public ParkingSlot(int slotNumber) {
		this.slotNumber = slotNumber;
	}
	
	/* (non-Javadoc)
	 * @see com.gojek.sample.parking.parkingmgr.slot.Slot#getSlotNumber()
	 */
	public int getSlotNumber() {
		return slotNumber;
	}
	
	/* (non-Javadoc)
	 * @see com.gojek.sample.parking.parkingmgr.slot.Slot#getVehicle()
	 */
	public Vehicle getVehicle() {
		return vehicle;
	}
	/* (non-Javadoc)
	 * @see com.gojek.sample.parking.parkingmgr.slot.Slot#setVehicle(com.gojek.sample.parking.vehicles.Vehicle)
	 */
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	/* (non-Javadoc)
	 * @see com.gojek.sample.parking.parkingmgr.slot.Slot#isAvailable()
	 */
	public boolean isAvailable() {
		return isAvailable;
	}

	/* (non-Javadoc)
	 * @see com.gojek.sample.parking.parkingmgr.slot.Slot#setAvailable(boolean)
	 */
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	
}
