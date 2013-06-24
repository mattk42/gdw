gdw
===

A java library for using the Google directions API.

Example Usage:

    import java.io.IOException;
    import java.text.ParseException;
    import com.mjknox.gdw.*;
    
    public class Example {  
      public static void main(String[] args) throws IOException, ParseException, QueryFailedException, org.json.simple.parser.ParseException {	  
    		//Create the query URL
    		GoogleDirectionsQueryURL directionURL = new GoogleDirectionsQueryURL("Boston,MA", "Concord,MA", false);
    		directionURL.AddParam("waypoints", "Charlestown,MA|Lexington,MA");
    		
    		Directions directions = new Directions(directionURL.getURL());
    		      
    		//There will only be one route because we did not set alternatives=true
    		Route route = directions.getRoutes().get(0);
    		  
    		//Print out some of the route information
    		for (Leg leg : route.getLegs()){
    			System.out.println("Depart:" + leg.getStartAddress());
    			
    			for (Step step : leg.getSteps()){
    				System.out.println("\t"+step.getInstructions());
    			}
    			
    			System.out.println("Arrive:" + leg.getEndAddress());
    		} 
    	}    
    }
      
      
  
  
