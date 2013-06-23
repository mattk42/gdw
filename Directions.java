package com.mjknox.directions;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Directions {

	private List<Route> routes;

	/**
	 * Performs google directions query and parses the results into POJOs
	 * @param url
	 * @throws IOException
	 * @throws ParseException
	 * @throws QueryFailedException
	 */
	public Directions(URL url) throws IOException, ParseException, QueryFailedException{
		JSONParser parser = new JSONParser();
		System.out.println(url);

		//Get JSON back from that URL:
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		String content = IOUtils.toString(con.getInputStream(), "UTF-8");			
		JSONObject jsonResponse = (JSONObject)parser.parse(content);
		con.disconnect();
		
		initFromJson(jsonResponse);
		
	}
	
	/**
	 * Parses google maps JSON data and creates POJOs from the data.
	 * @param jsonData
	 * @throws QueryFailedException
	 */
	public Directions(JSONObject jsonData) throws QueryFailedException{
		initFromJson(jsonData);
	}
	

	private void initFromJson(JSONObject jsonData) throws QueryFailedException{
		//Initialize empty array
		this.routes = new ArrayList<Route>();
		
		//Verify that the query was successful
		String status = (String)jsonData.get("status");
		if (status.equals("OK")){
			JSONArray jsonRoutes = (JSONArray)jsonData.get("routes");
			
			for (Object routeObj : jsonRoutes){
				Route route = new Route((JSONObject)routeObj);
				this.routes.add(route);
			}	
		}
		else{
				throw new QueryFailedException(status);
		}
	}
	
	/**
	 * @return a list of route objects
	 */
	public List<Route> getRoutes(){
		return routes;
	}
}
