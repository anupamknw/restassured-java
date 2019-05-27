package regular;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class AddBooksWithMap {
    public static void main(String[] args) {
        HashMap<String,Object>map=new HashMap<String,Object>();

        map.put("name", "Learn Automation");

        map.put("isbn", "abdc");

        map.put("aisle", "234");

        map.put("author", "suhail khan");

        RestAssured.baseURI="http://216.10.245.166";

        Response resp=given().

                header("Content-Type","application/json").

                body(map).

                when().

                post("/Library/Addbook.php").

                then().assertThat().statusCode(200).

                extract().response();

        JsonPath rep=ReusableMethods.rawToJson(resp);

        String id=rep.get("ID");

        System.out.println(id);


    }
}
