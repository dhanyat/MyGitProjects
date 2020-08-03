package restAssuredTest;

import org.testng.annotations.BeforeClass;

import io.restassured.RestAssured;

public class BaseClass {
	
	@BeforeClass
	public void setup(){
		
		RestAssured.authentication = RestAssured.preemptive().basic("ToolsQA", "TestPassword");
		RestAssured.baseURI = "https://restapi.demoqa.com/authentication/CheckForAuthentication/";
	}


}
