package wiremock;

import io.restassured.internal.path.xml.NodeChildrenImpl;
import io.restassured.path.xml.XmlPath;
import org.testng.annotations.Test;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItems;

public class ShoppingContent extends BaseClass {

    @Test
    public void testName()
    {
        given().
                when().
                get("/an/xmlendpoint").
                then().log().all().body("shopping.category.item.name",hasItems("Chocolate","Coffee","Paper","Pens","Kathryn's Birthday"));

    }

    @Test
    public void getName()
    {
        XmlPath xmlPath=given().
                when().
                get("/an/xmlendpoint").
                then().extract().xmlPath();
        NodeChildrenImpl list=xmlPath.get("shopping.category.item.name");
        System.out.println(list.getNodeList());
    }


    @Test
    public void getNameJSON()
    {
        given().
                when().
                get("/an/jsonendpoint").
                then().log().all();
    }
}
