import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.http.Method;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class TestGet {
	
	@BeforeClass
	public void setUp()
	{
		baseURI="http://restapi.demoqa.com/utilities/weather/city";
		System.out.println("content type - "+given().request(Method.GET,"/Hyderabad").getContentType());
		System.out.println("SessionId: "+given().request(Method.GET,"/Hyderabad").getSessionId());
		System.out.println("Cookies: "+given().request(Method.GET,"/Hyderabad").cookies());
	}
	
	@Test
	public void testGet()
	{
		System.out.println(given().request(Method.GET,"/Hyderabad").getBody().asString());
	}
	
	@Test
	public void testStatusCode()
	{
		System.out.println(given().request(Method.GET, "/Hyderaba").getStatusCode());
		System.out.println(given().request(Method.GET, "/Hyderaba").getStatusLine());
	}
	
	@Test
	public void tgetHeaderTypefromResponse()
	{
		System.out.println("ContentType: "+given().request(Method.GET, "/Hyderabad").header("Content-Type"));
		System.out.println("Server: "+given().request(Method.GET, "/Hyderabad").header("Server"));
		System.out.println("Content-Encoding: "+given().request(Method.GET, "/Hyderabad").header("Content-Encoding"));
		System.out.println("Headers:\n"+given().request(Method.GET, "/Hyderabad").headers().asList());
	}
}
