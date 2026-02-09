package api.tests;

import APIComponents.tasks.TaskComponent;
import base.BaseApiTest;
import io.qameta.allure.Feature;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Epic("Task Management")
@Feature("Task API")
public class TaskAPITest extends BaseApiTest {

    private TaskComponent taskComponent;

    @BeforeClass
    public void setup() {
        taskComponent = new TaskComponent();
    }

    @Test(groups = "api", description = "Search for tasks")
    @Story("Task Search")
    public void testSearchTasks(){
        Response response = taskComponent.searchTasks(bearerToken);
        Assert.assertEquals(response.getStatusCode(), 200, "Search tasks should return 200 status code");
    }

    @Test(groups = "api", description = "Get task by ID")
    @Story("Get Task by ID")
    public void testGetTaskById(){
        Response response = taskComponent.getTaskById(bearerToken);
        Assert.assertEquals(response.getStatusCode(), 200, "Get task by ID should return 200 status code");
    }

    @Test(groups = "api", description = "Create task using data from search")
    @Story("Create Task")
    public void testCreateTask(){
        // This test will:
        // 1. First call search tasks API to get task data
        // 2. Extract the JSON body from the search response
        // 3. Use that JSON body as the request body for create task
        Response response = taskComponent.createTask(bearerToken);
        Assert.assertEquals(response.getStatusCode(), 200, "Create task should return 200 status code");
    }

    @Test(groups = "api", description = "Edit task")
    @Story("Edit Task")
    public void testEditTask(){
        Response response = taskComponent.editTask(bearerToken);
        Assert.assertEquals(response.getStatusCode(), 200, "Edit task should return 200 status code");
    }

    @Test(groups = "api", description = "Delete task")
    @Story("Delete Task")
    public void testDeleteTask(){
        Response response = taskComponent.deleteTask(bearerToken);
        response.prettyPrint();
        Assert.assertEquals(response.getStatusCode(), 204, "Delete task should return 204 status code");
    }
}
