package api.tests;

import APIComponents.objectHistories.ObjectHistoryComponent;
import base.BaseApiTest;
import io.qameta.allure.Feature;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Epic("Object History Management")
@Feature("Object History API")
public class ObjectHistoryTest extends BaseApiTest {

    private ObjectHistoryComponent objectHistoryComponent;

    @BeforeClass
    public void setup() {
        objectHistoryComponent = new ObjectHistoryComponent();
    }

    @Test(groups = "api", description = "Search for object history")
    @Story("Object History Search")
    public void testSearchObjectHistory(){
        Response response = objectHistoryComponent.searchObjectHistory(bearerToken);
        Assert.assertEquals(response.getStatusCode(), 200, "Search object history should return 200 status code");
    }

    @Test(groups = "api", description = "Get object history by ID")
    @Story("Get Object History by ID")
    public void testGetObjectHistoryById(){
        Response response = objectHistoryComponent.getObjectHistoryById(bearerToken);
        Assert.assertEquals(response.getStatusCode(), 200, "Get object history by ID should return 200 status code");
    }
}
