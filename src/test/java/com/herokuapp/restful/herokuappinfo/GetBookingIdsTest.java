package com.herokuapp.restful.herokuappinfo;

import com.herokuapp.restful.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetBookingIdsTest extends TestBase {

    @Test
    public void setGettingBookingIds() {
        Response response = given()
                .header("Content-Type", "application/json")
                .when()
                .get("/booking");
        response.then().statusCode(200);
        response.prettyPrint();
    }
}
