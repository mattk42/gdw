package com.mjknox.gdw;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Line {
	private String name;
	private String shortName;
	private String color;
	private List<Agency> agencies;
	private String url;
	private String icon;
	private String textColor;
	private Vehicle vehicle;
	
	public Line(JSONObject jsonData){
		//Initialize empty lists
		agencies = new ArrayList<Agency>();
		
		this.name = (String) jsonData.get("name");
		this.shortName = (String) jsonData.get("short_name");
		this.color = (String) jsonData.get("color");
		
		for (Object jsonAgency : (JSONArray)jsonData.get("agencies")){
			Agency agency = new Agency((JSONObject)jsonAgency);
			agencies.add(agency);
		}
		
		this.url = (String) jsonData.get("url");
		this.icon = (String) jsonData.get("icon");
		this.textColor = (String) jsonData.get("text_color");
		this.vehicle = new Vehicle((JSONObject)jsonData.get("vehicle"));
	}

	public List<Agency> getAgencies() {
		return agencies;
	}

	public String getName() {
		return name;
	}

	public String getShortName() {
		return shortName;
	}

	public String getColor() {
		return color;
	}

	public String getUrl() {
		return url;
	}

	public String getIcon() {
		return icon;
	}

	public String getTextColor() {
		return textColor;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

}
