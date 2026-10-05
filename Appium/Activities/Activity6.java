package AppiumActivities;

import static org.testng.Assert.assertTrue;

import java.net.URI;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity6 {

    AndroidDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws Exception {

        // Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();

        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.android.chrome");
        options.setAppActivity("com.google.android.apps.chrome.Main");
        options.setNoReset(true);

        // Appium Server URL
        URL serverURL =
                new URI("http://localhost:4723").toURL();

        // Driver initialization
        driver = new AndroidDriver(serverURL, options);

        // Explicit wait
        wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(20)
        );

        // Open slider page
        driver.get(
                "https://training-support.net/webelements/sliders"
        );
    }


    @Test(priority = 1)
    public void volume75Test() {

        // Find the slider
        WebElement slider = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.xpath("//android.widget.SeekBar")
                )
        );

        // Get actual slider position
        Point location = slider.getLocation();

        // Get actual slider dimensions
        Dimension size = slider.getSize();

        System.out.println(
                "Slider location: " + location
        );

        System.out.println(
                "Slider size: " + size
        );

        // Find vertical center of slider
        int y =
                location.getY()
                + (size.getHeight() / 2);

        // Start at 50%
        Point start = new Point(
                location.getX()
                + (size.getWidth() / 2),
                y
        );

        // Move to 75%
        Point end = new Point(
                location.getX()
                + (int) (size.getWidth() * 0.74),
                y
        );

        System.out.println(
                "75% swipe start: " + start
        );

        System.out.println(
                "75% swipe end: " + end
        );

        // Perform swipe
        new ActionBase().doSwipe(
                driver,
                1500,
                start,
                end
        );

        // Get displayed percentage
        String volumeText = driver
                .findElement(
                        AppiumBy.xpath(
                                "//android.view.View/android.widget.TextView[contains(@text, '%')]"
                        )
                )
                .getText();

        System.out.println(
                "Volume after 75% swipe: "
                + volumeText
        );

        // Assertion
        assertTrue(
                volumeText.contains("75%"),
                "Expected 75%, but found: " + volumeText
        );
    }


    @Test(priority = 2)
    public void volume25Test() {

        // Reload page so slider starts at 50%
        driver.get(
                "https://training-support.net/webelements/sliders"
        );

        // Find slider again
        WebElement slider = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.xpath("//android.widget.SeekBar")
                )
        );

        Point location = slider.getLocation();

        Dimension size = slider.getSize();

        // Vertical center of slider
        int y =
                location.getY()
                + (size.getHeight() / 2);

        // Start at 50%
        Point start = new Point(
                location.getX()
                + (size.getWidth() / 2),
                y
        );

        // Move to 25%
        Point end = new Point(
                location.getX()
                + (int) (size.getWidth() * 0.27),
                y
        );

        System.out.println(
                "25% swipe start: " + start
        );

        System.out.println(
                "25% swipe end: " + end
        );

        // Perform swipe
        new ActionBase().doSwipe(
                driver,
                1500,
                start,
                end
        );

        // Get displayed percentage
        String volumeText = driver
                .findElement(
                        AppiumBy.xpath(
                                "//android.view.View/android.widget.TextView[contains(@text, '%')]"
                        )
                )
                .getText();

        System.out.println(
                "Volume after 25% swipe: "
                + volumeText
        );

        // Assertion
        assertTrue(
                volumeText.contains("25%"),
                "Expected 25%, but found: " + volumeText
        );
    }


    @AfterClass(alwaysRun = true)
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}