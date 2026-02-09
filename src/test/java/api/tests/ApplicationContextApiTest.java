package api.tests;

import APIComponents.applicationContexts.ApplicationContextComponent;
import base.BaseApiTest;
import io.qameta.allure.Feature;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Epic("Application Context Management")
@Feature("Application Context API")
public class ApplicationContextApiTest extends BaseApiTest {

    private ApplicationContextComponent applicationContextComponent;

    @BeforeClass
    public void setup() {
        applicationContextComponent = new ApplicationContextComponent();
    }

    @Test(groups = "api", description = "Get application context tenant")
    @Story("Tenant Context")
    public void testApplicationContextTenant(){
        Response response = applicationContextComponent.getApplicationContextTenant(portal, route, bearerToken);
        Assert.assertEquals(response.getStatusCode(), 200, "Application context tenant should return 200 status code");
    }

    @Test(groups = "api", description = "Get application context site")
    @Story("Site Context")
    public void testApplicationContextSite(){
        Response response = applicationContextComponent.getApplicationContextSite(portal, route, "communitysite", bearerToken);
        Assert.assertEquals(response.getStatusCode(), 200, "Application context site should return 200 status code");
    }
}
