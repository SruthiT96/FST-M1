package activities;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import java.util.HashMap;
import java.util.Map;

public class Activity3 {
	RequestSpecification reqSpec;
	ResponseSpecification resSpec;
	@BeforeClass
	public void setup() {
		String baseURI="https://petstore.swagger.io/v2/pet";
		 reqSpec=new RequestSpecBuilder()
				.setContentType(ContentType.JSON)
				.setBaseUri(baseURI)
				.build();
				
		 resSpec=new ResponseSpecBuilder()
				.expectStatusCode(200)
				.expectContentType(ContentType.JSON)
				.expectBody("status", equalTo("alive"))
				.build();
	}
	
  @Test(dataProvider = "expectedData",priority=1)
  public void postPet(int id, String name, String status) {
	  Map<String,Object> pet1=new HashMap<>();
	  pet1.put("id", id);
	  pet1.put("name", name);
	  pet1.put("status",status);


	  Response res1=given().spec(reqSpec).body(pet1).when().post();
	  System.out.println(res1.getBody().asPrettyString());
	  res1.then().spec(resSpec).body("name", equalTo(name));

  }
  
  @Test(dataProvider = "expectedData",priority=2)
  public void getPet(int id, String name, String status) {
	  Response res1=given().spec(reqSpec).pathParam("petId", id).log().all()
			  .when().get("/{petId}");
	  System.out.println(res1.body().asPrettyString());
	  res1.then().spec(resSpec).body("id", equalTo(id)).log().all();
	  res1.then().spec(resSpec).body("name", equalTo(name)).log().all();
	  res1.then().spec(resSpec).body("status", equalTo(status)).log().all();

  }
  
  
  @DataProvider(name="expectedData")
  public Object[][] expectedGetOutput(){
	  Object[][] testData = new Object[][] { 
		    { 77232, "Riley", "alive" }, 
		    { 77233, "Hansel", "alive" } 
		};
	  return testData;
  }
  
  @Test(dataProvider = "expectedData",priority=3)
  public void deletePet(int id, String name, String status) {
	  Response res=given().spec(reqSpec).pathParam("petId", id).when().delete("/{petId}");
	  System.out.println(res.getBody().asPrettyString());
	  
	  res.then().body("message", equalTo(String.valueOf(id)));
	  
	  Response res1=given().spec(reqSpec).pathParam("petId", id).when().get("/{petId}");
	  System.out.println(res1.body().asPrettyString());
	  
  }
}
