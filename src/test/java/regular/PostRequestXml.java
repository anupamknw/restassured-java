package regular;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class PostRequestXml {
	public static String generateStringFromResource(String filePath) throws IOException {
		return new String(Files.readAllBytes(Paths.get(filePath)));
	}

	@Test
	public void postRequestXML() throws IOException {
		String postData = generateStringFromResource(
				"/Users/knowledgehub/eclipse-workspace/ResAssuredAPITesting/abcd.xml");
		RestAssured.baseURI = "http://216.10.245.166";

		Response resp = given().queryParam("key", "qaclick123").body(postData).when().post("/maps/api/place/add/xml")
				.then().assertThat().statusCode(200).and().contentType(ContentType.XML).extract().response();

		XmlPath x = Reusable_methods1.rawToXML(resp);
		String status = x.get("response.status");
		System.out.println(status);

	}
}

class Reusable_methods1 {

	public static JsonPath rawToJSON(Response res) {
		String responseString = res.asString();
		JsonPath js = new JsonPath(responseString);
		return js;
	}

	public static XmlPath rawToXML(Response res) {
		String respon = res.asString();
		XmlPath x = new XmlPath(respon);
		return x;
	}
}
