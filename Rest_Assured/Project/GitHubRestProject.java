package project;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;

public class GitHubRestProject {
	RequestSpecification reqSpec;
	String key;
	int id;
	String baseURI="https://api.github.com";
	
	@BeforeClass
	public void setUp() {
		 reqSpec=new RequestSpecBuilder()
				.setContentType(ContentType.JSON)
				.setBaseUri(baseURI)
				.addHeader("Authorization", "")
				.build();
		
	}
	
  @Test(priority=1)
  public void addSSH() throws FileNotFoundException {
	  //Method1: Fetch data from json
//	  FileInputStream input=new FileInputStream("C:\\Users\\PoojaL\\Downloads\\inputSSH.json");
	  //Method2: Fetch data from map
	  Map<String,String> input=new HashMap<String,String>();
	  input.put("title", "TestAPIKey");
	  input.put("key", key);
	  Response res=given().spec(reqSpec).body(input).when().post("/user/keys");
	  System.out.println(res.getBody().asPrettyString());
	  id=res.path("id");
	  res.then().statusCode(201);
  }
  
  @Test(priority=2)
  public void getSSH() {
	  Response res=given().spec(reqSpec).pathParam("keyId", id).when().get("/user/keys/{keyId}");
	  System.out.println(res.getBody().asPrettyString());
	  res.then().log().all().statusCode(200);
	  
  }
  
  @Test(priority=3)
  public void deleteSSH() {
	  Response res=given().spec(reqSpec).pathParam("keyId", id).when().delete("/user/keys/{keyId}");
	  System.out.println(res.getBody().asPrettyString());
	  res.then().log().all().statusCode(204);
  }
  
}
