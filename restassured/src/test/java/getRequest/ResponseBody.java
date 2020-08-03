package getRequest;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ResponseBody {
	
	@Test
	public void VerifyResponseBody(){
		
		RestAssured.baseURI = "https://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get("/Hyderabad");
		
		//Convert ResponseBody to String and Print it
		String body = response.getBody().asString();
		System.out.println("Response Body is: " + body);
		
		
		// To check for sub string presence get the Response body as a String.
		 // Do a String.contains
		
		/* ------------------Not a Compact Way----------------*/
		
		 Assert.assertEquals(body.contains("Hyderabad") /*Expected value*/, true /*Actual Value*/, "Response body contains Hyderabad");
		 
		// convert the body into lower case and then do a comparison to ignore casing.
		 Assert.assertEquals(body.toLowerCase().contains("hyderabad") /*Expected value*/, true /*Actual Value*/, "Response body contains Hyderabad");
		 
	}
		@Test
		public void VerifyResponseBodyUsingJSON(){
			
			RestAssured.baseURI = "https://restapi.demoqa.com/utilities/weather/city";
			RequestSpecification httpRequest = RestAssured.given();
			Response response = httpRequest.get("/Hyderabad");
			
			/*{ ----Response Body ----------------
    			"City": "Hyderabad",
    			"Temperature": "25.51 Degree celsius",
    			"Humidity": "94 Percent",
    			"Weather Description": "mist",
    			"Wind Speed": "1 Km per hour",
    			"Wind Direction degree": " Degree"  */

			
			// First get the JsonPath object instance from the Response interface
			 JsonPath jsonPathEvaluator = response.jsonPath();
			 String city = jsonPathEvaluator.get("City");
			 
			// Let us print the city variable to see what we got
			 System.out.println("City received from Response " + city);
			 
			 // Validate the response
			 Assert.assertEquals(city, "Hyderabad", "Correct city name received in the Response");
			 
			
			
		
	}

}
