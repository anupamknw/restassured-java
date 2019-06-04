package wiremock;

import com.github.tomakehurst.wiremock.WireMockServer;
import io.restassured.RestAssured;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class BaseClass {

        WireMockServer wireMockServer;
        @BeforeClass
        public void setUp()
        {
                wireMockServer=new WireMockServer();
                wireMockServer.start();
                System.out.println("Is wiremock server running: "+wireMockServer.isRunning());
                System.out.println(wireMockServer.baseUrl());
                RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
                RestAssured.baseURI=wireMockServer.baseUrl();
                setupStubForJSON("xyz.json");
                setupStubForXML("abc.xml");
        }

        @AfterClass
        public void tearDown()
        {
                wireMockServer.stop();
                System.out.println("Server stopped");
                System.out.println("Is wiremock server running: "+wireMockServer.isRunning());
        }

        private void setupStubForXML(String file) {
                wireMockServer.stubFor(get(urlEqualTo("/an/xmlendpoint"))
                        .willReturn(aResponse().withHeader("Content-Type", "application/xml")
                                .withStatus(200)
                                .withBodyFile(file)));

        }

        private void setupStubForJSON(String file) {
                wireMockServer.stubFor(get(urlEqualTo("/an/jsonendpoint"))
                        .willReturn(aResponse().withHeader("Content-Type", "application/json")
                                .withStatus(200)
                                .withBodyFile(file)));

        }

}
