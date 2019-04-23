import org.testng.annotations.Test;

import io.restassured.RestAssured;

import io.restassured.http.ContentType;

import io.restassured.path.json.JsonPath;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

import static org.hamcrest.Matchers.equalTo;

public class AddAndDeletePlaceTest {

	@Test

	public void addPlaceTest() {

		RestAssured.baseURI = "http://216.10.245.166";

		String addPlaceRequestPayLaod = "{\n" +

				" \"location\":{\n" +

				" \"lat\" : -38.383494,\n" +

				" \"lng\" : 33.427362\n" +

				" },\n" +

				" \"accuracy\":50,\n" +

				" \"name\":\"Frontline house\",\n" +

				" \"phone_number\":\"(+91) 983 893 3937\",\n" +

				" \"address\" : \"29, side layout, cohen 09\",\n" +

				" \"types\": [\"shoe park\",\"shop\"],\n" +

				" \"website\" : \"http://google.com\",\n" +

				" \"language\" : \"French-IN\"\n" +

				"}";

		Response response = given().

				queryParam("key", "qaclick123").

				body(addPlaceRequestPayLaod).

				when().

				post("/maps/api/place/add/json").

				then().assertThat().

				statusCode(200).

				and().

				contentType(ContentType.JSON).

				and().

				body("status", equalTo("OK")).

				extract().response();

		String responseString = response.asString();

		JsonPath jsonPath = new JsonPath(responseString);

		String placeId = jsonPath.get("place_id");

		given().log().all().

				queryParam("key", "qaclick123").

				body("{\n" +

						"\"place_id\": \"" + placeId + "\"\n" +

						"}")
				.

				when().

				post("/maps/api/place/delete/json").

				then().assertThat().

				statusCode(200).

				body("status", equalTo("OK")).

				contentType(ContentType.JSON).

				header("Server", "Apache");

	}

}
