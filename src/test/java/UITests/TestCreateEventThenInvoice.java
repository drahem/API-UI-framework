package UITests;

import annotations.YamlTestCase;
import UIComponents.events.EventsComponent;
import UIComponents.invoice.InvoiceComponent;
import UIComponents.locations.LocationComponent;
import UIComponents.login.LoginComponent;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SettingsPage;
import utils.YamlDataProvider;

import java.util.Map;

@Epic("Event Management")
@Feature("Event Creation and Invoicing")
public class TestCreateEventThenInvoice extends BaseTest {

    @Test(groups = {"regression", "e2e"}, dataProvider = "yamlData", dataProviderClass = YamlDataProvider.class)
    @YamlTestCase("invoice.yaml")
    @Story("Create Event and Generate Invoice")
    @Severity(SeverityLevel.CRITICAL)
    @Description("End to End test: Login, create location, create event, then generate invoice for the event")
    public void testCreateEventThenInvoice(Map<String, Object> testData) throws InterruptedException {

        LoginComponent loginComponent = new LoginComponent(driver);
        
        // Step 1: Login
        loginComponent.navigateToLogin(testData.get("tenant").toString(), testData.get("site").toString());
        loginComponent.doLogin(testData.get("user").toString(), testData.get("pass").toString());

        // Verify login success
        loginComponent.openSettingsPage();
        driver.get("https://events-master.dudesoln.com/administration/auto/communitySite/settings");
        Assert.assertEquals(driver.getCurrentUrl(), "https://events-master.dudesoln.com/administration/auto/communitySite/settings");

        SettingsPage settingsPage = new SettingsPage(driver);
        settingsPage.openLocations();

        // Step 2: Create new location
        LocationComponent locationComponent = new LocationComponent(driver);
        locationComponent.openCreateLocationPage();
        locationComponent.createLocation(
            (String) testData.get("location"),
            (String) testData.get("locationDescription")
        );

        // Step 3: Create new event
        loginComponent.openSettingsPage();
        EventsComponent eventsComponent = new EventsComponent(driver);
        
        // Extract event date components from nested structure
        @SuppressWarnings("unchecked")
        Map<String, Object> eventDate = (Map<String, Object>) testData.get("eventDate");
        String day = eventDate.get("day").toString();
        String month = eventDate.get("month").toString();
        String startTime = eventDate.get("startTime").toString();
        
        eventsComponent.createEvent(
            testData.get("eventTitle").toString(),
            day , month ,
            testData.get("location").toString()
        );

        // Step 4: Create invoice for this event
        InvoiceComponent invoiceComponent = new InvoiceComponent(driver);
        invoiceComponent.createInvoice(
            testData.get("eventTitle").toString(),
            testData.get("invoiceAmount").toString(),
            testData.get("customerName").toString(),
            testData.get("invoiceDescription").toString()
        );

        // Verify invoice was created successfully
        Assert.assertTrue(invoiceComponent.verifyInvoiceCreated(), "Invoice should be created successfully");
        
        // Get and log invoice status
        String invoiceStatus = invoiceComponent.getInvoiceStatus();
        System.out.println("Invoice created with status: " + invoiceStatus);
    }
}
