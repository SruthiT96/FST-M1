package fstproject;

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
		driver.get("https://hrm.alchemy.hguy.co/");
		
	}

	@Test
	public void readTitle() {
		System.out.println("Title of the page is "+driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");
		
	}
	
	@AfterClass
	public void teardown() {
		if(driver.getTitle().equals("OrangeHRM"))
			driver.quit();
	}
}
