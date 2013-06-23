package com.mjknox.directions;

import org.json.simple.JSONObject;

/**
 * Class to handle all objects that only require a text and value field.
 * @author Matthew Knox
 *
 */
public class BasicObject {
	private String text;
	private long value;
	
	/**
	 * Generate a BasicObject from a JSONObject. The JSONobject must contain a "text" and "value" field.
	 * @param jsonData
	 */
	public BasicObject(JSONObject jsonData){
		this.text = (String) jsonData.get("text");
		this.value = (Long) jsonData.get("value");
	}
	
	public BasicObject(){
		this.text = "NOT_SET";
		this.value = -1;
	}

	/**
	 * @return the text of the object.
	 */
	public String getText() {
		return text;
	}

	/**
	 * @return the value of the object.
	 */
	public long getValue() {
		return value;
	}
	
	
}
