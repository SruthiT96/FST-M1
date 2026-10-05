package Projects;

import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class ChromeProject {

    AndroidDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws Exception {

        // Desired Capabilities
        UiAutomator2Options options =
                new UiAutomator2Options();

        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");

        // Chrome application
        options.setAppPackage("com.android.chrome");
        options.setAppActivity(
                "com.google.android.apps.chrome.Main"
        );

        options.setNoReset(true);

        // Appium Server URL
        URL serverURL =
                new URI("http://127.0.0.1:4723").toURL();

        // Initialize Android Driver
        driver =
                new AndroidDriver(
                        serverURL,
                        options
                );

        // Explicit Wait
        wait =
                new WebDriverWait(
                        driver,
                        Duration.ofSeconds(20)
                );

        // Open To-Do List page
        driver.get(
                "https://training-support.net/webelements/todo-list"
        );
    }


    @Test
    public void todoListTest() {

        // =====================================================
        // WAIT FOR TODO INPUT FIELD
        // =====================================================

        WebElement input =
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(
                                AppiumBy.className(
                                        "android.widget.EditText"
                                )
                        )
                );

        System.out.println(
                "To-Do input field found successfully"
        );


        // =====================================================
        // ADD TASK 1
        // =====================================================

        input.sendKeys(
                "Add tasks to list"
        );

        driver.findElement(
                AppiumBy.androidUIAutomator(
                        "new UiSelector()"
                        + ".className(\"android.widget.Button\")"
                        + ".resourceId(\"todo-add\")"
                )
        ).click();

        System.out.println(
                "Task 1 added: Add tasks to list"
        );


        // =====================================================
        // ADD TASK 2
        // =====================================================

        input =
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(
                                AppiumBy.className(
                                        "android.widget.EditText"
                                )
                        )
                );

        input.sendKeys(
                "Get number of tasks"
        );

        driver.findElement(
                AppiumBy.androidUIAutomator(
                        "new UiSelector()"
                        + ".className(\"android.widget.Button\")"
                        + ".resourceId(\"todo-add\")"
                )
        ).click();

        System.out.println(
                "Task 2 added: Get number of tasks"
        );


        // =====================================================
        // ADD TASK 3
        // =====================================================

        input =
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(
                                AppiumBy.className(
                                        "android.widget.EditText"
                                )
                        )
                );

        input.sendKeys(
                "Clear the list"
        );

        driver.findElement(
                AppiumBy.androidUIAutomator(
                        "new UiSelector()"
                        + ".className(\"android.widget.Button\")"
                        + ".resourceId(\"todo-add\")"
                )
        ).click();

        System.out.println(
                "Task 3 added: Clear the list"
        );


        // =====================================================
        // VERIFY THE THREE NEW TASKS
        // =====================================================

        Assert.assertTrue(
                driver.findElement(
                        AppiumBy.androidUIAutomator(
                                "new UiSelector()"
                                + ".text(\"Add tasks to list\")"
                        )
                ).isDisplayed(),
                "Add tasks to list was not found"
        );


        Assert.assertTrue(
                driver.findElement(
                        AppiumBy.androidUIAutomator(
                                "new UiSelector()"
                                + ".text(\"Get number of tasks\")"
                        )
                ).isDisplayed(),
                "Get number of tasks was not found"
        );


        Assert.assertTrue(
                driver.findElement(
                        AppiumBy.androidUIAutomator(
                                "new UiSelector()"
                                + ".text(\"Clear the list\")"
                        )
                ).isDisplayed(),
                "Clear the list was not found"
        );

        System.out.println(
                "All three newly added tasks are visible"
        );


        // =====================================================
        // COUNT TASKS
        // =====================================================

        List<WebElement> checkboxes =
                driver.findElements(
                        AppiumBy.className(
                                "android.widget.CheckBox"
                        )
                );

        System.out.println(
                "Total number of tasks: "
                + checkboxes.size()
        );


        // Buy Milk + Buy Cat + 3 new tasks = 5
        Assert.assertEquals(
                checkboxes.size(),
                5,
                "Expected 5 tasks but found "
                + checkboxes.size()
        );

        System.out.println(
                "Task count verified successfully: 5"
        );


        // =====================================================
        // STRIKE OUT TASK 1
        // =====================================================

        driver.findElement(
                AppiumBy.androidUIAutomator(
                        "new UiSelector()"
                        + ".text(\"Add tasks to list\")"
                )
        ).click();

        System.out.println(
                "Clicked: Add tasks to list"
        );


        // =====================================================
        // STRIKE OUT TASK 2
        // =====================================================

        driver.findElement(
                AppiumBy.androidUIAutomator(
                        "new UiSelector()"
                        + ".text(\"Get number of tasks\")"
                )
        ).click();

        System.out.println(
                "Clicked: Get number of tasks"
        );


        // =====================================================
        // STRIKE OUT TASK 3
        // =====================================================

        driver.findElement(
                AppiumBy.androidUIAutomator(
                        "new UiSelector()"
                        + ".text(\"Clear the list\")"
                )
        ).click();

        System.out.println(
                "Clicked: Clear the list"
        );


        // =====================================================
        // VERIFY TASK COUNT AFTER STRIKING
        // =====================================================

        checkboxes =
                driver.findElements(
                        AppiumBy.className(
                                "android.widget.CheckBox"
                        )
                );

        Assert.assertEquals(
                checkboxes.size(),
                5,
                "Task count should remain 5 after striking tasks"
        );


        System.out.println(
                "Task count after striking: "
                + checkboxes.size()
        );

        System.out.println(
                "Chrome To-Do List Activity completed successfully!"
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