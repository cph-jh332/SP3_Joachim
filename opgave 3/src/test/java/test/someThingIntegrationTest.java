package test;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import io.restassured.parsing.Parser;
import static org.hamcrest.CoreMatchers.equalTo;

/**
 *
 * @author craci
 */
public class someThingIntegrationTest {

    public someThingIntegrationTest() {
    }

    @BeforeClass
    public static void setUpBeforeAll() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
        RestAssured.basePath = "/Test1";
        RestAssured.defaultParser = Parser.JSON;
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void serverIsRunning() {
        given().
                when().get().
                then().
                statusCode(200);
    }

    @Test
    public void addOperation() {
        given().pathParam("n1", 2).pathParam("n2", 2).
                when().get("/api/calculator/add/{n1}/{n2}").
                then().
                statusCode(200).
                body("result", equalTo(4), "operation", equalTo("2 + 2"));
    }

    @Test
    public void subOperation() {
        given().pathParam("n1", 2).pathParam("n2", 2).
                when().get("/api/calculator/sub/{n1}/{n2}").
                then().
                statusCode(200).
                body("result", equalTo(0), "operation", equalTo("2 - 2"));
    }

    @Test
    public void divOperation() {
        given().pathParam("n1", 2).pathParam("n2", 2).
                when().get("/api/calculator/div/{n1}/{n2}").
                then().
                statusCode(200).
                body("result", equalTo(1), "operation", equalTo("2 / 2"));
    }

    @Test
    public void mulOperation() {
        given().pathParam("n1", 2).pathParam("n2", 2).
                when().get("/api/calculator/mul/{n1}/{n2}").
                then().
                statusCode(200).
                body("result", equalTo(4), "operation", equalTo("2 * 2"));
    }

    @Test
    public void addOperationWrongArguments() {
        given().pathParam("n1", 2).pathParam("n2", 2.2).
                when().get("/api/calculator/add/{n1}/{n2}").
                then().
                statusCode(400).
                body("code", equalTo(400));
    }

    @Test
    public void pathOperationWrongArguments() {
        given().pathParam("n1", 2).pathParam("n2", 2.2).
                when().get("/api/calculator/abc/{n1}/{n2}").
                then().
                statusCode(404).
                body("code", equalTo(404));
    }

    @Test
    public void divOperationWrongArguments() {
        given().pathParam("n1", 2).pathParam("n2", 0).
                when().get("/api/calculator/div/{n1}/{n2}").
                then().
                statusCode(500).
                body("code", equalTo(500));
    }

}
