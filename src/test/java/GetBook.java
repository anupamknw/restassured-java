import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;

public class GetBook {
	public static void main(String[] args) {
        RestAssured.baseURI = "http://216.10.245.166";
		RestAssured.given().queryParam("ID", "bczd227")
		.get("/Library/GetBook.php").then().log().all();
		
		JsonPath jsonPath=given().queryParam("ID", "bczd227")
		.get("/Library/GetBook.php").jsonPath();
		String bookName =jsonPath.get("book_name[0]");
		String author=jsonPath.get("author[0]");
		System.out.println(bookName);
		System.out.println(author);
	}
}
