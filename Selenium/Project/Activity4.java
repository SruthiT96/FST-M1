package fstproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity4 {
	WebDriver driver;
	@BeforeClass
	public void setup() {
		driver=new FirefoxDriver();
		driver.get("https://hrm.alchemy.hguy.co/symfony/web/index.php/auth/login");
		
	}

	@Test
	public void addSearchEmployee() {
		driver.findElement(By.id("txtUsername")).sendKeys("orange");
		driver.findElement(By.id("txtPassword")).sendKeys("5Nx#I6BK%r3$8vz0ch");
		driver.findElement(By.name("Submit")).click();
		String dashboardMsg=driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/h1")).getText();
		Assert.assertEquals(dashboardMsg, "Dashboard");
		driver.findElement(By.xpath("//*[@id=\"menu_pim_viewPimModule\"]/b")).click();
		driver.findElement(By.id("btnAdd")).click();
		driver.findElement(By.id("firstName")).sendKeys("Prajwal");
		driver.findElement(By.id("lastName")).sendKeys("Prasad");
		driver.findElement(By.id("btnSave")).click();
		driver.get("https://hrm.alchemy.hguy.co/symfony/web/index.php/pim/viewEmployeeList");
		driver.findElement(By.id("empsearch_employee_name_empName")).sendKeys("Prajwal");
		driver.findElement(By.id("searchBtn")).click();
		String searchResult=driver.findElement(By.xpath("//table/tbody/tr/td[3]/a[contains(text(),'Prajwal')]")).getText();
		Assert.assertEquals(searchResult, "Prajwal");
		

		
	}
	
	@AfterClass
	public void teardown() {
			driver.quit();
	}
}
