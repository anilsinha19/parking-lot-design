package com.gojek.sample.parking;

public class DispatchingEvenType {

	private String eventType ;
	
	private static DispatchingEvenType eventTypeInst = new DispatchingEvenType() ;
	
	private DispatchingEvenType() {
		
	}
	
	public static DispatchingEvenType getDispatchingEvenType() {
		return eventTypeInst;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public static DispatchingEvenType getEventTypeInst() {
		return eventTypeInst;
	}

	public static void setEventTypeInst(DispatchingEvenType eventTypeInst) {
		DispatchingEvenType.eventTypeInst = eventTypeInst;
	}
	
	
}
