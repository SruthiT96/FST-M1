package fstproject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity6 {
	WebDriver driver;

	@BeforeClass
	public void setup() {
		driver = new FirefoxDriver();
		driver.get("https://hrm.alchemy.hguy.co/symfony/web/index.php/auth/login");

	}

	@Test
	public void verifyDirectory() {
		driver.findElement(By.id("txtUsername")).sendKeys("orange");
		driver.findElement(By.id("txtPassword")).sendKeys("5Nx#I6BK%r3$8vz0ch");
		driver.findElement(By.name("Submit")).click();
		String dashboardMsg = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/h1")).getText();
		Assert.assertEquals(dashboardMsg, "Dashboard");
		WebElement directory = driver.findElement(By.xpath("//*[@id=\"menu_directory_viewDirectory\"]/b"));
		System.out.println("Is Directory displayed? " + directory.isDisplayed());
		System.out.println("Is Directory enabled? " + directory.isEnabled());
		if (directory.isEnabled()) {
			directory.click();
		}
		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"content\"]/div[1]/div[1]/h1")));
		String directoryHeading = driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div[1]/h1")).getText();
		Assert.assertEquals(directoryHeading, "Search Directory");

	}

	@AfterClass
	public void teardown() {
		driver.quit();
	}
}
