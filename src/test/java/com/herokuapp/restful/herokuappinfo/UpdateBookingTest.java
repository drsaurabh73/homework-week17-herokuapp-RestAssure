package com.herokuapp.restful.herokuappinfo;

import com.herokuapp.restful.model.HerokuapPojo;
import com.herokuapp.restful.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class UpdateBookingTest extends TestBase {

    @Test
    public void setGettingBookingUpdates() {
        HashMap<Object,Object> dates = new HashMap<>();
        dates.put("checkin","2018-01-01");
        dates.put("checkout","2019-01-01");

        HerokuapPojo herokuapPojo = new HerokuapPojo();
        herokuapPojo.setFirstname("James");
        herokuapPojo.setLastname("Brown");
        herokuapPojo.setTotalprice(111);
        herokuapPojo.setDepositpaid(true);
        herokuapPojo.setBookingdates(dates);
        herokuapPojo.setAdditionalneeds("Breakfast");

        Response response = given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .auth().preemptive().basic("admin","password123")
                .body(herokuapPojo)
                .when()
                .put("/booking/3312");
        response.prettyPrint();
        response.then().statusCode(200);
    }

}
