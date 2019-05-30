package regular;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class AddBookLibrary {
	@Test
	public void addBookLibrary() {

		RestAssured.baseURI = "http://216.10.245.166";

		Response res = given().contentType("image/jpg").header("Content-type", "application/json").

				body(payLoad.addData("133", "567")).when().post("Library/Addbook.php").

				then().log().all().assertThat().statusCode(200).extract().response();

		String response = res.asString();

		System.err.println("Response is: " + response);

		JsonPath j = new JsonPath(response);

		// JsonPath js=ReuseableMethods.rawToJSON(res);

		String id = j.get("ID");

		System.err.println("Id is :" + id);

	}

}

class payLoad {

		public static String addData(String isbn, String aisle) {

		String value = "{\n" + 
				"\n" + 
				"\"name\":\"Learn Appium Automation with Java\",\n" + 
				"\"isbn\":\""+isbn+"\",\n" + 
				"\"aisle\":\""+aisle+"\",\n" + 
				"\"author\":\"John foe\"\n" + 
				"}\n" + 
				" \n" + 
				"";

		System.err.println("Value :" + value);

		return value;

	}

}
