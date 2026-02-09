package api.tests;

import APIComponents.health.HealthComponent;
import base.BaseApiTest;
import io.qameta.allure.Feature;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Epic("Health Management")
@Feature("Health API")
public class HealthTest extends BaseApiTest {

    private HealthComponent healthComponent;

    @BeforeClass
    public void setup() {
        healthComponent = new HealthComponent();
    }

    @Test(groups = "api", description = "Check health status")
    @Story("Health Check")
    public void testHealthStatus(){
        Response response = healthComponent.getHealthStatus(bearerToken);
        Assert.assertEquals(response.getStatusCode(), 200, "Health check should return 200 status code");
    }

    @Test(groups = "api", description = "Verify service is healthy")
    @Story("Service Health")
    public void testServiceHealth(){
        boolean isHealthy = healthComponent.isServiceHealthy(bearerToken);
        Assert.assertTrue(isHealthy, "Service should be healthy");
    }
}
