package postPutDelete;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostRequest {

	@Test
	public void post()
	{
		/* BODY: {
				“FirstName” : “value”
				“LastName” : “value”,
				“UserName” : “value”,
				“Password” : “value”,
				“Email”        : “Value” }
		 */
		
		
		RestAssured.baseURI ="https://restapi.demoqa.com/customer";
		 RequestSpecification request = RestAssured.given();
		 
		// JSONObject is a class that represents a Simple JSON.
		// We can add Key - Value pairs using the put method
		 JSONObject requestParams = new JSONObject();
		
		requestParams.put("FirstName", "Virender"); // Cast
		requestParams.put("LastName", "Singh");
		requestParams.put("UserName", "sdimpleuser2dd2011");
		requestParams.put("Password", "password1");
		requestParams.put("Email",  "sample2ee26d9@gmail.com");
		

		// Add a header stating the Request body is a JSON
		request.header("Content-Type", "application/json");
		
		// Add the Json to the body of the request
		request.body(requestParams.toJSONString());
		Response response = request.post("/register");
		 
		int statusCode = response.getStatusCode();
	    Assert.assertEquals(statusCode, "201");
	    	    
	    String successCode = response.jsonPath().get("SuccessCode");
	    Assert.assertEquals( "Correct Success code was returned", successCode, "OPERATION_SUCCESS");
	    
	    

		
	}
}
