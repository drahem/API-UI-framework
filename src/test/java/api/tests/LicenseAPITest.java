package api.tests;

import APIComponents.licenses.LicenseComponent;
import base.BaseApiTest;
import io.qameta.allure.Feature;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Epic("License Management")
@Feature("License API")
public class LicenseAPITest extends BaseApiTest {

    private LicenseComponent licenseComponent;

    @BeforeClass
    public void setup() {
        licenseComponent = new LicenseComponent();
    }

    @Test(groups = "api", description = "Get license information")
    @Story("Get License")
    public void testGetLicense(){
        Response response = licenseComponent.getLicense(bearerToken);
        Assert.assertEquals(response.getStatusCode(), 200, "Get license should return 200 status code");
    }

    @Test(groups = "api", description = "Get license XML")
    @Story("Get License XML")
    public void testGetLicenseXML(){
        Response response = licenseComponent.getLicenseXML(bearerToken);
        Assert.assertEquals(response.getStatusCode(), 200, "Get license XML should return 200 status code");
    }

    @Test(groups = "api", description = "Get license by ID")
    @Story("Get License by ID")
    public void testGetLicenseById(){
        String licenseInfo = licenseComponent.getLicenseInfo(bearerToken);
        String id = licenseComponent.getLicense(bearerToken).jsonPath().get("tenantGuid");
        Response response = licenseComponent.getLicenseById(id, bearerToken);
        Assert.assertEquals(response.getStatusCode(), 200, "Get license by ID should return 200 status code");
    }
}
