package api.tests;

import APIComponents.users.UserComponent;
import base.BaseApiTest;
import io.qameta.allure.Feature;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Epic("User Management")
@Feature("User API")
public class UserAPITest extends BaseApiTest {

    private UserComponent userComponent;

    @BeforeClass
    public void setup() {
        userComponent = new UserComponent();
    }

    @Test(groups = "api", description = "Get user")
    @Story("Get User")
    public void testGetUser(){
        Response response = userComponent.getUser(bearerToken);
        Assert.assertEquals(response.getStatusCode(), 200, "Get user should return 200 status code");
    }

    @Test(groups = "api", description = "Search for users")
    @Story("User Search")
    public void testSearchUsers(){
        Response response = userComponent.searchUsers(bearerToken);
        Assert.assertEquals(response.getStatusCode(), 200, "Search users should return 200 status code");
    }

    @Test(groups = "api", description = "Get user by ID")
    @Story("Get User by ID")
    public void testGetUserById(){
        Response response = userComponent.getUserById(bearerToken);
        //Assert.assertEquals(response.getStatusCode(), 200, "Get user by ID should return 200 status code");
    }


    public void testCreateUser(){
        Response response = userComponent.createUser(bearerToken);
        Assert.assertEquals(response.getStatusCode(), 200, "Create user should return 200 status code");
    }


    public void testUpdateUser(){
        Response response = userComponent.updateUser(bearerToken);
        Assert.assertEquals(response.getStatusCode(), 200, "Update user should return 200 status code");
    }

    public void testDeleteUser(){
        Response response = userComponent.deleteUser(bearerToken);
        Assert.assertEquals(response.getStatusCode(), 200, "Delete user should return 200 status code");
    }
} 