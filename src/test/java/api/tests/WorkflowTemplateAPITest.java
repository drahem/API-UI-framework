package api.tests;

import APIComponents.workflowTemplates.WorkflowTemplateComponent;
import base.BaseApiTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Epic("Workflow Template Management")
@Feature("Workflow Template API")
public class WorkflowTemplateAPITest extends BaseApiTest {

    private WorkflowTemplateComponent workflowTemplateComponent;

    @BeforeClass
    public void setup() {
        workflowTemplateComponent = new WorkflowTemplateComponent();
    }

    @Test(groups = "api", description = "Search for workflow templates")
    @Story("Workflow Template Search")
    public void testSearchWorkflowTemplates(){
        Response response = workflowTemplateComponent.searchWorkflowTemplates(bearerToken);
        Assert.assertEquals(response.getStatusCode(), 200, "Search workflow templates should return 200 status code");
    }

    @Test(groups = "api", description = "Get workflow template by ID")
    @Story("Get Workflow Template")
    public void testGetWorkflowTemplate(){
        Response response = workflowTemplateComponent.getWorkflowTemplateById(bearerToken);
        Assert.assertEquals(response.getStatusCode(), 200, "Get workflow template should return 200 status code");
    }
}
