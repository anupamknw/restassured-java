package regular;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ResponseBody;

public class GetBooks {
	public static void main(String[] args) {
		RestAssured.baseURI = "http://216.10.245.166/Library/GetBook.php";
		ResponseBody res = given().param("ID", "bczd227").get().getBody();

		// By using the ResponseBody.asString() method, we can convert the body
		// into the string representation.
		JsonPath jsonPath = res.jsonPath();
		System.out.println(jsonPath.getString("book_name"));
	}
}
