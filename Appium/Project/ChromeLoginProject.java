package Projects;

import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
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

public class ChromeLoginProject {

    AndroidDriver driver;
    WebDriverWait wait;

    String homeUrl =
            "https://training-support.net/webelements";


    // =========================================================
    // SETUP
    // =========================================================

    @BeforeClass
    public void setUp() throws Exception {

        UiAutomator2Options options =
                new UiAutomator2Options();

        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");

        options.setAppPackage(
                "com.android.chrome"
        );

        options.setAppActivity(
                "com.google.android.apps.chrome.Main"
        );

        options.setNoReset(true);


        URL serverURL =
                new URI(
                        "http://127.0.0.1:4723"
                ).toURL();


        driver =
                new AndroidDriver(
                        serverURL,
                        options
                );


        wait =
                new WebDriverWait(
                        driver,
                        Duration.ofSeconds(20)
                );


        // IMPORTANT:
        // Stay in native context.
        // Do NOT switch to WEBVIEW_chrome.

        System.out.println(
                "Current context: "
                + driver.getContext()
        );


        // Open main Training Support page
        driver.get(homeUrl);


        System.out.println(
                "Training Support page opened"
        );
    }


    // =========================================================
    // HELPER METHOD
    // Scroll down
    // =========================================================

    public void scrollDown() {

        Map<String, Object> params =
                new HashMap<>();

        params.put("left", 100);
        params.put("top", 500);
        params.put("width", 800);
        params.put("height", 1200);
        params.put("direction", "down");
        params.put("percent", 0.8);

        ((JavascriptExecutor) driver)
                .executeScript(
                        "mobile: scrollGesture",
                        params
                );
    }


    // =========================================================
    // HELPER METHOD
    // Find Login Form card by scrolling
    // =========================================================

    public void openLoginForm() {

        driver.get(homeUrl);

        boolean loginFound = false;

        // Try scrolling several times
        for (int i = 0; i < 8; i++) {

            if (driver.findElements(
                    AppiumBy.androidUIAutomator(
                            "new UiSelector().text(\"Login Form\")"
                    )
            ).size() > 0) {

                loginFound = true;
                break;
            }

            scrollDown();
        }


        Assert.assertTrue(
                loginFound,
                "Login Form card was not found"
        );


        WebElement loginForm =
                wait.until(
                        ExpectedConditions.elementToBeClickable(
                                AppiumBy.androidUIAutomator(
                                        "new UiSelector().text(\"Login Form\")"
                                )
                        )
                );


        loginForm.click();


        System.out.println(
                "Login Form card opened"
        );


        // Wait for username field
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        AppiumBy.id("username")
                )
        );
    }


    // =========================================================
    // TEST 1
    // CORRECT LOGIN
    // =========================================================

    @Test(priority = 1)
    public void validLoginTest() {

        System.out.println(
                "Starting valid login test..."
        );


        // Open main page, scroll and click Login Form
        openLoginForm();


        // Username
        WebElement username =
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(
                                AppiumBy.id("username")
                        )
                );

        username.clear();

        username.sendKeys(
                "admin"
        );


        // Password
        WebElement password =
                driver.findElement(
                        AppiumBy.id("password")
                );

        password.clear();

        password.sendKeys(
                "password"
        );


        // Submit button
        WebElement submit =
                wait.until(
                        ExpectedConditions.elementToBeClickable(
                                AppiumBy.androidUIAutomator(
                                        "new UiSelector().text(\"Submit\")"
                                )
                        )
                );

        submit.click();


        System.out.println(
                "Correct credentials submitted"
        );


        // =====================================================
        // VERIFY SUCCESS
        // =====================================================

        WebElement success =
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(
                                AppiumBy.androidUIAutomator(
                                        "new UiSelector().text(\"Success!\")"
                                )
                        )
                );


        Assert.assertTrue(
                success.isDisplayed(),
                "Success message was not displayed"
        );


        WebElement welcome =
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(
                                AppiumBy.androidUIAutomator(
                                        "new UiSelector().textContains(\"Welcome Back\")"
                                )
                        )
                );


        Assert.assertTrue(
                welcome.getText()
                        .contains("Admin"),
                "Welcome Back, Admin message was not displayed"
        );


        System.out.println(
                "Success message: "
                + success.getText()
        );


        System.out.println(
                "Welcome message: "
                + welcome.getText()
        );


        System.out.println(
                "VALID LOGIN TEST PASSED"
        );
    }


    // =========================================================
    // TEST 2
    // INCORRECT LOGIN
    // =========================================================

    @Test(priority = 2)
    public void invalidLoginTest() {

        System.out.println(
                "Starting invalid login test..."
        );


        // Go back to main page,
        // scroll and open Login Form again
        openLoginForm();


        // Username
        WebElement username =
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(
                                AppiumBy.id("username")
                        )
                );

        username.clear();

        username.sendKeys(
                "wronguser"
        );


        // Password
        WebElement password =
                driver.findElement(
                        AppiumBy.id("password")
                );

        password.clear();

        password.sendKeys(
                "wrongpassword"
        );


        // Submit
        WebElement submit =
                wait.until(
                        ExpectedConditions.elementToBeClickable(
                                AppiumBy.androidUIAutomator(
                                        "new UiSelector().text(\"Submit\")"
                                )
                        )
                );

        submit.click();


        System.out.println(
                "Incorrect credentials submitted"
        );


        // =====================================================
        // VERIFY ERROR
        // =====================================================

        WebElement error =
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(
                                AppiumBy.androidUIAutomator(
                                        "new UiSelector().text(\"Invalid credentials\")"
                                )
                        )
                );


        Assert.assertTrue(
                error.isDisplayed(),
                "Invalid credentials message was not displayed"
        );


        Assert.assertEquals(
                error.getText(),
                "Invalid credentials"
        );


        System.out.println(
                "Error message: "
                + error.getText()
        );


        System.out.println(
                "INVALID LOGIN TEST PASSED"
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