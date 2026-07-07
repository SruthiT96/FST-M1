package activities;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Activity2 {
	final static String baseURI="https://petstore.swagger.io/v2/user";
	
  @Test(priority=1)
  public void postUser() throws IOException {
//	  Map<String, Object> reqBody=new HashMap<String, Object>();
//	  reqBody.put("id", 9999);
//	  reqBody.put("username", "justinc");
//	  reqBody.put("firstName", "Justin");
//	  reqBody.put("lastName", "Case");
//	  reqBody.put("email", "justincase@mail.com");
//	  reqBody.put("password", "password123");
//	  reqBody.put("phone", "9812763450");
	  FileInputStream inputFile=new FileInputStream("C:\\Users\\PoojaL\\Downloads\\userInput.json");

	  Response response=given()
			  .contentType(ContentType.JSON).body(inputFile)
			  .when().post(baseURI);
	  inputFile.close();
	  System.out.println(response.body().asPrettyString());
  }
  
  
  @Test(priority=2)
  public void getUser() throws IOException {
	  Response response=given().contentType(ContentType.JSON)
			  .pathParam("username", "Jussica")
			  .when().get(baseURI+"/{username}");
	  System.out.println(response.body().asPrettyString());
	  response.then().body("id", equalTo(9999));
	  response.then().body("username", equalTo("Jussica"));
	  response.then().body("firstName", equalTo("Justin"));
	  response.then().body("lastName", equalTo("Case"));
	  response.then().body("email", equalTo("justincase@mail.com"));
	  response.then().body("password", equalTo("password123"));
	  response.then().body("phone", equalTo("9812763450"));
	  File outputJson=new File("C:\\Users\\PoojaL\\Downloads\\userOuput.json");
	  outputJson.createNewFile();
	  
	  FileWriter writeTo=new FileWriter(outputJson.getPath());
	  writeTo.write(response.body().asPrettyString());
	  writeTo.close();
  }
  
  @Test(priority=3)
  public void deleteUser() {
	  Response response=given().contentType(ContentType.JSON)
			  .pathParam("username", "Jussica")
			  .when().delete(baseURI+"/{username}");
	  response.then().statusCode(200);
	  response.then().body("message", equalTo("Jussica"));
	  
	  
	  Response getresponse=given()
			  .headers("ContentType","application/json").basePath(baseURI)
			  .pathParam("username", "Jussica")
			  .when().get(baseURI+"/{username}");
	  System.out.println(getresponse.body().asPrettyString());
	  
  }
  
}
