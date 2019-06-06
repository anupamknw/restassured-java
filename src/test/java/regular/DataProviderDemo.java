package regular;

import static io.restassured.RestAssured.given;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class DataProviderDemo {

	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[3][2];
		data[0][0] = "thyq2";
		data[0][1] = "78934";

		data[1][0] = "abcg2";
		data[1][1] = "78934";

		data[2][0] = "defh3";
		data[2][1] = "78934";

		return data;
	}

	@Test(dataProvider = "getData")
	public void testDelete(String isbn_no, String aisle_no) {
		RestAssured.baseURI = "http://216.10.245.166";

		Response resp = given().

				header("Content-Type", "application/json").

				body("{\n" + "\n" + "\"name\":\"Learn Appium Automation with Java\",\n" + "\"isbn\":\"" + isbn_no
						+ "\",\n" + "\"aisle\":\"" + aisle_no + "\",\n" + "\"author\":\"John foe\"\n" + "}\n" + " \n"
						+ "")
				.and().when().
				post("Library/Addbook.php").
				then().assertThat().statusCode(200).

				extract().response();
		System.out.println(resp.asString());

		JsonPath js = ReusableMethods.rawToJson(resp);

		String id = js.get("ID");

		System.out.println(id);
		System.out.println("--Delete Request starting--");
		String del = given().body("{\n" + " \n" + "\"ID\" : \"" + id + "\"\n" + " \n" + "}\n" + "").when()
				.delete("Library/DeleteBook.php").getBody().asString();
		System.out.println(del);
		System.out.println("-----------------");

	}

}
