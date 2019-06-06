package regular;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class GoogleAPITest {

	@Test

	public void test()

	{

		RestAssured.baseURI = "https://maps.googleapis.com";

		given().

				param("input", "Museum%20of%20Contemporary%20Art%20Australia").

				param("inputtype", "textquery").

				param("key", "AIzaSyApt0WeLtuK5tqhtKTJkX6MpdRlY1d2hck").

				param("fields", "photos,formatted_address,name,rating,opening_hours,geometry").when().

				get("/maps/api/place/findplacefromtext/json").

				then().

				assertThat().statusCode(200).and().contentType(ContentType.JSON);

		given().

				param("input", "Museum%20of%20Contemporary%20Art%20Australia").

				param("inputtype", "textquery").

				param("key", "AIzaSyApt0WeLtuK5tqhtKTJkX6MpdRlY1d2hck").

				param("fields", "photos,formatted_address,name,rating,opening_hours,geometry").when().

				get("/maps/api/place/findplacefromtext/json").then().log().all();

	}

}
