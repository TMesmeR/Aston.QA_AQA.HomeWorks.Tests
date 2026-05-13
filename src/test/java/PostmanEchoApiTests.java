import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PostmanEchoApiTests {
    @BeforeClass
    public static void setUpClass() {
        RestAssured.baseURI = "https://postman-echo.com/";
    }

    @Test
    public void testGetRequest() {
        given()
                .queryParam("foo1", "bar1")
                .queryParam("foo2", "bar2")
                .when()
                .get("/get")
                .then()
                .statusCode(200)
                .body("args.foo1", equalTo("bar1"))
                .body("args.foo2", equalTo("bar2"));
    }

    @Test
    public void testPostRawText() {
        String rawText = "Hello World!";

        given()
                .contentType(ContentType.TEXT)
                .body(rawText)
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("data", equalTo(rawText))
                .body("json", nullValue());
    }

    @Test
    public void testPostFormData() {
        given()
                .multiPart("key1", "value1")
                .multiPart("key2", "value2")
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("form.key1", equalTo("value1"))
                .body("form.key2", equalTo("value2"));

    }

    @Test
    public void testPutRequest() {
        Map<String, String> jsonBody = new HashMap<>();
        jsonBody.put("name", "John");
        jsonBody.put("city", "Berlin");

        given()
                .contentType(ContentType.JSON)
                .body(jsonBody)
                .when()
                .put("/put")
                .then()
                .statusCode(200)
                .body("json.name", equalTo("John"))
                .body("json.city", equalTo("Berlin"));
    }

    @Test
    public void testPatchRequest() {
        String patchData = "{ \"status\": \"updated\" }";

        given()
                .contentType(ContentType.JSON)
                .body(patchData)
                .when()
                .patch("/patch")
                .then()
                .statusCode(200)
                .body("json.status", equalTo("updated"));
    }

    @Test
    public void testDeleteRequest() {
        given()
                .queryParam("resourceId", "123")
                .when()
                .delete("/delete")
                .then()
                .statusCode(200)
                .body("args.resourceId", equalTo("123"));
    }
}
