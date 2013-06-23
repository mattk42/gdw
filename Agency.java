package com.mjknox.directions;

import org.json.simple.JSONObject;

public class Agency {
	private String name;
	private String url;
	private String phone;
	
	/**
	 * Creates an agency object, generated from a JSONObject.
	 * @param jsonData
	 */
	public Agency(JSONObject jsonData){
		this.name = (String) jsonData.get("name");
		this.url = (String) jsonData.get("url");
		this.phone = (String) jsonData.get("phone");
	}

	/**
	 * @return the name of the transit agency.
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the URL for the transit agency.
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @return the phone number of the transit agency.
	 */
	public String getPhone() {
		return phone;
	}
}
