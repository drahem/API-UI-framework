package api.tests;

import APIComponents.taskTypes.TaskTypeComponent;
import base.BaseApiTest;
import io.qameta.allure.Feature;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Epic("Task Type Management")
@Feature("Task Type API")
public class TaskTypeAPITest extends BaseApiTest {

    private TaskTypeComponent taskTypeComponent;

    @BeforeClass
    public void setup() {
        taskTypeComponent = new TaskTypeComponent();
    }

    @Test(groups = "api", description = "Search for task types")
    @Story("Task Type Search")
    public void testSearchTaskTypes(){
        Response response = taskTypeComponent.searchTaskTypes(bearerToken);
        Assert.assertEquals(response.getStatusCode(), 200, "Search task types should return 200 status code");
    }

    @Test(groups = "api", description = "Get task type by ID")
    @Story("Get Task Type by ID")
    public void testGetTaskTypeById(){
        Response response = taskTypeComponent.getTaskTypeById(bearerToken);
        response.prettyPrint();
        //Assert.assertEquals(response.getStatusCode(), 200, "Get task type by ID should return 200 status code");
    }


    public void testCreateTaskType(){
        Response response = taskTypeComponent.createTaskType(bearerToken);
        Assert.assertEquals(response.getStatusCode(), 200, "Create task type should return 200 status code");
    }

    public void testEditTaskType(){
        Response response = taskTypeComponent.editTaskType(bearerToken);
        Assert.assertEquals(response.getStatusCode(), 200, "Edit task type should return 200 status code");
    }

    public void testDeleteTaskType(){
        Response response = taskTypeComponent.deleteTaskType(bearerToken);
        Assert.assertEquals(response.getStatusCode(), 204, "Delete task type should return 204 status code");
    }
}
