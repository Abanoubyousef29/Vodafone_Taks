package tests;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;


public class Task3 {

	private String GETRequest = "get" ;
	private String POSTRequest = "post" ;
	private String URLEndPointPOSTS = "/posts" ;
	private String URLEndPointPOSTS1 = "/posts/1" ;
	Response response ;
	String result ;


	@Test
	public void test1() {

		response = sendRequest(GETRequest, URLEndPointPOSTS, null) ;

		System.out.println(response.getBody().asString());

		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertEquals(response.asString().contains("ea molestias quasi exercitationem repellat qui ipsa sit aut"),true );

	}


	@Test
	public void test2() {

		response = sendRequest(GETRequest, URLEndPointPOSTS1, null) ;
		
		System.out.println(response.getBody().asString());

		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertEquals(response.asString().contains("sunt aut facere repellat provident occaecati excepturi optio reprehenderit"),true );

	}


	@Test
	public void test4()
	{
		JSONObject body = new JSONObject();

		body.put("mode","raw");
		body.put("raw", "{\r\n\t\"title\": \"foo\",\r\n    \"body\": \"bar\",\r\n    \"userId\": 1\r\n}");

		response = sendRequest(POSTRequest, URLEndPointPOSTS, body) ;

		System.out.println(response.getBody().asString());
		Assert.assertEquals(response.getStatusCode(), 201);
		Assert.assertEquals(response.asString().contains("101"),true );

	}


	private Response sendRequest (String requestType, String request, JSONObject bodyData) 
	{
		baseURI = "https://jsonplaceholder.typicode.com";

		switch (requestType) 
		{
		case "post":
			return given().
					body(bodyData.toJSONString()).
					when().
					post(request).andReturn();



		case "get":
			return given().

					when().
					get(request).andReturn();
		}
		return null;
	}
}
