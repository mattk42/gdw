package com.mjknox.directions;
	
import org.json.simple.JSONObject;
public class TransitDetails {

	private Stop arrivalStop;
	private EventTime arrivalTime;
	private Stop departureStop;
	private EventTime departureTime;
	private String headsign;
	private Line line;
	private String headway;
	private String numStops;
	
	/**
	 * Generates a TransitDetails object from a JSONObject.
	 * @param jsonData
	 */
	public TransitDetails(JSONObject jsonData){
		this.arrivalStop = new Stop(((JSONObject)jsonData.get("arrival_stop")));
		this.arrivalTime = new EventTime(((JSONObject)jsonData.get("arrival_time")));
		this.departureStop = new Stop(((JSONObject)jsonData.get("departure_stop")));
		this.departureTime = new EventTime(((JSONObject)jsonData.get("departure_time")));
		this.headsign = (String) jsonData.get("headsign");
		this.headway = (String) jsonData.get("headway");
		this.numStops = (String) jsonData.get("numStops");
		
		this.line = new Line((JSONObject) jsonData.get("line"));
	}

	/**
	 * @return information about the stop/station for this part of the trip.
	 */
	public Stop getArrivalStop() {
		return arrivalStop;
	}

	/**
	 * @return contain the arrival times for this leg of the journey.
	 */
	public EventTime getArrivalTime() {
		return arrivalTime;
	}

	/**
	 * @return information about the stop/station for this part of the trip.
	 */
	public Stop getDepartureStop() {
		return departureStop;
	}

	/**
	 * 
	 * @return contain the departure times for this leg of the journey.
	 */
	public EventTime getDepartureTime() {
		return departureTime;
	}
	
	/**
	 * 
	 * @return the direction in which to travel on this line, as it is marked on the vehicle or at the departure stop. This will often be the terminus station.
	 */
	public String getHeadsign() {
		return headsign;
	}

	/**
	 * @return  information about the transit line used in this step.
	 */
	public Line getLine() {
		return line;
	}
	
	/**
	 * @return  the expected number of seconds between departures from the same stop at this time.
	 */
	public String getHeadway() {
		return headway;
	}

	/**
	 * @return the number of stops in this step, counting the arrival stop, but not the departure stop.
	 */
	public String getNumStops() {
		return numStops;
	}		
}
