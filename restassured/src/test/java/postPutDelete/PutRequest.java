package postPutDelete;


import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;


public class PutRequest {

	@Test
public void UpdateRecords(){
		int empid = 15410;

		RestAssured.baseURI ="https://dummy.restapiexample.com/api/v1";
		RequestSpecification request = RestAssured.given();
		
		JSONObject requestParams = new JSONObject();
		requestParams.put("name", "Zion"); // Cast
		requestParams.put("age", 23);
		requestParams.put("salary", 12000);

		request.body(requestParams.toJSONString());
		Response response = request.put("/update/"+ empid);

		int statusCode = response.getStatusCode();
		System.out.println(response.asString());
		Assert.assertEquals(statusCode, 200); 

	}



}
