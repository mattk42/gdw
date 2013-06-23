package com.mjknox.directions;

import org.json.simple.JSONObject;

public class EventTime {
	private String text;
	private Long value;
	private String timeZone;
	
	/**
	 * Creates an event time object generated from a JSONObject
	 * @param jsonData
	 */
	public EventTime(JSONObject jsonData){
		this.text = (String) jsonData.get("text");
		this.value = (Long) jsonData.get("value");
		this.timeZone = (String) jsonData.get("time_zone");

	}
	
	/**
	 * @return The time displayed as a string.
	 */
	public String getText() {
		return text;
	}

	/**
	 * @return the time specified as a javascript Date object.
	 */
	public Long getValue() {
		return value;
	}

	/**
	 * @return the timezone that this time is in.
	 */
	public String getTimeZone() {
		return timeZone;
	}
}
