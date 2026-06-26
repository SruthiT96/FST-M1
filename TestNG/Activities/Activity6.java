package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Activity6 {
	WebDriver driver;
	@BeforeClass(alwaysRun = true)
	public void setup() {
		driver=new FirefoxDriver();
		driver.get("https://training-support.net/webelements/login-form");
	}
	
	@Test
	@Parameters({"username","password"})
	public void testMethod(String username, String password) throws InterruptedException {
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//input[@id=\"username\"]")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id=\"password\"]")).sendKeys(password);
		driver.findElement(By.xpath("//button[@class=\"svelte-1pdjkmx\"]")).click();
		Thread.sleep(2000);
		 // Assert login message
        String loginMessage = driver.findElement(By.cssSelector("h2.text-center")).getText();
        Assert.assertEquals("Welcome Back, Admin!", loginMessage);

		
	}

	
	@AfterClass(alwaysRun = true)
	public void teardown() {
		driver.close();
	
	}
}
