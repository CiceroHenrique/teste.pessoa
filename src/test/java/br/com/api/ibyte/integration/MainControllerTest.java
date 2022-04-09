package br.com.api.test.integration;

import static io.restassured.RestAssured.given;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class MainControllerTest {

  @Test
  public void helloWordTestEndPoint() {
    given().when().get("/config/supersonic").then().statusCode(200); // .body(is("Mach"));
  }
}
