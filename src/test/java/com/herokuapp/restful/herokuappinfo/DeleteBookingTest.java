package com.herokuapp.restful.herokuappinfo;

import com.herokuapp.restful.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class DeleteBookingTest extends TestBase {
@Test
    public void setDeleteBooking() {
        Response response = given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .auth().preemptive().basic("admin","password123")

                .when()
                .delete("/booking/3504");
        response.prettyPrint();
        response.then().statusCode(201);
    }
}
