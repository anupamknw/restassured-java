import io.restassured.RestAssured;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

import static org.hamcrest.Matchers.equalTo;

public class Basics_04Mar {

	public static void main(String[] args) {

		// TODO Auto-generated method stub

		RestAssured.baseURI = "https://maps.googleapis.com";

		given().

				param("location", "32.854009, -117.234782").

				param("radious", "3000").

				param("key", "AIzaSyAEAqGoqk-XiNjroE7mA6Q1bwA4TDNHU9U").

				param("type", "restaurant").

				param("keyword", "rubio").

				when().

				get("/maps/api/place/nearbysearch/json").

				then().assertThat().statusCode(200).and().contentType(ContentType.JSON).log().all().

				and().body("results[0].name", equalTo("Rubio's Coastal Grill"));

	}

}
