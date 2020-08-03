package oauth;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class TwitterDemo {
	
	@Test
	 public void postTweet(){
		
		Response resp = RestAssured.given()
		.auth()
		.oauth("Token1", "Token2", "Token3", "Token4") //These tokens will be coming if we have Dev Account
		.post("https://api.twitter.com/1.1/statuses/update.json?status=This is my Tweet via API"); //postcall - URL "https://developer.twitter.com/en/docs/tweets/post-and-engage/api-reference/post-statuses-update"
		
		System.out.println("Response Code"+ resp.getStatusCode()); //Status Code 
	
		System.out.println(resp.getBody().asString()); //Output will be JSON
		
		System.out.println(resp.getBody().jsonPath().prettify()); //Will get Output in JSONformat prettified
		
		JsonPath json = resp.jsonPath();
		
		
		
		String tweetid = json.get("id_str"); //Any field which we want
		
		System.out.println(tweetid);
	}

}
