package api.tests;

import APIComponents.filters.FilterComponent;
import base.BaseApiTest;
import io.qameta.allure.Feature;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Epic("Filter Management")
@Feature("Filter API")
public class FilterAPITest extends BaseApiTest {

    private FilterComponent filterComponent;

    @BeforeClass
    public void setup() {
        filterComponent = new FilterComponent();
    }

    @Test(groups = "api", description = "Search for filters" , priority = 0)
    @Story("Filter Search")
    public void testSearchFilters(){
        Response response = filterComponent.searchFilters(bearerToken);
        Assert.assertEquals(response.getStatusCode(), 200, "Search filters should return 200 status code");
    }

    @Test(groups = "api", description = "Delete filter" , priority = 3)
    @Story("Delete Filter")
    public void testDeleteFilter(){
        filterComponent.createFilter(bearerToken);
        String id = filterComponent.getFilterIdFromSearch(bearerToken);
        Response response = filterComponent.deleteFilter(id, bearerToken);
        Assert.assertEquals(response.getStatusCode(), 204, "Delete filter should return 204 status code");
    }

    @Test(groups = "api", description = "Create filter" , priority = 2)
    @Story("Create Filter")
    public void testCreateFilter(){
        Response response = filterComponent.createFilterFromSearch(bearerToken);
        Assert.assertEquals(response.getStatusCode(), 200, "Create filter should return 200 status code");
    }

    @Test(groups = "api", description = "Get filter by ID" , priority = 1)
    @Story("Get Filter by ID")
    public void testGetFilterById(){
        String id = filterComponent.getFilterIdFromSearch(bearerToken);
        Response response = filterComponent.getFilterById(id, bearerToken);
        Assert.assertEquals(response.getStatusCode(), 200, "Get filter by ID should return 200 status code");
    }
}
