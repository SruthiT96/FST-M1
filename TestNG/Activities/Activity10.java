package Activities_TestNG;

import static org.testng.Assert.assertEquals;

import java.io.FileReader;
import java.time.Duration;
import java.util.List;
import com.opencsv.CSVReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class Activity10 {

    // Declare WebDriver
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() {

        // Initialize Firefox driver
        driver = new FirefoxDriver();

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Open the page
        driver.get("https://training-support.net/webelements/simple-form");

        // Implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @DataProvider(name = "csvDataProvider")
    public static Object[][] readCsv() throws Exception {

        // Open CSV file
        CSVReader reader = new CSVReader(
                new FileReader("src/test/resources/input.csv"));

        // Read all rows
        List<String[]> allRows = reader.readAll();

        // Skip the first row (header)
        Object[][] data = new Object[allRows.size() - 1][4];

        for (int i = 1; i < allRows.size(); i++) {
            data[i - 1][0] = allRows.get(i)[0];
            data[i - 1][1] = allRows.get(i)[1];
            data[i - 1][2] = allRows.get(i)[2];
            data[i - 1][3] = allRows.get(i)[3];
        }

        reader.close();

        return data;
  
    }

    @Test(dataProvider = "csvDataProvider")
    public void testForm(
            String fullNameValue,
            String emailValue,
            String eventDateValue,
            String additionalDetailsValue) {

        // Enter full name
        WebElement fullName = driver.findElement(By.id("full-name"));
        fullName.sendKeys(fullNameValue);

        // Enter email
        driver.findElement(By.id("email")).sendKeys(emailValue);

        // Enter event date
        driver.findElement(By.name("event-date")).sendKeys(eventDateValue);

        // Enter additional details
        driver.findElement(By.id("additional-details"))
              .sendKeys(additionalDetailsValue);

        // Click Submit
        driver.findElement(By.xpath("//button[text()='Submit']")).click();

        // Confirm booking
        String message =
                driver.findElement(By.id("action-confirmation")).getText();

        assertEquals(message, "Your event has been scheduled!");

        // Refresh page for next set of data
        driver.navigate().refresh();
    }

    @AfterClass
    public void tearDown() {

        // Close browser
        if (driver != null) {
            driver.quit();
        }
    }
}