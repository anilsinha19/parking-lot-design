package com.gojek.sample.parking.vehicles;
/**
 * Class extension is allowed but immutable otherwise.
 * @author sinhanil
 *
 */
public class Car implements Vehicle {

	private final String registrationNumber;
	private final String color;
	
	public Car(String registrationNumber, String color) {
		this.registrationNumber = registrationNumber;
		this.color = color;
	}
	
	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public String getColor() {
		return color;
	}

}
