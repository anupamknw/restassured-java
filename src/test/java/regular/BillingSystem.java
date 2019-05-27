package regular;

import java.util.List;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class BillingSystem {
	public static void main(String[] args) {
		RestAssured.baseURI = "http://localhost:3000";
		JsonPath jsonPath = RestAssured.given().get("/smaple").then().log().all().extract().jsonPath();

		List<String> BillingSystemPlanId = jsonPath.get("BillingSystemPlanId");

		List<String> PlanName = jsonPath.get("PlanName");

		List<String> PlanDescription = jsonPath.get("PlanDescription");

		List<String> SubscriptionInfo = jsonPath.get("SubscriptionInfo");

		System.out.println(BillingSystemPlanId);
		System.out.println(PlanName);
		System.out.println(PlanDescription);
		System.out.println(SubscriptionInfo);

		for (int i = 0; i < SubscriptionInfo.size(); i++) {

			if (SubscriptionInfo.get(i) == null) {

				System.out.println(BillingSystemPlanId.get(i));

				System.out.println(PlanName.get(i));

				System.out.println(PlanDescription.get(i));
				System.out.println("-------");
			}

		}
	}

}
