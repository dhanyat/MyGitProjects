package restAssuredTest;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Preemptiveauth {
	
	@Test
	
	public void test1(){
		
		int code = RestAssured.given()
				.auth().preemptive()
				.basic("ToolsQA", "TestPassword")
				.when()
				.get("https://restapi.demoqa.com/authentication/CheckForAuthentication/")
				.getStatusCode();
		System.out.println("Response code is"+code);
		
	}

}
