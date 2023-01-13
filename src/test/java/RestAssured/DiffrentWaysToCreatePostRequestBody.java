package RestAssured;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.json.JSONObject;
import org.testng.annotations.Test;

public class DiffrentWaysToCreatePostRequestBody {

	// USING HASHMAP
	@Test
	public void postUsinghashmap() {

		HashMap data = new HashMap();
		data.put("name", "morpheus");
		data.put("job", "leader");

		given()
		.contentType("application/json")
		.body(data)

				.when()
				.post("https://reqres.in/api/users")

				.then()
				.statusCode(201)
				.body("name", equalTo("morpheus"))
				.body("job", equalTo("leader"))
				.header("Content-Type", "application/json; charset=utf-8")
				.log().all();

	}
	//using org.Json library
	@Test
	public void crateuserusingjson() {
      JSONObject data=new JSONObject();
      data.put("name", "morpheus");
      data.put("job", "leader");
     
      given()
      .contentType("application/json")
	  .body(data.toString()) //this is change in json from hashmap
      
      .when()
       . post("https://reqres.in/api/users")
      
      .then()
      .statusCode(201)
      .body("name", equalTo("morpheus"))
		.body("job", equalTo("leader"))
		.header("Content-Type", "application/json; charset=utf-8")
      .log().all();
	}
	
	//using POJO (plain old java object)
	public void createuserusingpojo() {

	}
	//using externaljsonfile
	public void createuserusingexternaljsonfile() {
		
	}
}
