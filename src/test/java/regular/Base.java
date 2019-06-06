package regular;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import io.restassured.RestAssured;

public class Base {

	public static void main(String[] args) {

		RestAssured.baseURI = "http://216.10.245.166";

		given().

				param("location", "-33.8670522,151.1957362").

				param("radius", "500").

				param("key", "qaclick123").

				when().

				get("/maps/api/place/nearbysearch/json").

				then().log().all().assertThat().statusCode(200).and().

				body("results[0].name", equalTo("Sydney"));

	}

}
