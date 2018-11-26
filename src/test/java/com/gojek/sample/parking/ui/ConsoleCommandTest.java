package com.gojek.sample.parking.ui;

import org.junit.Test;

import com.gojek.sample.parking.error.ParkingException;

import junit.framework.TestCase;

public class ConsoleCommandTest extends TestCase{

	@Test
	public void testEndToEnd() throws ParkingException {
		
		ConsolePlayer.processCommand("create_parking_lot 6".split(" "));
		ConsolePlayer.processCommand("park KA-01-HH-1234 White".split(" "));
		ConsolePlayer.processCommand("park KA-01-BB-0001 Black".split(" "));
		ConsolePlayer.processCommand("park KA-01-HH-7896 White".split(" "));
		ConsolePlayer.processCommand("leave 1".split(" "));
		ConsolePlayer.processCommand("registration_numbers_for_cars_with_colour White".split(" "));
		ConsolePlayer.processCommand("status".split(" "));
	}
}
