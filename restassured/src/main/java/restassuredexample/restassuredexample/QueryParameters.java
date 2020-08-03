package restassuredexample.restassuredexample;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class QueryParameters {
	
	@Test
	public void SendQueryParams(){
		
		RestAssured.baseURI = "https://samples.openweathermap.org/data/2.5/";
		RequestSpecification httpRequest = RestAssured.given();
		
		//EndPoint: https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=2b1fd2d7f77ccf1b7de9b441571b39b8
		Response response = httpRequest.queryParam("q", "London,UK")
				                       .queryParam("appid", "2b1fd2d7f77ccf1b7de9b441571b39b8")
				                       .get("/weather");
		
		String jsonString = response.asString();
		System.out.println(response.getStatusCode()); 
		Assert.assertEquals(jsonString.contains("London"), true);
	}

}
