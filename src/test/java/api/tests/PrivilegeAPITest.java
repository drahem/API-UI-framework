package api.tests;

import APIComponents.privileges.PrivilegeComponent;
import base.BaseApiTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Epic("Privilege Management")
@Feature("Privilege API")
public class PrivilegeAPITest extends BaseApiTest {

    private PrivilegeComponent privilegeComponent;

    @BeforeClass
    public void setup() {
        privilegeComponent = new PrivilegeComponent();
    }

    @Test(groups = "api", description = "Search for privileges")
    @Story("Privilege Search")
    public void testSearchPrivileges(){
        Response response = privilegeComponent.searchPrivileges(bearerToken);
        Assert.assertEquals(response.getStatusCode(), 200, "Search privileges should return 200 status code");
    }

    @Test(groups = "api", description = "Get privilege")
    @Story("Get Privilege")
    public void testGetPrivilege(){
        Response response = privilegeComponent.getPrivilege(bearerToken);
        Assert.assertEquals(response.getStatusCode(), 200, "Get privilege should return 200 status code");
    }

    @Test(groups = "api", description = "Delete privilege")
    @Story("Delete Privilege")
    public void testDeletePrivilege(){
        Response response = privilegeComponent.deletePrivilege(bearerToken);
        //Assert.assertEquals(response.getStatusCode(), 204, "Delete privilege should return 204 status code");
    }

    public void testCreatePrivilege(){
        //privilegeComponent.deletePrivilege(bearerToken);
        Response response = privilegeComponent.createPrivilege(bearerToken);
        Assert.assertEquals(response.getStatusCode(), 200, "Create privilege should return 200 status code");
    }

    @Test(groups = "api", description = "Update privilege")
    @Story("Update Privilege")
    public void testUpdatePrivilege(){
        Response response = privilegeComponent.updatePrivilege(bearerToken);
        //Assert.assertEquals(response.getStatusCode(), 200, "Update privilege should return 200 status code");
    }
}
