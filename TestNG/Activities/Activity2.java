package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity2 {
	WebDriver driver;
	@BeforeClass
	public void setup() {
		driver=new FirefoxDriver();
		driver.get("https://training-support.net/webelements/target-practice");
	}
	
	@Test
	public void test1() {
		System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(),"Selenium: Target Practice");

		
	}
	@Test
	public void test2() {
        WebElement blackButton = driver.findElement(By.cssSelector("button.black"));        
        Assert.assertTrue(blackButton.isDisplayed());
		Assert.assertEquals(blackButton.getText(),"Black");

	}
	@Test(enabled=false)
	public void test3() {
		
	}
	@Test
	public void test4() {
		throw new SkipException("test 4 is skipped");
	}
	
	@AfterClass
	public void teardown() {
		driver.close();
	}
}
