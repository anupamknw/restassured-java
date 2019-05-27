package regular;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasToString;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class Try5_POST_XML {

	@Test
	public void postData() throws IOException {
		String postdata = GenerateStringFromResource(
				"/Users/knowledgehub/eclipse-workspace/ResAssuredAPITesting/abcd.xml");
		RestAssured.baseURI = "http://216.10.245.166";
		
		Response res = given().

				given().queryParam("key", "qaclick123").

				body(postdata).when().post("maps/api/place/add/xml").

				then().assertThat().statusCode(200).and().contentType(ContentType.XML).and()
				.extract().response();

		
		// String responseString=res.asString();
		// System.out.println(responseString);
		XmlPath x = Reusable_methods.rawToXML(res);
		String status = (x.get("PlaceAddResponse.status"));
		System.out.println("status=" + status);

	}

	public static String GenerateStringFromResource(String path) throws IOException {
		return new String(Files.readAllBytes(Paths.get(path)));
	}
}

class Reusable_methods {
 
	
	public static XmlPath rawToXML(Response res)
	{
		String respon=res.asString();
		XmlPath x=new XmlPath(respon);
		return x;
	}
	
	
	public static JsonPath rawToJSON(Response res)
	{		
		String responseString=res.asString();
		JsonPath js= new JsonPath(responseString);
		return js;
	}
}
