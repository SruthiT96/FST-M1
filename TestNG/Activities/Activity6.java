package Activities_TestNG;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Activity6 {
	WebDriver driver;
	WebDriverWait wait;
	@BeforeClass
	public void beforeClass() {
	// Initialize Firefox driver
	driver = new FirefoxDriver();
	// Initialize explicit wait
	wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	// Open login page
	driver.get("https://training-support.net/webelements/login-form");
	}
	@Test
	@Parameters({ "username", "password", "message" })
	public void loginTestCase(
	String username,
	String password,
	@Optional("Welcome Back, Admin!") String message) {
	// Find username field
	WebElement usernameField =
	driver.findElement(By.id("username"));
	// Find password field
	WebElement passwordField =
	driver.findElement(By.id("password"));
	// Enter credentials
	usernameField.sendKeys(username);
	passwordField.sendKeys(password);
	// Click Submit
	driver.findElement(By.xpath("//button[text()='Submit']")).click();
	// Wait for successful login
	wait.until(ExpectedConditions.titleContains("Success"));
	// Get login message
	String loginMessage =
	driver.findElement(By.cssSelector("h2.text-center")).getText();
	// Verify login message
	Assert.assertEquals(loginMessage, message);
	}
	@AfterClass
	public void afterClass() {
	// Close browser
	if (driver != null) {
	driver.quit();
	}
	}
	}
