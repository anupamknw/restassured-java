package regular;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class RestAssuredDemo {

	public static String token;

	@Parameters ({ "baseUrl" })
	@Test
	public void loginDemo(String baseUrl) {
 
		System.out.println("Base URL:" + baseUrl);	
	//	RestAssured.baseURI = "http://real.url.that.works.when.Uncommentting.local";
		RestAssured.baseURI = baseUrl;
 
		RestAssured.given().header("Host", "sandbox").header("Content-Type", "application/json").header("Accept-Language", "en");
}
}