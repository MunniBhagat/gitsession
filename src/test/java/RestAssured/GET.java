package RestAssured;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.Test;
//https://reqres.in/api/users/2
//https://reqres.in/api/users
/*{
"name": "morpheus",
"job": "leader"
}*/
public class GET {
	@Test
 void getUser() {
	
	given()
	
	.when()
	.get("https://reqres.in/api/users?page=2")
	
	.then()
     .statusCode(200)
     .body("page",equalTo(2))
     .log().all();
}
	@Test
 void createUser(){
	 HashMap hm=new HashMap();
	 hm.put("name", "morpheus");
	 hm.put("job", "leader");
;	 given()
	 .contentType("application/json")
	 .body(hm)
	 .when()
      .post("https://reqres.in/api/users")
      
	 .then()
	 .statusCode(201)
	 .log().all();
	 
 }

}