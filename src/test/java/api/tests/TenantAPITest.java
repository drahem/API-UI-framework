package api.tests;

import APIComponents.tenants.TenantComponent;
import base.BaseApiTest;
import io.qameta.allure.Feature;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Epic("Tenant Management")
@Feature("Tenant API")
public class TenantAPITest extends BaseApiTest {

    private TenantComponent tenantComponent;

    @BeforeClass
    public void setup() {
        tenantComponent = new TenantComponent();
    }

    @Test(groups = "api", description = "Search for tenants")
    @Story("Tenant Search")
    public void testSearchTenants(){
        Response response = tenantComponent.searchTenants(bearerToken);
        Assert.assertEquals(response.getStatusCode(), 200, "Search tenants should return 200 status code");
    }

    @Test(groups = "api", description = "Get tenants")
    @Story("Get Tenants")
    public void testGetTenants(){
        Response response = tenantComponent.getTenants(bearerToken);
        Assert.assertEquals(response.getStatusCode(), 200, "Get tenants should return 200 status code");
    }
}
