package regular;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class AddBoook {

    @Test

    public void AddBook() {

// TODO Auto-generated method stub

//BaseURL or Host

        RestAssured.baseURI="http://216.10.245.166";
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();



//Parametros con given

        Response res = given().

                header("Content-Type","application/json").

                body(addBookBody()).

                when().

                get("/Library/Addbook.php").

                then().log().body().

                assertThat().statusCode(300).

                extract().response();

        JsonPath jsp = rawToJson(res);

        jsp.get("ID");

        System.out.println(jsp.get("ID").toString());



    }


    public static String addBookBody() {

        String PayloadAddBook = "{" +

                "\"name\":\"Learn Davids book\"," +

                "\"isbn\":\"bcdea\"," +

                "\"aisle\":\"223t\"," +

                "\"author\":\"David Her\"" +

                "}";

        return PayloadAddBook;

    }

    public static XmlPath rawToXml(Response rawdata) {

        String Sresponse = rawdata.asString();

        XmlPath xp = new XmlPath(Sresponse);

        return xp;



    }

    public static JsonPath rawToJson(Response rawdata) {

        String Sresponse = rawdata.asString();

        JsonPath xp = new JsonPath(Sresponse);

        return xp;



    }





}
