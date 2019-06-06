package regular;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.HttpClientBuilder;

import io.restassured.RestAssured;
import io.restassured.config.HttpClientConfig;

public class Compilation {

	public static void main(String[] args) {
		RequestConfig requestConfig = RequestConfig.custom()
			    .setConnectTimeout(5000)
			    .setConnectionRequestTimeout(5000)
			    .setSocketTimeout(5000)
			    .build();

			HttpClientConfig httpClientFactory = HttpClientConfig.httpClientConfig()
			    .httpClientFactory(() -> HttpClientBuilder.create()
			        .setDefaultRequestConfig(requestConfig)
			        .build());

			RestAssured.config = RestAssured
			    .config()
			    .httpClient(httpClientFactory);
			System.out.println("here");
	}

}