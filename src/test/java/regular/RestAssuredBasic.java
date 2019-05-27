package regular;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
 
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
 
import org.testng.annotations.Test;
 
public class RestAssuredBasic {
 
    @Test
    public void getPlaceAPI()
    {
        RestAssured.baseURI="https://maps.googleapis.com";
 
        given().
                param("input","murugan idli shop").
                param("key","AIzaSyAjNAnSpPTPRQjd8OgcWAhqTxUVJ1UX5ro").
        when().
                get("/maps/api/place/findplacefromtext/json").
        then().log().all().
                assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
                body("results[0].name",equalTo("Madurai")).and().
                body("results[0].geometry.location.lat", equalTo("9.9252007"));
 
    }
 
}
