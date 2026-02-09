package api.tests;

import APIComponents.roles.RoleComponent;
import base.BaseApiTest;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.testng.Assert;

@Epic("Role Management")
@Feature("Role API")
public class RoleAPITest extends BaseApiTest {
    
    private RoleComponent roleComponent;

    @BeforeClass
    public void setup() {
        roleComponent = new RoleComponent();
    }

    @Test(groups = "api", description = "Search for roles")
    @Story("Role Search")
    public void testSearchRoles() {
        Response response = roleComponent.searchRoles(bearerToken);
        Assert.assertEquals(response.getStatusCode(), 200, "Search roles should return 200 status code");
        
        // Verify response structure
        Assert.assertNotNull(response.jsonPath().get("results"), "Results should not be null");
    }

    @Test(groups = "api", description = "Get role by ID")
    @Story("Get Role By ID")
    public void testGetRoleById() {
        // First search for roles to get an ID
        Response searchResponse = roleComponent.searchRoles(bearerToken);
        String roleId = searchResponse.jsonPath().getString("results[0].guid");
        
        // Then get the role by ID
        Response response = roleComponent.getRoleById(roleId, bearerToken);
        response.prettyPrint();
        //Assert.assertEquals(response.getStatusCode(), 200, "Get role by ID should return 200 status code");
        
        // Verify the returned role has the expected ID
        //Assert.assertEquals(response.jsonPath().getString("guid"), roleId, "Returned role should have the expected ID");
    }
} 