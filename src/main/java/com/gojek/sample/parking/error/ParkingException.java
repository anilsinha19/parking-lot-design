package com.gojek.sample.parking.error;

public class ParkingException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ParkingException(String msg) {
		super(msg);
	}
	
	public ParkingException(String msg, Exception ex) {
		super(msg, ex);
		}

}
