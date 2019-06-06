package regular;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

class ReusableMethod {
	public static JsonPath rawToJson(Response res) {

		// Extracted response will be in Raw format. We need to convert it into String
		// and then to Json.

		String response = res.asString();

		JsonPath js = new JsonPath(response);

		return js;

	}
}

public class StaticJson {

	public static String GenerateStringFromResource(String path) throws IOException {

		return new String(Files.readAllBytes(Paths.get(path)));

	}

	@Test

	public void addBook() throws IOException {

		RestAssured.baseURI = "http://216.10.245.166";

		Response res = given().

				header("ContentType", "application/json").

				body(GenerateStringFromResource(
						"/Users/knowledgehub/eclipse-workspace/ResAssuredAPITesting/static.json"))
				.

				when().post("/Library/Addbook.php").

				then().assertThat().statusCode(200).and().contentType(ContentType.JSON).

				extract().response();

		JsonPath js = ReusableMethod.rawToJson(res);

		Object dd = js.get("ID");

		System.out.println(dd);

		Response res1 = given().

				body("ID").

				when().

				post("/Library/DeleteBook.php").

				then().assertThat().statusCode(200).

				extract().response();

		JsonPath deletemsg = ReusableMethod.rawToJson(res1);

		System.out.println(deletemsg.getString(""));

	}

}