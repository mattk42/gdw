package com.mjknox.directions;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Leg {
	
	private EventTime departureTime;
	private EventTime arrivalTime;
	private List<Step> steps;
	private String startAddress;
	private String endAddress;
	private Location startLocation;
	private Location endLocation;
	private boolean hasTransit = false;
	
	/**
	 * Creates a Leg object from a JSONObject.
	 * @param jsonData
	 */
	public Leg(JSONObject jsonData){
		//Initialize empty arrays
		steps = new ArrayList<Step>();
			
		//Parse values from json
		this.startAddress = (String) jsonData.get("start_address");
		this.endAddress = (String) jsonData.get("end_address");
		
		this.startLocation = new Location((JSONObject)jsonData.get("start_location"));
		this.endLocation = new Location((JSONObject)jsonData.get("end_location"));

	
		JSONArray jsonSteps = (JSONArray) jsonData.get("steps");
		for ( Object step : jsonSteps){
			Step stepObj = new Step((JSONObject)step);
			if (stepObj.getTravelMode().equals(Mode.TRANSIT.name())){
				hasTransit=true;
			}
			this.steps.add(stepObj);
		}
		
		//Arrival and departure time are only set if there is transit involved
		if (hasTransit){
			this.departureTime = new EventTime((JSONObject)jsonData.get("departure_time"));
			this.arrivalTime = new EventTime((JSONObject)jsonData.get("arrival_time"));
		}
	}

	/**
	 * @return the estimated time of departure for this leg, only available for transit directions.
	 */
	public EventTime getDepartureTime() {
		return departureTime;
	}

	/**
	 * @return the estimated time of arrival for this leg, only available for transit directions.
	 */
	public EventTime getArrivalTime() {
		return arrivalTime;
	}

	/** 
	 * @return the human-readable address (typically a street address) reflecting the start location of this leg.
	 */
	public String getStartAddress() {
		return startAddress;
	}

	/**
	 * @return the human-readable address (typically a street address) reflecting the end location of this leg.
	 */
	public String getEndAddress() {
		return endAddress;
	}

	/**
	 * @return an array of steps denoting information about each separate step of the leg of the journey.
	 */
	public List<Step> getSteps() {
		return steps;
	}
	
	/**
	 * @return a location object that represents the start location of this leg.
	 */
	public Location getStartLocation() {
		return startLocation;
	}

	public Location getEndLocation() {
		return endLocation;
	}

	/**
	 * @return an array of steps denoting information about each separate step of the leg of the journey, filtered by travelMode
	 * @see Mode
	 */
	public List<Step> getAllStepsByTravelMode(Mode travelMode){
		List<Step> results = new ArrayList<Step>();
		
		for ( Step step : steps){
			if ( step.getTravelMode().equals(travelMode.name())){
				results.add(step);
			}
		}
		
		return results;
	}
	
}
