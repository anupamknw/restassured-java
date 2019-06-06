package regular;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.List;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Test {
	@org.testng.annotations.Test
	public static void testMe() {
		// public static void main(String[] args) {
		// TODO Auto-generated method stub

		RestAssured.baseURI = "https://maps.googleapis.com";

		Response rawResponse = given().param("location", "-33.8670522,151.1957362").param("radius", 1500)
				.param("key", "AIzaSyBSnWeJu6w1j3KGVnn6Jx2JhMvLuuqoPj0").log().all().

				when().get("/maps/api/place/nearbysearch/json").

				then().log().all().assertThat().statusCode(200).and().body("results[0].name", equalTo("Sydney")).and()
				.body("results[0].place_id", equalTo("ChIJP3Sa8ziYEmsRUKgyFmh9AQM")).and()
				.header("Server", "scaffolding on HTTPServer2").and()
				.header("Content-Type", "application/json; charset=UTF-8").log().body().

				extract().response();
		String s = rawResponse.asString();
		JsonPath jp = new JsonPath(s);
		// To get place name of all the 20 responses in response
		int totObjects = jp.get("results.size()");
		System.out.println(totObjects);
		List<Float> li = jp.get("results.geometry.viewport.southwest.lng");
		System.out.println(li.size());
		for (int i = 0; i < li.size(); i++) {
			System.out.println(li.get(0));
		}
		/*
		 * for(int i=0; i<totObjects ;i++) { //Get name of all 20 objects String
		 * namei=jp.get("results["+i+"].name"); System.out.println(namei); // String
		 * namei=jp.get("results["+i+"].geometry.viewport.southwest.lng"); //
		 * System.out.println(namei); }
		 */
	}
}
