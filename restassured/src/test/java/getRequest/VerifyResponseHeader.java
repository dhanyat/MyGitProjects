package getRequest;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class VerifyResponseHeader {
	 @Test
	 public void VerifyResponse()
	 {
	 // Specify the base URL to the RESTful web service
	 RestAssured.baseURI = "https://restapi.demoqa.com/utilities/weather/city";
	 RequestSpecification httpRequest = RestAssured.given();
	 Response response = httpRequest.get("/Hyderabad");
	 
	 // Response.asString method will directly return the content of the body
	 // as String.
	 System.out.println("Response Body is =>  " + response.asString());
	 
     // Get the status code from the Response. In case of a successful interaction with the web service, we should get a status code of 200.
	 int statusCode = response.getStatusCode();
	 
	 // Assert that correct status code is returned.
	 Assert.assertEquals(statusCode /*actual value*/, 200 /*expected value*/, "Correct status code returned");
	 
	// Get the status line from the Response and store it in a variable called statusLine
	 String statusLine = response.getStatusLine();
	 Assert.assertEquals(statusLine /*actual value*/, "HTTP/1.1 200 OK" /*expected value*/, "Correct status code returned");
	 }
	 

	 @Test
	 public void VerifyResponseheader()
	 {
	 // Specify the base URL to the RESTful web service
	 RestAssured.baseURI = "https://restapi.demoqa.com/utilities/weather/city";
	 RequestSpecification httpRequest = RestAssured.given();
	 Response response = httpRequest.get("/Hyderabad");
	 
	// Reader header of a give name. In this line we will get
	 String contentType = response.header("Content-Type");
	 System.out.println("Content-Type value: " + contentType);
	 
     // Reader header of a give name. In this line we will get Header named Server
	 String serverType =  response.header("Server");
	 System.out.println("Server value: " + serverType);
	 
	 // Reader header of a give name. In this line we will get Header named Content-Encoding

	 String acceptLanguage = response.header("Content-Encoding");
	 System.out.println("Content-Encoding: " + acceptLanguage);
	 }
	 
	 @Test
	 public void VerifyAllResponseheaders()
	 {
	 // Specify the base URL to the RESTful web service
	 RestAssured.baseURI = "https://restapi.demoqa.com/utilities/weather/city";
	 RequestSpecification httpRequest = RestAssured.given();
	 Response response = httpRequest.get("/Hyderabad");
	 
	Headers allHeaders = response.headers();
	
	for(Header header:allHeaders)
	{
		System.out.println("Key: "+header.getName()+" " +"Value: "+header.getValue());
	}
	
	 }
}
