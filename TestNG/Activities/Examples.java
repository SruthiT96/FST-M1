package Activities_TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Examples {
	WebDriver driver;

	@BeforeClass //Opening a webpage
	public void setUp() {
		driver = new FirefoxDriver();
		driver.get("https://training-support.net");
	}
	
	@Test(priority = 1) //Get title of the page and click on ABout us
	public void homePageTest(){
		Assert.assertEquals(driver.getTitle(), "Traning Support");
		driver.findElement(By.linkText("About Us")).click();
		
	}
	
	@Test(priority = 2) //Get title of the about us page
	public void aboutPageTest() {
		Assert.assertEquals(driver.getTitle(), "About Training Support");
	}
	@AfterClass //Once test run is completed close the window
	public void Teardown() {
		driver.quit();
	}
}