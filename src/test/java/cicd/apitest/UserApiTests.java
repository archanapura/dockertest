package cicd.apitest;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class UserApiTests extends BaseTest {

	@Test
	public void getPosts() {

		 given()
	    .when()
	        .get("/posts")
	    .then()
	        .statusCode(200)
	        .body("size()", greaterThan(0));
	}
	
	@Test
	public void getSinglePost() {

		 given()
	    .when()
	        .get("/posts/1")
	    .then()
	        .statusCode(200)
	        .body("id", equalTo(1));
	}

	@Test
	public void createPost() {

	    String body = """
	        {
	          "title": "API Testing",
	          "body": "REST Assured Test",
	          "userId": 1
	        }
	        """;

	    given()
	        .body(body)
	    .when()
	        .post("/posts")
	    .then()
	        .statusCode(201)
	        .body("id", notNullValue());
	}
	
	@Test
	public void deletePost() {

		 given()
	    .when()
	        .delete("/posts/1")
	    .then()
	        .statusCode(200);
	}


}
