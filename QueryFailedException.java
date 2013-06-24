package com.mjknox.gdw;

public class QueryFailedException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6261892277411073805L;
	
	public QueryFailedException(String status){
		super("Query failed with status: "+ status);
	}

}
