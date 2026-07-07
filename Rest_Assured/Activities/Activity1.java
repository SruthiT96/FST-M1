package activities;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Activity1 {
  @Test(priority = 1)
  public void postTest() {
	  final String baseURI="https://petstore.swagger.io/v2/pet";

	  Map<String,Object> data=new HashMap<String,Object>();
	  data.put("id", 77232);
	  data.put("name", "Riley");
	  data.put("status", "alive");
	  
	  Response response=given()
			  .contentType(ContentType.JSON).body(data)
			  .when().post(baseURI);
	  
//	  or
//		Response response = given()
//			.baseUri("https://petstore.swagger.io/v2/pet") // Set base URI
//			.header("Content-Type", "application/json") // Set headers
//			.body(body) // Add request body
//			.when().post(); // Send POST request
	  
	  System.out.println(response.getBody().asPrettyString());
	  response.then().body("id", equalTo(77232));
	  response.then().body("name", equalTo("Riley"));
	  response.then().body("status",equalTo("alive"));
  }
  
  @Test(priority = 2)
  public void getTest() {
	  final String baseURI="https://petstore.swagger.io/v2/pet/{petId}";
	  Response response=given().contentType(ContentType.JSON)
			  .when().pathParam("petId",77232).get(baseURI);
	  
//	  or	
//		Response response = given()
//			.baseUri("https://petstore.swagger.io/v2/pet") // Set base URI
//			.header("Content-Type", "application/json") // Set headers
//			.when().pathParam("petId", 77232) // Set path parameter
//			.get("/{petId}"); // Send GET request
	  System.out.println(response.getBody().asPrettyString());
	  response.then().body("id",equalTo(77232));
	  response.then().body("name", equalTo("Riley"));
	  response.then().body("status",equalTo("alive"));
	  
  }
  
  @Test(priority = 3)
  public void deleteTest() {
	  final String baseURI="https://petstore.swagger.io/v2/pet/{petId}";
	  Response response=given().contentType(ContentType.JSON)
			  .when().pathParam("petId", 77232).delete(baseURI);
	  
	  //or
//		Response response = given()
//			.baseUri("https://petstore.swagger.io/v2/pet") // Set base URI
//			.header("Content-Type", "application/json") // Set headers
//			.when().pathParam("petId", 77232) // Set path parameter
//			.delete("/{petId}"); // Send DELETE request
	
	  
	  response.then().statusCode(200);
	  response.then().body("message", equalTo("77232"));
	  
	  Response getresponse=given().contentType(ContentType.JSON)
			  .when().pathParam("petId",77232).get(baseURI);
	  System.out.println(getresponse.getBody().asPrettyString());

	  
  }
  
  
  
}
