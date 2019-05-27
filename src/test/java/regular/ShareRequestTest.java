package regular;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import models.ShareRequest;
import org.testng.annotations.Test;

public class ShareRequestTest {

    @Test
    public void testShareRequest(String id, String security, String buySell, String quantity, String priceInCents, String totalCostInCents)
    {
        ShareRequest shareRequest=new ShareRequest(id,security,buySell,quantity,priceInCents,totalCostInCents);

        given().
                contentType("application/json").
                body(shareRequest).
                when().
                post("http://localhost:9876/sharerequest").
                then().
                assertThat().
                body(equalTo("ShareRequest has been processed."));
    }
}
