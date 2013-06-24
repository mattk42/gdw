package com.mjknox.gdw;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map.Entry;

public class GoogleDirectionsQueryURL {

	private String baseURL="http://maps.googleapis.com/maps/api/directions/json";
	
	private HashMap<String, String> params;
		
	/**
	 * Creates a google maps URL with the required parameters.
	 * @param origin
	 * @param destination
	 * @param sensor
	 */
	public GoogleDirectionsQueryURL(String origin, String destination, Boolean sensor){
		params = new HashMap<String, String>();
		
		this.baseURL = this.baseURL + "?origin="+URLEncoder.encode(origin);
		this.baseURL = this.baseURL + "&destination="+URLEncoder.encode(destination);
		this.baseURL = this.baseURL + "&sensor="+ sensor.toString();
	}

	/**
	 * Used for adding non-required parameters to the URL. All keys and values get url encoded.
	 * @param key The key for the parameter
	 * @param value The value for the parameter
	 */
	public void AddParam(String key, String value){
		this.params.put(URLEncoder.encode(key), URLEncoder.encode(value));
	}

	/**
	 * @return a URL for your google directions query.
	 */
	public URL getURL(){
		String resultURL = baseURL;
		for (Entry<String,String> param : params.entrySet()){
			resultURL = resultURL+"&"+param.getKey()+"="+param.getValue();
		}
		try {
			return new URL(resultURL);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
