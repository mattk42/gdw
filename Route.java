package com.mjknox.directions;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Route {
	private String summary;
	private List<Leg> legs;
	private String copyrights;
	private List<String> warnings;
	
	/**
	 * Generates a route object from a JSONObject.
	 * @param jsonData
	 */
	public Route(JSONObject jsonData){
		//Initialize empty arrays
		this.legs = new ArrayList<Leg>();
		this.warnings = new ArrayList<String>();
		
		//Parse values from json
		this.summary = (String) jsonData.get("summary");
		
		for (Object legObj : (JSONArray)jsonData.get("legs")){
			Leg leg = new Leg((JSONObject)legObj);
			this.legs.add(leg);			
		}
		
		this.copyrights = (String) jsonData.get("copyrights");
		
		for (Object warningObj : (JSONArray)jsonData.get("warnings")){
			this.warnings.add((String)warningObj);			
		}
	}
	
	/**
	 * @return a short textual description for the route, suitable for naming and disambiguating the route from alternatives.
	 */
	public String getSummary() {
		return summary;
	}

	/**
	 * @return the copyrights text to be displayed for this route. You must handle and display this information yourself.
	 */
	public String getCopyrights() {
		return copyrights;
	}

	/**
	 * @return an array of warnings to be displayed when showing these directions. You must handle and display these warnings yourself.
	 */
	public List<String> getWarnings() {
		return warnings;
	}

	/**
	 * @return an array which contains information about a leg of the route, between two locations within the given route. A separate leg will be present for each waypoint or destination specified.
	 */
	public List<Leg> getLegs(){
		return legs;
	}
	
}
