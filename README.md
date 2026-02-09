# Jarvis - API and UI Test Automation Framework

Welcome! This is a **test automation framework** for testing both **APIs** (Application Programming Interfaces) and **UI** (User Interface - the website you see in your browser). If you're new to test automation, don't worry - this guide will walk you through everything step by step.

## 📖 What is This Project?

This project helps you **automatically test both APIs and web applications** instead of testing them manually. Think of it like a robot that can:
- **For APIs:** Send requests to APIs (like asking a server for information) and check if the responses are correct
- **For UI:** Open a web browser, click buttons, fill forms, and verify that everything works correctly
- **Generate reports** showing what passed and what failed

**What is an API?** An API is like a waiter in a restaurant - you give it a request (order), and it brings you back a response (your food). APIs allow different software systems to talk to each other.

**What is UI Testing?** UI testing means testing the website that users see and interact with - clicking buttons, filling forms, navigating pages, etc. It's like having a robot that uses the website just like a human would.

## 🎯 What Can This Framework Test?

This framework is designed to test both APIs and web applications. You can use it to test:

### API Testing
Test backend services (the "behind the scenes" part):
- **REST APIs** - Any RESTful API endpoints
- **Authentication** - Login, token management, and authorization
- **CRUD Operations** - Create, Read, Update, Delete operations
- **Data Validation** - Verify API responses and data integrity
- **Error Handling** - Test error scenarios and status codes
- **Integration Testing** - Test how different APIs work together

### UI Testing
Test the website that users interact with (the "what you see" part):
- **User Interface** - Buttons, forms, navigation, and page elements
- **User Workflows** - Complete end-to-end user journeys
- **Form Validation** - Input fields, dropdowns, and form submissions
- **Navigation** - Page transitions and routing
- **Visual Elements** - Text, images, and layout verification

## 🛠️ Tools Used (Simple Explanation)

This project uses several tools that work together:

1. **Java** - The programming language we use to write tests
2. **Maven** - A tool that helps download libraries and run tests (like a package manager)
3. **TestNG** - A testing framework that organizes and runs our tests
4. **RestAssured** - A library that makes it easy to send HTTP requests and check API responses (for API testing)
5. **Selenium WebDriver** - A tool that controls a web browser to test websites (for UI testing)
6. **Allure** - A tool that creates beautiful, easy-to-read test reports
7. **YAML** - A format for storing test data in an easy-to-read way (for data-driven testing)

## 📋 Prerequisites - What You Need Before Starting

Before you can use this project, you need to install these on your computer:

### 1. Java 17 or Higher
**What it is:** Java is the programming language used to write the tests.

**How to check if you have it:**
```bash
java -version
```

**If you don't have it:** Download from [Oracle](https://www.oracle.com/java/technologies/downloads/) or [OpenJDK](https://adoptium.net/)

### 2. Maven 3.6 or Higher
**What it is:** Maven helps manage dependencies (libraries) and run tests.

**How to check if you have it:**
```bash
mvn -version
```

**If you don't have it:** Download from [Apache Maven](https://maven.apache.org/download.cgi)

### 3. Chrome Browser (For UI Tests)
**What it is:** UI tests need a web browser to run. This framework uses Chrome.

**How to check if you have it:** Just open Chrome on your computer. If you have it, you're good!

**If you don't have it:** Download from [Google Chrome](https://www.google.com/chrome/)

**Note:** You also need ChromeDriver, but Maven will handle this automatically when you run UI tests.

### 4. Git (Optional but Recommended)
**What it is:** Git helps you download and manage the project code.

**How to check if you have it:**
```bash
git --version
```

**If you don't have it:** Download from [Git](https://git-scm.com/downloads)

## 🚀 Getting Started - Step by Step

### Step 1: Download the Project

If you have Git installed:
```bash
git clone <your-repository-url>
cd jarvis
```

If you don't have Git, download the project as a ZIP file and extract it.

### Step 2: Open the Project

Open the project folder in your favorite code editor (like IntelliJ IDEA, Eclipse, or VS Code).

### Step 3: Configure the Environment

The project needs to know which environment (server) to test. Open the file:
```
src/test/resources/config.properties
```

You'll see different environments like:
- `stage.base.url` - Staging environment UI URL
- `stage.base.api` - Staging environment API URL
- `prod.base.url` - Production environment UI URL
- `prod.base.api` - Production environment API URL

The `default.env` setting at the bottom tells the framework which environment to use by default. You can change it to `stage`, `prod`, etc.

**Important:** Make sure the URLs and credentials in this file are correct for your testing environment.

### Step 4: Install Dependencies

Maven needs to download all the required libraries. Open a terminal in the project folder and run:

```bash
mvn clean install
```

**What this does:**
- `clean` - Removes old compiled files
- `install` - Downloads all required libraries and compiles the project

**First time?** This might take a few minutes as Maven downloads everything. Don't worry - it's normal!

## 🧪 Running Tests - How to Execute Tests

### Run All Tests

To run all tests in the project:

```bash
mvn clean test
```

**What happens:**
1. Maven compiles your code
2. TestNG runs all test classes
3. Tests execute and send requests to APIs
4. Results are saved

### Run a Specific Test Class

**For API Tests:**
If you only want to test one API (for example, just the Blob API):

```bash
mvn clean test -Dtest=BlobAPITest
```

Replace `BlobAPITest` with any API test class name you create. For example:
- `MyAPITest` - Your custom API test
- `HealthTest` - Health check tests
- Or any other test class you create in `src/test/java/api/tests/`

**For UI Tests:**
To run UI tests, create your test class first, then run:

```bash
mvn clean test -Dtest=MyUITest
```

Replace `MyUITest` with your actual UI test class name. Or run all UI tests using the UI test suite:

```bash
mvn clean test -DsuiteXmlFile=testng-ui.xml
```

### Run Tests Using TestNG XML

You can also control which tests run using a TestNG XML file:

**For API tests:**
```bash
mvn clean test -DsuiteXmlFile=testng.xml
```

**For UI tests:**
```bash
mvn clean test -DsuiteXmlFile=testng-ui.xml
```

## 📊 Understanding Test Reports

After running tests, you'll want to see the results. This project uses **Allure** to create beautiful reports.

### Generate the Report

After running tests, generate the report:

```bash
mvn allure:report
```

This creates the report files in the `target/allure-report` folder.

### View the Report in Your Browser

To see the report:

```bash
mvn allure:serve
```

This will:
1. Generate the report
2. Open it in your default web browser
3. Show you a beautiful dashboard with:
   - ✅ **Passed tests** (green)
   - ❌ **Failed tests** (red)
   - ⏸️ **Skipped tests** (yellow)
   - 📊 **Statistics** (how many passed/failed)
   - 📝 **Detailed logs** for each test
   - ⏱️ **Execution time** for each test

**Tip:** Keep the terminal open while viewing the report. Closing it will close the report server.

## 📁 Project Structure - Where Everything Lives

Understanding the folder structure helps you navigate the project:

```
jarvis/
├── src/
│   ├── main/java/                    # Main code (not tests)
│   │   ├── ApiRequests/              # Classes that make API calls (add your request classes here)
│   │   ├── APIComponents/            # Reusable API test components (add your components here)
│   │   ├── UIComponents/             # Reusable UI test components (add your components here)
│   │   ├── pages/                    # Page Object Model classes
│   │   │   └── BasePage.java         # Base class for page objects
│   │   ├── annotations/              # Custom annotations
│   │   │   └── YamlTestCase.java     # Annotation for YAML test data
│   │   ├── base/
│   │   │   └── BaseApiTest.java      # Base class - all API tests extend this
│   │   ├── config/
│   │   │   └── ConfigManager.java    # Reads configuration files
│   │   └── utils/
│   │       ├── APIUtils.java         # Helper methods for API calls
│   │       ├── SeleniumUtils.java   # Helper methods for UI interactions
│   │       ├── AllureUtils.java      # Helper methods for reports
│   │       ├── YamlDataProvider.java # Provides test data from YAML files
│   │       ├── YamlDataLoader.java  # Loads YAML test data files
│   │       ├── YamlHelper.java      # Helper methods for YAML operations
│   │       └── YamlTestInterceptor.java # Intercepts tests with YAML annotations
│   ├── resources/
│   │   └── testData/                 # YAML test data files (add your YAML files here)
│   └── test/
│       ├── java/
│       │   ├── api/
│       │   │   ├── tests/            # ⭐ API TEST FILES GO HERE (add your test classes)
│       │   │   └── utils/
│       │   │       └── EnvironmentReader.java  # Environment utility
│       │   └── UITests/              # ⭐ UI TEST FILES GO HERE
│       │       └── BaseTest.java     # Base class for UI tests
│       └── resources/
│           ├── config.properties     # Environment configuration
│           └── allure.properties     # Allure report settings
├── pom.xml                           # Maven configuration (lists all libraries)
├── testng.xml                        # TestNG configuration for API tests
├── testng-ui.xml                     # TestNG configuration for UI tests
└── README.md                         # This file!
```

## ✍️ Understanding Tests - Example Walkthroughs

Let's look at examples of both API and UI tests to understand how they work.

### Example 1: API Test

Here's what an API test looks like:

```java
public class MyAPITest extends BaseApiTest {
    
    @Test(groups = "api", description = "Test API endpoint")
    public void testApiEndpoint() {
        // Use APIUtils to make API calls
        Response response = APIUtils.get("/api/endpoint", bearerToken);
        Assert.assertEquals(response.getStatusCode(), 200, 
            "API should return 200 status code");
    }
}
```

**Breaking it down:**

1. **`extends BaseApiTest`** - This means our test class inherits from the base class, which gives us access to things like `bearerToken` and `baseUrl`.

2. **`@Test`** - This marks a method as a test. TestNG will run all methods marked with `@Test`.

3. **`APIUtils.get(...)`** - This sends a GET request to the API. It returns a `Response` object.

4. **`Assert.assertEquals(...)`** - This checks if the response status code is 200 (which means "OK" or "success"). If it's not 200, the test fails.

**What happens when you run this test:**
1. The `testApiEndpoint()` method runs
2. It sends a request to the API (behind the scenes, no browser)
3. It checks if the response code is 200
4. If yes → Test passes ✅
5. If no → Test fails ❌

### Example 2: UI Test

Here's what a UI test looks like:

```java
public class MyUITest extends BaseTest {
    
    @Test
    public void testWebPage() {
        // Navigate to a page
        driver.get("https://example.com");
        
        // Use SeleniumUtils helper methods
        utils.click(By.id("button-id"));
        utils.sendKeys(By.id("input-id"), "test data");
        
        // Verify something
        String text = utils.getText(By.className("result"));
        Assert.assertEquals(text, "Expected Text", "Text should match");
    }
}
```

**Breaking it down:**

1. **`extends BaseTest`** - This gives us access to `driver` (the browser controller) and `utils` (helper methods from SeleniumUtils).

2. **`driver.get(...)`** - This opens a browser and navigates to the specified URL.

3. **`utils.click(...)`** - This clicks on an element found by a locator (like ID, class, XPath).

4. **`utils.sendKeys(...)`** - This types text into an input field.

5. **`Assert.assertEquals(...)`** - This checks if something matches an expected value.

**What happens when you run this test:**
1. A Chrome browser opens automatically
2. The test navigates to the website
3. It interacts with elements (clicks, types, etc.)
4. It verifies the results
5. The browser closes
6. If all steps pass → Test passes ✅
7. If any step fails → Test fails ❌

**Key Difference:**
- **API tests** run in the background (no browser, faster)
- **UI tests** open a real browser and interact with the website (slower, but tests what users actually see)

### Example 3: Data-Driven Test with YAML

This framework supports **data-driven testing** using YAML files. This means you can write one test and run it with different data from a YAML file:

```java
@Test(groups = {"regression", "e2e"}, 
      dataProvider = "yamlData", 
      dataProviderClass = YamlDataProvider.class)
@YamlTestCase("invoice.yaml")
public void testCreateEventThenInvoice(Map<String, Object> testData) {
    // Use testData from YAML file
    String username = testData.get("user").toString();
    String password = testData.get("pass").toString();
    // ... rest of test
}
```

**What is YAML?** YAML is a human-readable format for storing data. It's easier to read and write than JSON or XML.

**YAML File Example** (`src/main/resources/testData/invoice.yaml`):
```yaml
testCases:
  - name: "Create event and invoice - Test Case 1"
    data:
      tenant: "my-tenant"
      site: "my-site"
      user: "user@example.com"
      pass: "password123"
      location: "Conference Room A"
      locationDescription: "Main conference room"
      eventTitle: "Team Meeting"
      eventDate:
        day: "15"
        month: "March"
        startTime: "10:00 AM"
      invoiceAmount: "500.00"
      customerName: "John Doe"
      invoiceDescription: "Event invoice"
  
  - name: "Create event and invoice - Test Case 2"
    data:
      tenant: "my-tenant"
      site: "my-site"
      user: "user2@example.com"
      pass: "password456"
      # ... different data for second test case
```

**Benefits of YAML Test Data:**
- ✅ **Easy to read** - Non-technical team members can understand and modify test data
- ✅ **Reusable** - One test can run with multiple sets of data
- ✅ **Maintainable** - Change test data without changing code
- ✅ **Organized** - Keep all test data in one place

**How it works:**
1. Create a YAML file in `src/main/resources/testData/`
2. Add the `@YamlTestCase` annotation to your test method
3. Use `dataProvider = "yamlData"` in your `@Test` annotation
4. The test will run once for each test case in the YAML file

## 🎓 Common Tasks for Beginners

### Task 1: Run Your First API Test

1. Open a terminal in the project folder
2. Run: `mvn clean test -Dtest=HealthTest`
3. Wait for it to finish (no browser will open - it's an API test!)
4. Run: `mvn allure:serve` to see the results

### Task 2: Run Your First UI Test

1. Make sure Chrome is installed on your computer
2. Create a UI test class in `src/test/java/UITests/` (extend `BaseTest`)
3. Open a terminal in the project folder
4. Run: `mvn clean test -Dtest=YourUITestClassName`
5. Watch as Chrome opens automatically and the test runs!
6. Run: `mvn allure:serve` to see the results

**Note:** UI tests take longer because they actually open a browser and interact with the website.

### Task 3: Check What Tests Are Available

**For API tests:**
Look in the folder: `src/test/java/api/tests/`

Create your test files here. Each test class should extend `BaseApiTest`.

**For UI tests:**
Look in the folder: `src/test/java/UITests/`

Create your test files here. Each test class should extend `BaseTest`.

### Task 4: Run All API Tests

```bash
mvn clean test -DsuiteXmlFile=testng.xml
```

This runs all API tests.

### Task 5: Run All UI Tests

```bash
mvn clean test -DsuiteXmlFile=testng-ui.xml
```

This runs all UI tests (Chrome will open for each test).

### Task 6: View Test Results

After any test run:
```bash
mvn allure:serve
```

This opens a report showing:
- Which tests passed
- Which tests failed
- How long each test took
- Detailed error messages for failures
- Screenshots (for UI tests that fail)

## 🔧 Troubleshooting - Common Problems

### Problem: "Java not found" or "Maven not found"

**Solution:** Make sure Java and Maven are installed and added to your system PATH. Check with `java -version` and `mvn -version`.

### Problem: Tests fail with "Connection refused" or "Cannot connect"

**Solution:** 
1. Check your internet connection
2. Verify the URLs in `src/test/resources/config.properties` are correct
3. Make sure the API server is running and accessible (for API tests)
4. Make sure the website is accessible in your browser (for UI tests)

### Problem: UI tests fail with "ChromeDriver not found" or browser doesn't open

**Solution:**
1. Make sure Chrome browser is installed
2. Maven should download ChromeDriver automatically, but if it doesn't:
   - Check your internet connection
   - Try running `mvn clean install` again
3. If ChromeDriver version mismatch: Update Chrome browser to the latest version

### Problem: "Authentication failed" errors

**Solution:** 
1. Check the credentials in `src/test/resources/config.properties`
2. Make sure the email and password are correct for the environment you're testing

### Problem: Maven downloads are slow

**Solution:** This is normal the first time. Maven needs to download all libraries. Subsequent runs will be faster as it uses cached files.

### Problem: Report doesn't open

**Solution:** 
1. Make sure you ran `mvn allure:report` first
2. Try `mvn allure:serve` again
3. Check if port 4040 is already in use (close other instances)

## 📝 Working with Test Data (YAML Files)

This framework uses **YAML files** to store test data, making it easy to run the same test with different data.

### Creating a YAML Test Data File

1. **Create a YAML file** in `src/main/resources/testData/`
   - Example: `src/main/resources/testData/invoice.yaml`

2. **Structure your YAML file** like this:
```yaml
testCases:
  - name: "Test Case 1"
    data:
      user: "user@example.com"
      pass: "password123"
      location: "Room A"
      # Add more test data fields here
  
  - name: "Test Case 2"
    data:
      user: "user2@example.com"
      pass: "password456"
      location: "Room B"
      # Different data for second test case
```

3. **Use it in your test:**
```java
@Test(dataProvider = "yamlData", dataProviderClass = YamlDataProvider.class)
@YamlTestCase("invoice.yaml")
public void myTest(Map<String, Object> testData) {
    String user = testData.get("user").toString();
    // Use the data from YAML
}
```

### Benefits of YAML Test Data

- **Easy to modify** - Change test data without touching code
- **Multiple test cases** - One file can contain many test scenarios
- **Readable** - Non-programmers can understand and update test data
- **Reusable** - Same test runs with different data automatically

### YAML File Location

- **Main location:** `src/main/resources/testData/`
- **Alternative:** `src/test/resources/testdata/` (if using the older path)

## 🎯 Next Steps - Learning More

Now that you can run tests, here are some things to try:

1. **Explore test files** - Open different API and UI test files and see how they're written
2. **Modify a test** - Try changing an assertion to see what happens
3. **Add a simple test** - Create a new test method in an existing test class
4. **Read the code** - Look at `APIUtils.java` for API helper methods and `SeleniumUtils.java` for UI helper methods
5. **Create components** - Build reusable components in `APIComponents/` and `UIComponents/` folders for your tests
6. **Watch a UI test run** - Run a UI test and watch the browser to see what the test is doing
7. **Compare API vs UI** - Run the same feature test via API and UI to see the difference
8. **Try YAML test data** - Create a YAML file and use it in a test to see data-driven testing in action

## 📚 Key Concepts to Learn

As you work with this framework, you'll learn:

### API Testing Concepts:
- **HTTP Methods:** GET (read), POST (create), PUT (update), DELETE (remove)
- **Status Codes:** 200 (success), 404 (not found), 500 (server error), etc.
- **JSON:** The format APIs use to send and receive data
- **Authentication:** How to log in and use tokens to access protected APIs
- **Request/Response:** How APIs send and receive data

### UI Testing Concepts:
- **WebDriver:** The tool that controls the browser
- **Locators:** How to find elements on a webpage (by ID, class, XPath, etc.)
- **Page Object Model:** A pattern for organizing UI test code
- **Components:** Reusable pieces of UI functionality (like login, forms, etc.)
- **Waits:** How to wait for elements to appear before interacting with them

### General Concepts:
- **Assertions:** How to check if test results are correct
- **Test Data:** How to provide different data to tests (including YAML files)
- **Data-Driven Testing:** Running the same test with different data sets
- **Test Reports:** How to read and understand test results
- **Annotations:** Special markers that tell the framework how to run tests

## 🤝 Getting Help

If you get stuck:

1. **Check the error message** - It usually tells you what's wrong
2. **Look at the Allure report** - It shows detailed error information
3. **Check the console output** - It shows what the test was doing when it failed
4. **Ask your team** - Someone else might have seen the same issue

## 🎉 Congratulations!

You now know how to:
- ✅ Set up the project
- ✅ Run tests (both API and UI)
- ✅ View test reports
- ✅ Understand basic test structure
- ✅ Use YAML files for test data
- ✅ Run data-driven tests

Happy testing! 🚀

---

**Remember:** Test automation is a skill that improves with practice. Don't be afraid to experiment and make mistakes - that's how you learn!
