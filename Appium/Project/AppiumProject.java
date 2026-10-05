package Projects;

import java.net.URI;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class AppiumProject {

    AndroidDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws Exception {

        // Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();

        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");

        // ToDo App Package
        options.setAppPackage(
                "com.xmission.trevin.android.todo"
        );

        // ToDo App Activity
        options.setAppActivity(
                "com.xmission.trevin.android.todo.ui.ToDoListActivity"
        );

        // Keep existing application data
        options.setNoReset(true);

        // Appium Server URL
        URL serverURL =
                new URI("http://127.0.0.1:4723").toURL();

        // Initialize Driver
        driver = new AndroidDriver(
                serverURL,
                options
        );

        // Explicit Wait
        wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(20)
        );
    }


    // =========================================================
    // ACTIVITY 1
    // Verify all three tasks were added
    // =========================================================

    @Test(priority = 1, enabled = false)
    public void verifyAllThreeTasks() {

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        AppiumBy.androidUIAutomator(
                                "new UiSelector().textContains(\"Complete Activity\")"
                        )
                )
        );

        // Activity 1
        Assert.assertTrue(
                driver.findElement(
                        AppiumBy.androidUIAutomator(
                                "new UiSelector().textContains(\"Complete Activity 1\")"
                        )
                ).isDisplayed(),
                "Activity 1 was not found"
        );

        System.out.println(
                "Activity 1 found successfully"
        );


        // Activity 2
        Assert.assertTrue(
                driver.findElement(
                        AppiumBy.androidUIAutomator(
                                "new UiSelector().textContains(\"Complete Activity 2\")"
                        )
                ).isDisplayed(),
                "Activity 2 was not found"
        );

        System.out.println(
                "Activity 2 found successfully"
        );


        // Activity 3
        Assert.assertTrue(
                driver.findElement(
                        AppiumBy.androidUIAutomator(
                                "new UiSelector().textContains(\"Complete Activity 3\")"
                        )
                ).isDisplayed(),
                "Activity 3 was not found"
        );

        System.out.println(
                "Activity 3 found successfully"
        );

        System.out.println(
                "All three tasks have been added successfully!"
        );
    }


    // =========================================================
    // ACTIVITY 2
    // Verify Activity 2 is assigned to Activities category
    // =========================================================

    @Test(priority = 2, enabled = false)
    public void verifyActivity2Category() {

        // Click All category filter
        driver.findElement(
                AppiumBy.androidUIAutomator(
                        "new UiSelector().text(\"All\")"
                )
        ).click();


        // Select Activities
        wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.androidUIAutomator(
                                "new UiSelector().text(\"Activities\")"
                        )
                )
        ).click();


        // Verify Activity 2 is visible
        Assert.assertTrue(
                driver.findElement(
                        AppiumBy.androidUIAutomator(
                                "new UiSelector().textContains(\"Complete Activity 2\")"
                        )
                ).isDisplayed(),
                "Activity 2 was not found under Activities category"
        );


        // Activity 1 should not appear
        Assert.assertEquals(
                driver.findElements(
                        AppiumBy.androidUIAutomator(
                                "new UiSelector().textContains(\"Complete Activity 1\")"
                        )
                ).size(),
                0,
                "Activity 1 should not appear under Activities category"
        );


        // Activity 3 should not appear
        Assert.assertEquals(
                driver.findElements(
                        AppiumBy.androidUIAutomator(
                                "new UiSelector().textContains(\"Complete Activity 3\")"
                        )
                ).size(),
                0,
                "Activity 3 should not appear under Activities category"
        );


        System.out.println(
                "Activity 2 is correctly assigned to the Activities category!"
        );
    }


    // =========================================================
    // ACTIVITY 3
    // Verify completed tasks are hidden
    // and only Activity 3 remains
    // =========================================================

    @Test(priority = 3)
    public void verifyCompletedTasks() {

        /*
         * Activity 1 and Activity 2 have already been marked
         * complete manually.
         *
         * Completed tasks have also already been hidden.
         *
         * Therefore only Activity 3 should be visible.
         */

        // Wait for Activity 3
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        AppiumBy.androidUIAutomator(
                                "new UiSelector().textContains(\"Complete Activity 3\")"
                        )
                )
        );


        // Verify Activity 3 is visible
        Assert.assertTrue(
                driver.findElement(
                        AppiumBy.androidUIAutomator(
                                "new UiSelector().textContains(\"Complete Activity 3\")"
                        )
                ).isDisplayed(),
                "Activity 3 should be visible"
        );


        // Verify Activity 1 is hidden
        Assert.assertEquals(
                driver.findElements(
                        AppiumBy.androidUIAutomator(
                                "new UiSelector().textContains(\"Complete Activity 1\")"
                        )
                ).size(),
                0,
                "Completed Activity 1 should not be visible"
        );


        // Verify Activity 2 is hidden
        Assert.assertEquals(
                driver.findElements(
                        AppiumBy.androidUIAutomator(
                                "new UiSelector().textContains(\"Complete Activity 2\")"
                        )
                ).size(),
                0,
                "Completed Activity 2 should not be visible"
        );


        System.out.println(
                "Activity 1 and Activity 2 are completed and hidden."
        );

        System.out.println(
                "Only Activity 3 is visible."
        );

        System.out.println(
                "Activity 3 completed successfully!"
        );
    }


    // =========================================================
    // TEARDOWN
    // =========================================================

    @AfterClass(alwaysRun = true)
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}