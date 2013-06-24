package com.mjknox.gdw;

import java.util.TimeZone;

import org.json.simple.JSONObject;
import org.joda.time.*;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class EventTime {
	private String text;
	private Long value;
	private DateTimeZone timeZone;
	private DateTime time;
	private DateTimeFormatter fmt = DateTimeFormat.forPattern("D y h:ma");

	
	/**
	 * Creates an event time object generated from a JSONObject
	 * @param jsonData
	 */
	public EventTime(JSONObject jsonData){
		this.text = (String) jsonData.get("text");
		this.value = (Long) jsonData.get("value");
		this.timeZone = DateTimeZone.forID((String) jsonData.get("time_zone"));
		this.time = DateTime.parse(DateTime.now().getDayOfYear()+" "+DateTime.now().getYear()+" "+this.text,fmt);
		
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
	public DateTimeZone getTimeZone() {
		return timeZone;
	}
	
	/**
	 * @return the time as a Joda Instant.
	 */
	public DateTime getTime() {
		return time;
	}
}
