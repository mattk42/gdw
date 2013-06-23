package com.mjknox.directions;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Step {
	private BasicObject distance;
	private BasicObject duration;
	private String travelMode;
	private String instructions;
	private TransitDetails trasitDetails;	
	private List<Step> subSteps;
	
	/**
	 * Creates a Step object, generated from a JSONObject.
	 * @param jsonData
	 */
	public Step(JSONObject jsonData){
		//Initialize empty arrays
		subSteps = new ArrayList<Step>();
		
		//Parse the values from the json
		try{
			this.distance = new BasicObject(((JSONObject)jsonData.get("distance")));
		}
		catch (NullPointerException e){
			//Ignore null pointer, distance will be null if unknown
			distance = new BasicObject();
		}
		
		try{
			this.duration = new BasicObject(((JSONObject)jsonData.get("duration")));
		}
		catch (NullPointerException e){
			//Ingore null pointer, duration will be null if unknown
			duration = new BasicObject();
		}
		
		try{
			for (Object jsonStep : (JSONArray)jsonData.get("sub_steps") ){
				Step step = new Step((JSONObject)jsonStep);
				subSteps.add(step);
			}
		}
		catch (NullPointerException e){
			//Ingore null pointer, substeps are not always defined
		}

		this.travelMode = (String) jsonData.get("travel_mode");
		this.instructions = (String) jsonData.get("html_instructions");
	
		if (this.travelMode.equals("TRANSIT")){
			this.trasitDetails = new TransitDetails((JSONObject)jsonData.get("transit_details"));
		}
		


	}

	/**
	 * @return indicates the total distance covered by a leg.
	 */
	public BasicObject getDistance() {
		return distance;
	}

	/**
	 * @return indicates the total duration of a leg.
	 */
	public BasicObject getDuration() {
		return duration;
	}
	
	public String getTravelMode() {
		return travelMode;
	}

	/**
	 * @return formatted instructions for this step, presented as an HTML text string.
	 */
	public String getInstructions() {
		return instructions;
	}

	/**
	 * @return transit specific information.
	 */
	public TransitDetails getTrasitDetails() {
		return trasitDetails;
	}
	
	/**
	 * @return  contains detailed directions for walking or driving steps in transit directions. Substeps are only available when travel_mode is set to "transit".
	 */
	public List<Step> getSubSteps(){
		return subSteps;
	}
	
}
