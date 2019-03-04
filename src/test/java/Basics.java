import io.restassured.RestAssured;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

import static org.hamcrest.Matchers.equalTo;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Basics {

	@Test

	public void Test1()

	{

		RestAssured.baseURI = "http://216.10.245.166";

		given().

				param("AuthorName", "Rahul").

				param("key", "qaclick123").

				when().

				get("/Library/GetBook.php").

				then().assertThat().statusCode(200).and().contentType(ContentType.JSON);

		List<String> s = given().

				param("AuthorName", "Rahul").

				param("key", "qaclick123").

				when().

				get("/Library/GetBook.php").jsonPath().get("book_name");

		Assert.assertEquals(s.get(0), "Learn Appium Automation with Java");
	}

}
