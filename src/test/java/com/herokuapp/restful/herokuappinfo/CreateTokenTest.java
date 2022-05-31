package com.herokuapp.restful.herokuappinfo;

import com.herokuapp.restful.model.HerokuapPojo;
import com.herokuapp.restful.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class CreateTokenTest extends TestBase {
    @Test
    public void setCreateToken(){
        HerokuapPojo herokuapPojo = new HerokuapPojo();
        herokuapPojo.setUserName("admin");
        herokuapPojo.setPassword("password123");

        Response response = given()
                .header("Content-Type", "application/json")
                .when()
                .body(herokuapPojo)
                .post("/auth");
        response.then().statusCode(200);
        response.prettyPrint();
    }
}
