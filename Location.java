package com.mjknox.gdw;

import org.json.simple.JSONObject;

public class Location {
	private Double lat;
	private Double lng;
	
	/**
	 * Creates a Location object from a JSONObject.
	 * @param jsonData
	 */
	public Location(JSONObject jsonData){
		this.lat = (Double) jsonData.get("lat");
		this.lng = (Double)jsonData.get("lng");
	}

	/**
	 * @return the latitude of this location.
	 */
	public double getLat() {
		return lat;
	}

	/**
	 * @return the longitude of this location.
	 */
	public double getLng() {
		return lng;
	}
	
	
}
