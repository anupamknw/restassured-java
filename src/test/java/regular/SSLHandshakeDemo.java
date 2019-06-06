package regular;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class SSLHandshakeDemo {
	public static void main(String[] args) {
	       RestAssured.baseURI = "https://www.tui.co.uk/searchpanel/departureairport/th?duration=7114&multiSelect=&when=&flexible=true&flexibleDays=3&preventCache=1555339255863&instart_disable_injection=true";
	       RestAssured.given().contentType(ContentType.JSON).when().get();
	}
}
