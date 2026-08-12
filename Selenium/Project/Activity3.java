package fstproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity3 {
	WebDriver driver;
	@BeforeClass
	public void setup() {
		driver=new FirefoxDriver();
		driver.get("https://hrm.alchemy.hguy.co/symfony/web/index.php/auth/login");
		
	}

	@Test
	public void login() {
		driver.findElement(By.id("txtUsername")).sendKeys("orange");
		driver.findElement(By.id("txtPassword")).sendKeys("5Nx#I6BK%r3$8vz0ch");
		driver.findElement(By.name("Submit")).click();
		String dashboardMsg=driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/h1")).getText();
		Assert.assertEquals(dashboardMsg, "Dashboard");
		
	}
	
	@AfterClass
	public void teardown() {
			driver.quit();
	}
}
