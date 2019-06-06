package regular;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;

import java.util.List;

import org.testng.Assert;

public class DummyRestAPIExample {
	public static void main(String[] args) {
		RestAssured.baseURI = "http://dummy.restapiexample.com";

		JsonPath jsonPath = given().

				when().

				get("api/v1/employees").

				then().log().all().assertThat().statusCode(200).and().and().header("Server", "nginx/1.14.1").and().

				extract().jsonPath();

		List<String> nameList = jsonPath.get("employee_name");
		
		for (int i = 0; i < nameList.size(); i++) {
				System.out.println(nameList.get(i));
		}
	}

}
