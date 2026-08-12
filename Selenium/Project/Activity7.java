package fstproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity7 {
	WebDriver driver;
	@BeforeClass
	public void setup() {
		driver=new FirefoxDriver();
		driver.get("https://hrm.alchemy.hguy.co/symfony/web/index.php/auth/login");
	}

	@Test
	public void addWorkExperience() {
		driver.findElement(By.id("txtUsername")).sendKeys("orange");
		driver.findElement(By.id("txtPassword")).sendKeys("5Nx#I6BK%r3$8vz0ch");
		driver.findElement(By.name("Submit")).click();
		String dashboardMsg=driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/h1")).getText();
		Assert.assertEquals(dashboardMsg, "Dashboard");
		driver.findElement(By.xpath("//*[@id=\"menu_pim_viewMyDetails\"]/b")).click();
		driver.findElement(By.xpath("//*[@id=\"sidenav\"]/li[9]/a")).click();
		driver.findElement(By.id("addWorkExperience")).click();
		driver.findElement(By.id("experience_employer")).sendKeys("Manav");
		driver.findElement(By.id("experience_jobtitle")).sendKeys("Quality Engineer");
		driver.findElement(By.id("btnWorkExpSave")).click();	
	}
	
	@AfterClass
	public void teardown() {
			driver.quit();
	}
}
