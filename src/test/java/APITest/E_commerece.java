package APITest;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
public class E_commerece {
	public String accessToken;
	public String id;
	public static String baseurl = "https://ecommerceservice.herokuapp.com";

	@Test(priority=0,enabled = false) //if enabled is false it wont execute
	public void sign_up()
	{
		RestAssured.baseURI = baseurl;
		
		String requestbody = "{\r\n"
				+ "	\"email\": \"Ashishkr99876@gmail.com\",\r\n"
				+ "	\"password\": \"krishna@123\"\r\n"
				+ "}\r\n"
				+ "";
		
		//Response in console
		Response response = given()
          .header("content-Type","application/json")
          .body(requestbody)
          
          .when()
          .post("/user/signup")
          
          .then()
          .assertThat().statusCode(201).contentType(ContentType.JSON)
          //To extract the response
          .extract().response();
		//System.out.println(response.asString()); // To print the response as string
		String jsonrespose = response.asString(); //storing into a variable
		JsonPath responsebody = new JsonPath(jsonrespose); //converting string to json path object
		System.out.println(responsebody.get("message"));
	}
	
	@Test(priority=0)
	public void log_in()
	{
		RestAssured.baseURI = baseurl;
		
		String requestbody2 = "{\r\n"
				+ "	\"email\": \"Ashishkr99876@gmail.com\",\r\n"
				+ "	\"password\": \"krishna@123\"\r\n"
				+ "}\r\n"
				+ "";
		Response response = given()
		          .header("content-Type","application/json")
		          .body(requestbody2)
		          
		          .when()
		          .post("/user/login")
		          
		          .then()
		          .assertThat().statusCode(200).contentType(ContentType.JSON)
		          .extract().response();
		//System.out.println(response.asString());
		String jsonrespose = response.asString(); //storing into a variable
		JsonPath responsebody = new JsonPath(jsonrespose); //converting string to json path object
		System.out.println(responsebody.get("accessToken"));
		accessToken = responsebody.get("accessToken");
	}
	@Test(priority = 1)
	public void get()
	{
		RestAssured.baseURI = baseurl;
		Response response = given()
		.header("content-Type","application/json")
		.header("Authorization","bearer "+accessToken)
		
		.when()
        .get("/user")
        
        .then()
        .assertThat().statusCode(200).contentType(ContentType.JSON)
        .extract().response();
		String jsonrespose = response.asString(); //storing into a variable
		JsonPath responsebody = new JsonPath(jsonrespose); //converting string to json path object
		System.out.println(responsebody.get("users[171]._id"));
		id = responsebody.get("users[171]._id");
		
	}
	
	@Test(priority=2)
	public void delete()
	{
		RestAssured.baseURI = baseurl;
		Response response = given()
				.header("content-Type","application/json")
				.header("Authorization","bearer "+accessToken)
				
				.when()
		        .delete("/user/"+id)
		        
		        .then()
		        .assertThat().statusCode(200).contentType(ContentType.JSON)
		        .extract().response();
		String jsonrespose = response.asString();
		JsonPath responsebody = new JsonPath(jsonrespose);
		System.out.println(responsebody.get("message"));
	}
}
