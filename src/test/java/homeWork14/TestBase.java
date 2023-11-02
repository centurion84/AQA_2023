package homeWork14;

import org.testng.annotations.*;

public class TestBase {

    @BeforeTest
    public void beforeTest() {
        System.out.println("Before Test - Runs once before all tests in the suite");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("After Test - Runs once after all tests in the suite");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("Before Class - Runs once before all tests in the current class");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("After Class - Runs once after all tests in the current class");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Before Method - Runs before each test method");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("After Method - Runs after each test method");
    }
}

