package regular;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class postbasicxmlres {

	public static String GenerateStringFromResource(String path) throws IOException {

		return new String(Files.readAllBytes(Paths.get(path)));

	}

	@Test

	public void postdata() throws IOException {

		String postdata = GenerateStringFromResource(
				"/Users/knowledgehub/eclipse-workspace/ResAssuredAPITesting/postdata.xml");

		RestAssured.baseURI = "http://216.10.245.166";

		Response resp = given().

				queryParam("key", "qaclick123").body(postdata).when().post("/maps/api/place/add/xml").then()

				.assertThat().statusCode(200).and().contentType(ContentType.XML).extract().response();

		String response = resp.asString();

		System.out.println(response);

		XmlPath x = new XmlPath(response);

		System.out.println(x.get("Response.place_id").toString());

		// create a place =response (place id)

		// delete place =(Request place id)

	}

}
