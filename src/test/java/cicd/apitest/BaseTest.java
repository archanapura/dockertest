package cicd.apitest;
import io.restassured.specification.RequestSpecification;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class BaseTest {
	protected static RequestSpecification request;
    @BeforeClass
    public void setup() {
    	RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

      

      
    }
    }

