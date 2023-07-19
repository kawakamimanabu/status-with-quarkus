package org.hoge;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class StatusResourceTest {

    @Test
    public void test404() {
    	String[] statusToTest = {"404", "0", "-1", "99", "aaaa", "2000", ""};
    	for (String status : statusToTest) {
            given()
            .when().get("/status/" + status)
            .then()
               .statusCode(404)
               .body(is(""));   		
    	}
    }

    @Test
    public void testStatus() {
    	String[] statusToTest = {"200", "500", "599"};
    	for (String status : statusToTest) {
            given()
            .when().get("/status/" + status)
            .then()
               .statusCode(Integer.parseInt(status))
               .body(is(""));   		
    	}
    }

}