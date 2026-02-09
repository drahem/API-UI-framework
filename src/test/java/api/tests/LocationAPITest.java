package api.tests;

import APIComponents.locations.LocationApiComponent;
import base.BaseApiTest;
import io.qameta.allure.Feature;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Epic("Location Management")
@Feature("Location API")
public class LocationAPITest extends BaseApiTest {

    private LocationApiComponent locationApiComponent;

    @BeforeClass
    public void setup() {
        locationApiComponent = new LocationApiComponent();
    }

    @Test(groups = "api", description = "Search for locations")
    @Story("Location Search")
    public void testSearchLocations(){
        Response response = locationApiComponent.searchLocations(bearerToken);
        Assert.assertEquals(response.getStatusCode(), 200, "Search locations should return 200 status code");
    }

    @Test(groups = "api", description = "Get location by ID")
    @Story("Get Location by ID")
    public void testGetLocationById(){
        Response response = locationApiComponent.getLocationById(bearerToken);
        Assert.assertEquals(response.getStatusCode(), 200, "Get location by ID should return 200 status code");
    }
} 