package activity;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity11 {

	public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://training-support.net/webelements/keyboard-events");
        driver.manage().window().maximize();
        System.out.println("Page Title: " + driver.getTitle());

        String message = "Hello Selenium!";
        Actions actions = new Actions(driver);
        actions.sendKeys(message).build().perform();

        System.out.println("Typed Message: " + message);
        driver.quit();
    }
}
