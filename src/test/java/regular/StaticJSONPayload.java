package regular;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

public class StaticJSONPayload {

    @Test
    public void libraryapi() throws IOException {


        RestAssured.baseURI = "http://216.10.245.166";

        Response re = given()

                .header("Content-Type", "application/json")

                .body(GenerateStringFromResource("/Users/in-anupamp/restassured-java/src/test/java/regular/addbook.json"))

                .when().post("/Library/Addbook.php").then().assertThat()

                .statusCode(200).and().contentType(ContentType.JSON).extract()

                .response();

        JsonPath j = ReuseableMethod.rawtojson(re);

        String id = j.get("ID");

        System.out.println(id);

        given().body(PayLoad.deletebook(id)).when()

                .post("/Library/DeleteBook.php").then().assertThat()

                .statusCode(200).contentType(ContentType.JSON).and()

                .body("msg", equalTo("book is successfully deleted"));


    }

    public static String GenerateStringFromResource(String path)

            throws IOException {

        return new String(Files.readAllBytes(Paths.get(path)));

    }

}

class PayLoad
{
    public static String deletebook(String id) {

        String deletepayload = "{\r\n \r\n\"ID\" : \"" + id + "\"\r\n \r\n}";

        return deletepayload;

    }
}

class ReuseableMethod {



    public static XmlPath rawtoxml(Response re) {

        String resp = re.asString();



        XmlPath xm = new XmlPath(resp);

        return xm;

    }



    public static JsonPath rawtojson(Response re) {

        String resp = re.asString();



        JsonPath js = new JsonPath(resp);

        return js;

    }



}




