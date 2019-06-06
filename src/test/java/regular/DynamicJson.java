package regular;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;

import io.restassured.path.json.JsonPath;

import io.restassured.response.Response;

import java.io.IOException;

import org.testng.annotations.Test;

public class DynamicJson {

	@Test

	public void addBook() throws IOException

	{

		RestAssured.baseURI = "http://216.10.245.166";

		Response res1 = given().

				header("Content-Type", "application/json").

				body(PayLoad.addBook("jkdja", "67")).

				when().

				post("/Library/Addbook.php").

				then().log().all().assertThat().statusCode(200).extract().response();

		JsonPath js = ReusableMethods1.rawToJson(res1);

		String id = js.get("ID");

		System.out.println(id);

	}

}

class ReusableMethods1 {

	public static JsonPath rawToJson(Response res) {

		String response = res.asString();

		JsonPath js = new JsonPath(response);

		return js;

	}

}

class PayLoad {

	public static String addBook(String isbn, String aisle)

	{

		String PayLoad = "{\n" + "\n" + "\"name\":\"Learn Appium Automation with Java\",\n" + "\"isbn\":\"" + isbn
				+ "\",\n" + "\"aisle\":\"" + aisle + "\",\n" + "\"author\":\"John foe\"\n" + "}\n" + " \n"
				+ "";

		return PayLoad;

	}

}
