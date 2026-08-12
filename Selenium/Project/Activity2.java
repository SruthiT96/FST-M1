package fstproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity2 {
	WebDriver driver;
	@BeforeClass
	public void setup() {
		driver=new FirefoxDriver();
		driver.get("https://hrm.alchemy.hguy.co/");
		
	}

	@Test
	public void getUrlofImage() {
		System.out.println(driver.findElement(By.xpath(("//*[@id=\"divLogo\"]/img"))).getAttribute("src"));		
	}
	
	@AfterClass
	public void teardown() {
			driver.quit();
	}
}
