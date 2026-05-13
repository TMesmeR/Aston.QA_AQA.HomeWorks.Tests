import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.http.HttpStatus;
import org.example.EchoDataUser;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class ApiTest {
    @Test
    public void verifyGetMethod() {
        given()
                .baseUri("https://postman-echo.com")
                .when()
                .get("/get")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .log().all();
    }

    @Test
    public void verifyPostMethod() {
        EchoDataUser user = new EchoDataUser("Tomas", "Balbone");
        given()
                .body(user).contentType(ContentType.JSON)
                .baseUri("https://postman-echo.com")
                .contentType(ContentType.JSON)
                .body(user)
                .log().all()
                .when()
                .post("/post")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body("json.userName", equalTo("Tomas"))
                .body("json.lastName", equalTo("Balbone"))
                .log().all();
    }

    @Test
    public void verifySpecTest() {
        RequestSpecification requestSpec = given()
                .baseUri("https://postman-echo.com");
        ResponseSpecification responseSpec = expect()
                .statusCode(HttpStatus.SC_OK);

        requestSpec.
                expect()
                .spec(responseSpec)
                .when()
                .get("/get")
                .then()
                .log().all();

    }
}

