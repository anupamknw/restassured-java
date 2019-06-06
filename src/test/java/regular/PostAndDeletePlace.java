package regular;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;

public class PostAndDeletePlace {
	@org.testng.annotations.Test
	public void MapAPIAddAndDeletePlaceTest() throws Exception {
		RestAssured.baseURI = "http://216.10.245.166";

		JsonPath js = given().

				queryParam("key", "qaclick123").

				body("{\n" + "    \"location\": {\n" + "        \"lat\": -38.383494,\n" + "        \"lng\": 33.427362\n"
						+ "    },\n" + "    \"accuracy\": 50,\n" + "    \"name\": \"Frontline house\",\n"
						+ "    \"phone_number\": \"(+91) 983 893 3937\",\n"
						+ "    \"address\": \"29, side layout, cohen 09\",\n" + "    \"types\": [\n"
						+ "        \"shoe park\",\n" + "        \"shop\"\n" + "    ],\n"
						+ "    \"website\": \"http://google.com\",\n" + "    \"language\": \"French-IN\"\n" + "}")
				.

				when().

				post("/maps/api/place/add/json").

				then().log().all().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().

				body("status", equalTo("OK")).extract().jsonPath();

		// GET PLACE ID
		String placeId = js.get("place_id");
		System.out.println(placeId);

		// DELETE REQUEST WITH EXTRACTED PLACE ID

		given().when().body(payload1.GetPlaceDeleteJson(placeId)).post("/maps/api/place/delete/json?key=qaclick123")
				.then().log().all().and().assertThat().statusCode(200);

	}

}

class payload1 {
	public static String GetPlaceDeleteJson(String placeId) {
		return "{" + "\"place_id\" : \"" + placeId + "\"" + "}";
	}
}
