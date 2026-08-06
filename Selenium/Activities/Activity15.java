package activity;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity15 {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
        driver.get("https://training-support.net/webelements/dynamic-attributes");
        driver.manage().window().maximize();
        System.out.println("Page Title: " + driver.getTitle());

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement firstName = driver.findElement(By.xpath("//input[starts-with(@id, 'full-name')]"));
        WebElement email = driver.findElement(By.xpath("//input[contains(@id, '-email')]"));
        WebElement eventdate = driver.findElement(By.xpath("//input[contains(@name, '-event-date-')]"));
        WebElement additionaldetails = driver.findElement(By.xpath("//textarea[contains(@id, '-additional-details-')]"));
        firstName.sendKeys("John");
        email.sendKeys("john.doe@example.com");
        eventdate.sendKeys("2026-06-25");
        additionaldetails.sendKeys("Dealing with dynamic attributes");
        
        WebElement submitBtn = driver.findElement(By.xpath("//button[text()='Submit']"));
        submitBtn.click();

        WebElement successMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(
                            By.id("action-confirmation")));
        System.out.println("Success Message: " + successMsg.getText());

        //driver.quit();
    }
}
