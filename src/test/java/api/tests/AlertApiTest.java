package api.tests;

import APIComponents.alerts.AlertComponent;
import base.BaseApiTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Epic("Alert Management")
@Feature("Alert API")
public class AlertApiTest extends BaseApiTest {

    private AlertComponent alertComponent;

    @BeforeClass
    public void setup() {
        alertComponent = new AlertComponent();
    }

    @Test(groups = "api", description = "Search for alerts")
    @Story("Alert Search")
    public void testSearchAlerts() {
        Response response = alertComponent.searchAlerts(bearerToken);
        Assert.assertEquals(response.getStatusCode(), 200, "Search alerts should return 200 status code");
    }

    public void testGetFirstAlert() {
        Response response = alertComponent.getFirstAlert(bearerToken);
        Assert.assertEquals(response.getStatusCode(), 200, "Get first alert should return 200 status code");
    }
} 