package regular;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;

import static org.hamcrest.Matchers.equalTo;;


public class BasicsMapGet {
	public static void main(String[] args) {
		RestAssured.baseURI="http://216.10.245.166";

		given().

		param("location", "-33.8670522,151.1957362").

		param("radius","500").

		param("key", "AIzaSyBCrGFdSiGCQrAMowX7zveFreyl7BxVvhc").

		when().

		get("/maps/api/place/add/json").

		then().log().all().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().

		body("results[0].name", equalTo("Sydney"));


	}
}
