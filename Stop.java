package com.mjknox.gdw;

import org.json.simple.JSONObject;

public class Stop {
	private String name;
	private Location location;
	
	/**
	 * Creates a Stop object, generated from a JSONObject.
	 * @param jsonData
	 */
	public Stop(JSONObject jsonData){
		this.name = (String) jsonData.get("name");
		this.location = new Location((JSONObject)jsonData.get("location"));
	}

	/**
	 * @return the name of this stop.
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the location of this stop.
	 */
	public Location getLocation() {
		return location;
	}
	
	
}
