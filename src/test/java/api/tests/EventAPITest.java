package api.tests;

import APIComponents.events.EventComponent;
import base.BaseApiTest;
import io.qameta.allure.Feature;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Epic("Event Management")
@Feature("Event API")
public class EventAPITest extends BaseApiTest {

    private EventComponent eventComponent;

    @BeforeClass
    public void setup() {
        eventComponent = new EventComponent();
    }

    @Test(groups = "api", description = "Search for events")
    @Story("Event Search")
    public void testSearchEvents(){
        Response response = eventComponent.searchEvents(bearerToken);
        Assert.assertEquals(response.getStatusCode(), 200, "Search events should return 200 status code");
    }

    @Test(groups = "api", description = "Get event details by ID")
    @Story("Get Event Details")
    public void testGetEventDetails() {
        String id = eventComponent.getEventIdFromSearchResults(bearerToken);
        Response response = eventComponent.getEventById(id, bearerToken);
        Assert.assertEquals(response.getStatusCode(), 200, "Get event details should return 200 status code");
    }

    @Test(groups = "api", description = "Search versioned events")
    @Story("Versioned Event Search")
    public void testSearchVersionedEvents(){
        Response response = eventComponent.searchVersionedEvents(bearerToken);
        Assert.assertEquals(response.getStatusCode(), 200, "Search versioned events should return 200 status code");
    }

    @Test(groups = "api", description = "Search event conflicts")
    @Story("Event Conflicts")
    public void testSearchEventsConflicts(){
        String id = eventComponent.getEventIdFromSearchResults(bearerToken);
        Response response = eventComponent.searchEventConflicts(id, bearerToken);
        Assert.assertEquals(response.getStatusCode(), 200, "Search event conflicts should return 200 status code");
    }
} 