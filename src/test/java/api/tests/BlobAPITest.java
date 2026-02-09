package api.tests;

import APIComponents.blob.BlobComponent;
import base.BaseApiTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Epic("Blob Management")
@Feature("Blob API")
public class BlobAPITest extends BaseApiTest {

    private BlobComponent blobComponent;

    @BeforeClass
    public void setup() {
        blobComponent = new BlobComponent();
    }

    @Test(groups = "api", description = "Search for blobs")
    @Story("Blob Search")
    public void testSearchBlobs() {
        Response response = blobComponent.searchBlobs(bearerToken);
        Assert.assertEquals(response.getStatusCode(), 200, "Search blobs should return 200 status code");
    }

    @Test(groups = "api", description = "Get blob by ID")
    @Story("Get Blob")
    public void testGetBlob() {
        Response response = blobComponent.getBlob(bearerToken);
        response.prettyPrint();
        //Assert.assertEquals(response.getStatusCode(), 200, "Get blob should return 200 status code");
    }

    @Test(groups = "api", description = "Get blob ID from search results")
    @Story("Blob ID Retrieval")
    public void testGetBlobIdFromSearch() {
        String blobId = blobComponent.getBlobIdFromSearch(bearerToken);
        //Assert.assertNotNull(blobId, "Blob ID should not be null");
        //Assert.assertFalse(blobId.isEmpty(), "Blob ID should not be empty");
    }
}
