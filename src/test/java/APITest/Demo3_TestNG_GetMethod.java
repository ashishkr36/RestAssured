package APITest;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;  //for given, when and then
import static org.hamcrest.CoreMatchers.equalTo; //to check the expected result that's why we use hamcrest library of TestNG

public class Demo3_TestNG_GetMethod {
	
	// Get Method
	// Get = https://api.trello.com/1/boards/{id}
	
	public static String baseurl = "https://api.trello.com";
	
	@Test
	public void testcase4()
	{
		RestAssured.baseURI = baseurl; //to fetch the base url by restassured
		
		given().param("key", "c2de62be3ddaa0024e9e2712b6834de8")  // for prerequisite can take parameter/header/cookies
		.param("token","d842206f330e578dc6d0e708be90d8a4019fb3a4d6627b7232c02e8e9e895047")
		
		.when() // condition/can take diff. http methods
		.get("/1/boards/OXOnmCN4")  // can use any http methods .get/.post/del/.patch
		
		.then() //checking response/applying assertion
		.assertThat().statusCode(200).contentType(ContentType.JSON).and()
		.body("name", equalTo("introo"));
	}

}
