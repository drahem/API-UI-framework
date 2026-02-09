# Jarvis - API and UI Test Automation Framework

Welcome! This is a **test automation framework** for testing both **APIs** (Application Programming Interfaces) and **UI** (User Interface - the website you see in your browser). If you're new to test automation, don't worry - this guide will walk you through everything step by step.

## 📖 What is This Project?

This project helps you **automatically test both APIs and web applications** instead of testing them manually. Think of it like a robot that can:
- **For APIs:** Send requests to APIs (like asking a server for information) and check if the responses are correct
- **For UI:** Open a web browser, click buttons, fill forms, and verify that everything works correctly
- **Generate reports** showing what passed and what failed

**What is an API?** An API is like a waiter in a restaurant - you give it a request (order), and it brings you back a response (your food). APIs allow different software systems to talk to each other.

**What is UI Testing?** UI testing means testing the website that users see and interact with - clicking buttons, filling forms, navigating pages, etc. It's like having a robot that uses the website just like a human would.

## 🎯 What Does This Framework Test?

This framework tests an event management system in two ways:

### API Testing
Tests the backend services (the "behind the scenes" part):
- **Authentication** - Logging in and getting access tokens
- **Blobs** - File storage and retrieval
- **Events** - Creating, reading, updating, and deleting events via API
- **Locations** - Managing location information via API
- **Users** - User management operations via API
- **Tasks** - Task creation and management via API
- And many more...

### UI Testing
Tests the website that users interact with (the "what you see" part):
- **Login** - Testing the login page and authentication flow
- **Event Creation** - Creating events through the website interface
- **Location Management** - Adding and managing locations through the UI
- **Invoice Generation** - Creating invoices for events
- **End-to-End Flows** - Complete user workflows (e.g., login → create location → create event → generate invoice)

## 🛠️ Tools Used (Simple Explanation)

This project uses several tools that work together:

1. **Java** - The programming language we use to write tests
2. **Maven** - A tool that helps download libraries and run tests (like a package manager)
3. **TestNG** - A testing framework that organizes and runs our tests
4. **RestAssured** - A library that makes it easy to send HTTP requests and check API responses (for API testing)
5. **Selenium WebDriver** - A tool that controls a web browser to test websites (for UI testing)
6. **Allure** - A tool that creates beautiful, easy-to-read test reports

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
- `blue.base.api` - Blue environment URL
- `yellow.base.api` - Yellow environment URL
- `stage.base.api` - Staging environment URL
- `prod.base.api` - Production environment URL

The `default.env` setting at the bottom tells the framework which environment to use by default. You can change it to `blue`, `yellow`, `stage`, `prod`, etc.

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

Replace `BlobAPITest` with any API test class name:
- `EventAPITest` - Tests for Events API
- `LocationAPITest` - Tests for Locations API
- `UserAPITest` - Tests for Users API
- `LoginApiTest` - Tests for Login API
- etc.

**For UI Tests:**
To run UI tests:

```bash
mvn clean test -Dtest=TestCreateEventThenInvoice
```

Or run all UI tests using the UI test suite:

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
│   │   ├── ApiRequests/              # Classes that make API calls
│   │   │   ├── blob/                 # Blob API request class
│   │   │   ├── event/                # Event API request class
│   │   │   └── ...                   # Other API request classes
│   │   ├── APIComponents/            # Reusable API test components
│   │   │   ├── blob/                 # Blob component (helper methods)
│   │   │   └── ...                   # Other API components
│   │   ├── UIComponents/             # Reusable UI test components
│   │   │   ├── events/               # Event UI component
│   │   │   ├── invoice/              # Invoice UI component
│   │   │   ├── locations/            # Location UI component
│   │   │   └── login/                # Login UI component
│   │   ├── pages/                    # Page Object Model classes
│   │   │   └── BasePage.java         # Base class for page objects
│   │   ├── base/
│   │   │   └── BaseApiTest.java      # Base class - all API tests extend this
│   │   ├── config/
│   │   │   └── ConfigManager.java    # Reads configuration files
│   │   └── utils/
│   │       ├── APIUtils.java         # Helper methods for API calls
│   │       ├── SeleniumUtils.java    # Helper methods for UI interactions
│   │       └── AllureUtils.java      # Helper methods for reports
│   └── test/
│       ├── java/
│       │   ├── api/tests/            # ⭐ API TEST FILES GO HERE
│       │   │   ├── BlobAPITest.java  # Tests for Blob API
│       │   │   ├── EventAPITest.java # Tests for Event API
│       │   │   └── ...               # Other API test files
│       │   └── UITests/              # ⭐ UI TEST FILES GO HERE
│       │       ├── BaseTest.java     # Base class for UI tests
│       │       └── TestCreateEventThenInvoice.java  # UI test example
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
public class BlobAPITest extends BaseApiTest {
    
    private BlobComponent blobComponent;
    
    @BeforeClass
    public void setup() {
        blobComponent = new BlobComponent();
    }
    
    @Test(groups = "api", description = "Search for blobs")
    public void testSearchBlobs() {
        Response response = blobComponent.searchBlobs(bearerToken);
        Assert.assertEquals(response.getStatusCode(), 200, 
            "Search blobs should return 200 status code");
    }
}
```

**Breaking it down:**

1. **`extends BaseApiTest`** - This means our test class inherits from the base class, which gives us access to things like `bearerToken` and `baseUrl`.

2. **`@BeforeClass`** - This method runs ONCE before all tests in this class. It sets up things we need (like creating the `blobComponent`).

3. **`@Test`** - This marks a method as a test. TestNG will run all methods marked with `@Test`.

4. **`blobComponent.searchBlobs(bearerToken)`** - This sends a request to the API to search for blobs. It returns a `Response` object.

5. **`Assert.assertEquals(...)`** - This checks if the response status code is 200 (which means "OK" or "success"). If it's not 200, the test fails.

**What happens when you run this test:**
1. The `setup()` method runs first
2. The `testSearchBlobs()` method runs
3. It sends a request to the Blob API (behind the scenes, no browser)
4. It checks if the response code is 200
5. If yes → Test passes ✅
6. If no → Test fails ❌

### Example 2: UI Test

Here's what a UI test looks like:

```java
public class TestCreateEventThenInvoice extends BaseTest {
    
    @Test
    public void testCreateEventThenInvoice() {
        // Step 1: Login
        LoginComponent loginComponent = new LoginComponent(driver);
        loginComponent.navigateToLogin("tenant", "site");
        loginComponent.doLogin("user@example.com", "password");
        
        // Step 2: Create location
        LocationComponent locationComponent = new LocationComponent(driver);
        locationComponent.createLocation("New Location", "Description");
        
        // Step 3: Create event
        EventsComponent eventsComponent = new EventsComponent(driver);
        eventsComponent.createEvent("Event Title", "15", "March", "New Location");
        
        // Step 4: Verify everything worked
        Assert.assertTrue(eventsComponent.verifyEventCreated(), 
            "Event should be created successfully");
    }
}
```

**Breaking it down:**

1. **`extends BaseTest`** - This gives us access to `driver` (the browser controller) and `utils` (helper methods).

2. **`LoginComponent`** - This is a reusable component that knows how to log in. It uses the `driver` to interact with the website.

3. **`loginComponent.doLogin(...)`** - This actually opens a browser, navigates to the login page, fills in the username and password, and clicks the login button.

4. **`LocationComponent`** - Another component that knows how to create locations on the website.

5. **`Assert.assertTrue(...)`** - This checks if something is true. In this case, it checks if the event was created successfully.

**What happens when you run this test:**
1. A Chrome browser opens automatically
2. The test navigates to the login page
3. It fills in credentials and logs in
4. It creates a location
5. It creates an event
6. It verifies everything worked
7. The browser closes
8. If all steps pass → Test passes ✅
9. If any step fails → Test fails ❌

**Key Difference:**
- **API tests** run in the background (no browser, faster)
- **UI tests** open a real browser and interact with the website (slower, but tests what users actually see)

## 🎓 Common Tasks for Beginners

### Task 1: Run Your First API Test

1. Open a terminal in the project folder
2. Run: `mvn clean test -Dtest=HealthTest`
3. Wait for it to finish (no browser will open - it's an API test!)
4. Run: `mvn allure:serve` to see the results

### Task 2: Run Your First UI Test

1. Make sure Chrome is installed on your computer
2. Open a terminal in the project folder
3. Run: `mvn clean test -Dtest=TestCreateEventThenInvoice`
4. Watch as Chrome opens automatically and the test runs!
5. Run: `mvn allure:serve` to see the results

**Note:** UI tests take longer because they actually open a browser and interact with the website.

### Task 3: Check What Tests Are Available

**For API tests:**
Look in the folder: `src/test/java/api/tests/`

You'll see files like:
- `BlobAPITest.java`
- `EventAPITest.java`
- `LocationAPITest.java`
- etc.

**For UI tests:**
Look in the folder: `src/test/java/UITests/`

You'll see files like:
- `TestCreateEventThenInvoice.java`

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

## 🎯 Next Steps - Learning More

Now that you can run tests, here are some things to try:

1. **Explore test files** - Open different API and UI test files and see how they're written
2. **Modify a test** - Try changing an assertion to see what happens
3. **Add a simple test** - Create a new test method in an existing test class
4. **Read the code** - Look at `APIUtils.java` for API helper methods and `SeleniumUtils.java` for UI helper methods
5. **Check components** - See how `BlobComponent.java` makes API calls and how `LoginComponent.java` interacts with the UI
6. **Watch a UI test run** - Run a UI test and watch the browser to see what the test is doing
7. **Compare API vs UI** - Run the same feature test via API and UI to see the difference

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
- **Test Data:** How to provide different data to tests
- **Test Reports:** How to read and understand test results

## 🤝 Getting Help

If you get stuck:

1. **Check the error message** - It usually tells you what's wrong
2. **Look at the Allure report** - It shows detailed error information
3. **Check the console output** - It shows what the test was doing when it failed
4. **Ask your team** - Someone else might have seen the same issue

## 🎉 Congratulations!

You now know how to:
- ✅ Set up the project
- ✅ Run tests
- ✅ View test reports
- ✅ Understand basic test structure

Happy testing! 🚀

---

**Remember:** Test automation is a skill that improves with practice. Don't be afraid to experiment and make mistakes - that's how you learn!
