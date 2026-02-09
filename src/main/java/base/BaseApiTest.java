package base;

import config.ConfigManager;
import io.restassured.RestAssured;
import io.restassured.config.SSLConfig;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import utils.APIUtils;

public class BaseApiTest {

    protected String baseUrl;
    public String bearerToken;
    public String email;
    public String password;
    public String portal;
    public String route;
    
    private static RequestSpecification requestSpec = RestAssured.given();
    // All tests shared the same requestSpec

    @BeforeSuite
    public void setup() {
        RestAssured.config = RestAssured.config()
                .sslConfig(SSLConfig.sslConfig().relaxedHTTPSValidation());
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();

        // Enable detailed logging for debugging
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        System.out.println("RestAssured setup completed");
    }

    @BeforeClass
    public void setupBaseUrlForAllTests() {
        // Load configuration values
        this.baseUrl = ConfigManager.getBaseApiUrl();
        this.email = ConfigManager.getEmail();
        this.password = ConfigManager.getPassword();
        this.portal = ConfigManager.getPortal();
        this.route = ConfigManager.getRoute();
        
        System.out.println("Setting base URL: " + this.baseUrl);
        System.out.println("Using email: " + this.email);
        System.out.println("Using portal: " + this.portal);
        System.out.println("Using route: " + this.route);
        
        APIUtils.setBaseUrl(this.baseUrl);

            // Authenticate and store the bearer token for use in tests
    }

    @AfterMethod
    public void cleanupAfterTest() {
        // Reset RestAssured to ensure clean state between tests
        RestAssured.reset();
        // Re-set the base URL after reset
        APIUtils.setBaseUrl(this.baseUrl);
    }
}