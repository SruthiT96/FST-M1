package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Activity7 {
	WebDriver driver;
	@BeforeClass(alwaysRun = true)
	public void setup() {
		driver=new FirefoxDriver();
		driver.get("https://training-support.net/webelements/login-form");
	}
	
	@Test(dataProvider = "Authentication")
	public void testMethod(String username, String password, String expectedOutput) throws InterruptedException {
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//input[@id=\"username\"]")).clear();
		driver.findElement(By.xpath("//input[@id=\"username\"]")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id=\"password\"]")).clear();
		driver.findElement(By.xpath("//input[@id=\"password\"]")).sendKeys(password);
		driver.findElement(By.xpath("//button[@class=\"svelte-1pdjkmx\"]")).click();
		Thread.sleep(2000);
		 // Assert login message
		String loginMessage = driver.findElement(By.id("subheading")).getText();
        Assert.assertEquals(expectedOutput, loginMessage);
	}
	@AfterClass(alwaysRun = true)
	public void teardown() {
		driver.quit();
	
	}
	
	@DataProvider(name="Authentication")
	public Object[][] credentials(){
		return new Object[][] {{"admin1","password1","Invalid Credentials"},
			{"admin2","password2","Invalid Credentials"}};
		
	}
}
