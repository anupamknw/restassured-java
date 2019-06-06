package regular;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class JiraAutomation {

	@Test

	public void JiraAPI()

	{

		RestAssured.baseURI = "https://bhavin16692.atlassian.net/";

		Response res =

				given().

						header("Content-Type", "application/json").

						body("{ \"username\": \"bhavin.t@ezdi.us\", \"password\": \"myjirainstance\" }").

						when().

						post("rest/auth/1/session").

						then().

						statusCode(200).log().all().

						extract().response();

		String r = res.getBody().asString();

		System.out.println("HERE IS THE RESPONSE CONVERTED IN STRING" + r);
		System.out.println(res.getBody().asString());
		JsonPath js = new JsonPath(r);

		String session = js.get("session.value");

		System.out.println(session);

	}

}
