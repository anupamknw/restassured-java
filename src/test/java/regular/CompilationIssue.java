package regular;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class CompilationIssue {

	public static void main(String[] args) {
		String payload = "{\n" + 
				"    \"external_id\": \"PM_TEST001\",\n" + 
				"    \"name\": \"Plymouth Township Test Station\",\n" + 
				"    \"latitude\": 42.37,\n" + 
				"    \"longitude\": -83.35,\n" + 
				"    \"altitude\": 150\n" + 
				"}";
		
		RestAssured.baseURI = "http://api.openweathermap.org/data/3.0";
		given().
			contentType(ContentType.JSON).
			queryParam("APPID", "09e9c0e43ee664130fa030659e49223e").
			body(payload).
		when().
			post("/stations").
		then().log().all().
			assertThat().statusCode(201);
	}
}
