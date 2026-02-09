package api.tests;

import APIComponents.authentication.AuthenticationComponent;
import base.BaseApiTest;
import io.qameta.allure.Feature;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Epic("Authentication Management")
@Feature("Login API")
public class LoginApiTest extends BaseApiTest {

    private AuthenticationComponent authenticationComponent;

    @BeforeClass
    public void setup() {
        authenticationComponent = new AuthenticationComponent();
    }

    @Test(groups = "api", description = "Login with valid credentials")
    @Story("Valid Login")
    public void testLoginWithValidData(){
        Response loginResponse = authenticationComponent.login(portal, route, email, password);
        Assert.assertEquals(loginResponse.getStatusCode(), 200, "Login with valid data should return 200 status code");
    }

    @Test(groups = "api", description = "Login with invalid credentials")
    @Story("Invalid Login")
    public void testLoginWithInvalidData(){
        Response loginResponse = authenticationComponent.login("events-master.dudesoln.com", "school003", "ahmed.ameen@siemens.com", "password");
        Assert.assertEquals(loginResponse.getStatusCode(), 400, "Login with invalid data should return 400 status code");
    }
}
