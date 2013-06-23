package com.mjknox.directions;

import org.json.simple.JSONObject;

public class Vehicle {

	private String name;
	private String type;
	private String icon;
	
	/**
	 * Creates a Vehicle object, generated from a JSONObject.
	 * @param jsonData
	 */
	public Vehicle(JSONObject jsonData){
		this.name = (String) jsonData.get("name");
		this.type = (String) jsonData.get("type");
		this.icon = (String) jsonData.get("icon");
	}

	/**
	 * @return the name of the vehicle on this line. eg. "Subway."
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the type of vehicle that runs on this line.
	 */
	public String getType() {
		return type;
	}

	/**
	 * @return URL for an icon associated with this vehicle type.
	 */
	public String getIcon() {
		return icon;
	}
	
}
