package regular;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class RestProblem {
	public static void main(String[] args) {
		RestAssured.baseURI = "http://216.10.245.166";

		given().

				param("location", "-33.8670522,151.1957362").

				param("key", "qaclick123").

				when().

				get("/maps/api/place/add/json").

				then().log().all().assertThat().statusCode(200).and().contentType(ContentType.JSON);

	}

}
