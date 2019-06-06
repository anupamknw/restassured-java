package regular;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class AddBooks {

	@Test

	public void addBook() throws IOException {

		RestAssured.baseURI = "http://216.10.245.166";

		Response resp = given().

				header("Content-Type", "application/json").

				body("{\n" + "\n" + "\"name\":\"Learn Appium Automation with Java\",\n" + "\"isbn\":\"bczp\",\n"
						+ "\"aisle\":\"22t\",\n" + "\"author\":\"John foe\"\n" + "}\n" + " \n" + "")
				.and().

				when().

				post("Library/Addbook.php").

				then().log().all().assertThat().statusCode(200).

				extract().response();

		JsonPath js = ReusableMethods.rawToJson(resp);

		String id = js.get("ID");

		System.out.println(id);

	}

}

class ReusableMethods {
	public static JsonPath rawToJson(Response res) {

		// Extracted response will be in Raw format. We need to convert it into String
		// and then to Json.

		String response = res.asString();

		JsonPath js = new JsonPath(response);

		return js;

	}
}