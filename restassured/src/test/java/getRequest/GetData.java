package getRequest;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*; //This if we declare then no need to write ResrtAssured. in the programs
import io.restassured.response.Response;
import junit.framework.Assert;

public class GetData {
	
	@Test(priority =1, description ="This Testcase will get Response code")
	public void testResponsecode()
	{
		Response response = get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=439d4b804bc8187953eb36d2a8c26a02");
		int code = response.getStatusCode();
		System.out.println("Status code is"+ code);
		Assert.assertEquals(200, code);
		
		String line = response.getContentType();
		System.out.println("Status code is"+ line);
	}
	
	@Test(priority =2,description ="This Testcase will get JSON", enabled = false)
	public void testBody()
	{
		Response resp = get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=439d4b804bc8187953eb36d2a8c26a02");
		String data = resp.asString();
		System.out.println("Status code is"+ data);
		System.out.println("Response time is"+resp.getTime());
		
	}

	
}
