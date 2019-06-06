package regular;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.annotations.Test;

import com.google.gson.Gson;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Authorize {

	@Test

	public void authorization() {

		HashMap<Object, Object> request = new HashMap<Object, Object>();

		request.put("grantType", "CLIENT_CREDENTIALS");

		HashMap<String, String> clientDetails = new HashMap<String, String>();

		clientDetails.put("partnerID", "21");

		clientDetails.put("secretCode", "a1WpStEHZOnpVkB");

		request.put("clientDetails", clientDetails);

		Gson gson = new Gson();

		String b = gson.toJson(request);

		System.out.println(b);

		RestAssured.baseURI = "https://stress-gateway.crm-secure.com/gateway-inbound-1.0/v1";

		Response res = given().

				body(b).

				header("Content-Type", "application/json").header("Accept", "text/html").when().post("/oauth/authorize")
				.

				then().log().all().assertThat().contentType("text/html;charset=utf-8").

				extract().response();

		System.out.println("response: " + res.asString());

		Object js = res.jsonPath().get();

		System.out.println(js);

	}

}