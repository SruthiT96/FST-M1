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

public class Activity8 {
	WebDriver driver;
	@BeforeClass
	public void setup() {
		driver=new FirefoxDriver();
		driver.get("https://hrm.alchemy.hguy.co/symfony/web/index.php/auth/login");
	}

	@Test
	public void applyLeave() throws InterruptedException {
		driver.findElement(By.id("txtUsername")).sendKeys("orange");
		driver.findElement(By.id("txtPassword")).sendKeys("5Nx#I6BK%r3$8vz0ch");
		driver.findElement(By.name("Submit")).click();
		String dashboardMsg=driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/h1")).getText();
		Assert.assertEquals(dashboardMsg, "Dashboard");
		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@id=\"dashboard-quick-launch-panel-menu_holder\"]/table/tbody/tr/td[4]/div/a/span")).click();

		WebElement leaveType= driver.findElement(By.id("applyleave_txtLeaveType"));
		Select s1=new Select(leaveType);
		s1.selectByVisibleText("Holiday");
		driver.findElement(By.id("applyleave_txtFromDate")).clear();
		driver.findElement(By.id("applyleave_txtFromDate")).sendKeys("2026-07-01");
		driver.findElement(By.id("applyleave_txtToDate")).clear();
		driver.findElement(By.id("applyleave_txtToDate")).sendKeys("2026-07-02");
		Thread.sleep(2000);
		driver.findElement(By.id("applyBtn")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@id=\"menu_leave_viewLeaveModule\"]/b")).click();
		WebElement leaveTable=driver.findElement(By.id("resultTable"));
		System.out.println("Leave status is "+leaveTable.findElement(By.xpath("//table/tbody/tr[1]/td[6]")).getText());

	}
	@AfterClass
	public void teardown() {
			driver.quit();
	}
}