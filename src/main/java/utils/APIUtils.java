package utils;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.util.logging.Logger;
import java.util.logging.Level;

public class APIUtils {
    private static String baseUrl;
    private static final Logger logger = Logger.getLogger(APIUtils.class.getName());

    public static void setBaseUrl(String url) {
        baseUrl = url;
        RestAssured.baseURI = baseUrl;
        logger.info("Base URL set to: " + baseUrl);
    }

    public static Response get(String endpoint) {
        logger.info("Making GET request to: " + endpoint);
        Response response = RestAssured.given()
                .when()
                .get(endpoint)
                .then()
                .extract()
                .response();
        logger.info("GET request completed. Status: " + response.getStatusCode() + ", Response time: " + response.getTime() + "ms");
        return response;
    }

    public static Response get(String endpoint, String bearerToken) {
        logger.info("Making GET request to: " + endpoint + " with Bearer token");
        Response response = RestAssured.given()
                .header("Authorization", "Bearer " + bearerToken)
                .when()
                .get(endpoint)
                .then()
                .extract()
                .response();
        logger.info("GET request completed. Status: " + response.getStatusCode() + ", Response time: " + response.getTime() + "ms");
        return response;
    }

    public static Response postWithBody(String endpoint, String body) {
        logger.info("Making POST request to: " + endpoint);
        logger.info("Request body: " + body);
        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .body(body)
                .when()
                .post(endpoint)
                .then()
                .extract()
                .response();
        logger.info("POST request completed. Status: " + response.getStatusCode() + ", Response time: " + response.getTime() + "ms");
        return response;
    }

    public static Response postWithBody(String endpoint, String body, String bearerToken) {
        logger.info("Making POST request to: " + endpoint + " with Bearer token");
        logger.info("Request body: " + body);
        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + bearerToken)
                .body(body)
                .when()
                .post(endpoint)
                .then()
                .extract()
                .response();
        logger.info("POST request completed. Status: " + response.getStatusCode() + ", Response time: " + response.getTime() + "ms");
        return response;
    }

    public static Response putWithBody(String endpoint, String body) {
        logger.info("Making PUT request to: " + endpoint);
        logger.info("Request body: " + body);
        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .body(body)
                .when()
                .put(endpoint)
                .then()
                .extract()
                .response();
        logger.info("PUT request completed. Status: " + response.getStatusCode() + ", Response time: " + response.getTime() + "ms");
        return response;
    }

    public static Response putWithBody(String endpoint, String body, String bearerToken) {
        logger.info("Making PUT request to: " + endpoint + " with Bearer token");
        logger.info("Request body: " + body);
        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + bearerToken)
                .body(body)
                .when()
                .put(endpoint)
                .then()
                .extract()
                .response();
        logger.info("PUT request completed. Status: " + response.getStatusCode() + ", Response time: " + response.getTime() + "ms");
        return response;
    }

    public static Response deleteWithPathParam(String endpoint, String paramName, String paramValue) {
        logger.info("Making DELETE request to: " + endpoint + " with path param: " + paramName + "=" + paramValue);
        Response response = RestAssured.given()
                .pathParam(paramName, paramValue)
                .when()
                .delete(endpoint)
                .then()
                .extract()
                .response();
        logger.info("DELETE request completed. Status: " + response.getStatusCode() + ", Response time: " + response.getTime() + "ms");
        return response;
    }

    public static Response deleteWithPathParam(String endpoint, String paramName, String paramValue, String bearerToken) {
        logger.info("Making DELETE request to: " + endpoint + " with path param: " + paramName + "=" + paramValue + " and Bearer token");
        Response response = RestAssured.given()
                .header("Authorization", "Bearer " + bearerToken)
                .pathParam(paramName, paramValue)
                .when()
                .delete(endpoint)
                .then()
                .extract()
                .response();
        logger.info("DELETE request completed. Status: " + response.getStatusCode() + ", Response time: " + response.getTime() + "ms");
        return response;
    }

    public static Response deleteWithBody(String endpoint, String body, String bearerToken) {
        logger.info("Making DELETE request to: " + endpoint + " with Bearer token");
        logger.info("Request body: " + body);
        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + bearerToken)
                .body(body)
                .when()
                .delete(endpoint)
                .then()
                .extract()
                .response();
        logger.info("DELETE request completed. Status: " + response.getStatusCode() + ", Response time: " + response.getTime() + "ms");
        return response;
    }

    public static RequestSpecification getRequestSpecification() {
        return RestAssured.given();
    }

    public static String convertToJson(Object object) {
        Gson gson = new Gson();
        return gson.toJson(object);
    }
}