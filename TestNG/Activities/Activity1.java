package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity1 {
	WebDriver driver;
	@BeforeClass
	public void setup() {
		driver=new FirefoxDriver();
		driver.get("https://training-support.net/");
	}
	
	@Test
	public void testmethod() {
		System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(),"Training Support");
		driver.findElement(By.linkText("About Us")).click();
		System.out.println("New page title is "+driver.getTitle());
		Assert.assertEquals(driver.getTitle(),"About Training Support");

		
	}
	
	@AfterClass
	public void teardown() {
		driver.close();
	}

}
