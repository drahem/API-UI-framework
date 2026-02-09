package api.tests;

import APIComponents.versions.VersionComponent;
import base.BaseApiTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Epic("Version Management")
@Feature("Version API")
public class VersionAPITest extends BaseApiTest {

    private VersionComponent versionComponent;

    @BeforeClass
    public void setup() {
        versionComponent = new VersionComponent();
    }

    @Test(groups = "api", description = "Search for versions")
    @Story("Version Search")
    public void testSearchVersions(){
        Response response = versionComponent.searchVersions(bearerToken);
        Assert.assertEquals(response.getStatusCode(), 200, "Search versions should return 200 status code");
    }
}
