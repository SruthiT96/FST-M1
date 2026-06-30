package fstproject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity9 {
	WebDriver driver;
	@BeforeClass
	public void setup() {
		driver=new FirefoxDriver();
		driver.get("https://hrm.alchemy.hguy.co/symfony/web/index.php/auth/login");
	}

	@Test
	public void emergencyContactList() throws InterruptedException {
		driver.findElement(By.id("txtUsername")).sendKeys("orange");
		driver.findElement(By.id("txtPassword")).sendKeys("5Nx#I6BK%r3$8vz0ch");
		driver.findElement(By.name("Submit")).click();
		String dashboardMsg=driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/h1")).getText();
		Assert.assertEquals(dashboardMsg, "Dashboard");
		Thread.sleep(1000);

		driver.findElement(By.xpath("//*[@id=\"menu_pim_viewMyDetails\"]/b")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@id=\"sidenav\"]/li[3]/a")).click();
		Thread.sleep(3000);
		
		WebElement emgContactTable=driver.findElement(By.id("emgcontact_list"));
		List<WebElement> rows= emgContactTable.findElements(By.tagName("tr"));
		for(int r=0;r<rows.size();r++) {
			if(r==0) {
				List<WebElement> headers= emgContactTable.findElements(By.tagName("th"));
				for(WebElement header:headers) {
				System.out.print(header.getText()+" ");
				}
				System.out.println();
				System.out.println("-------------------------");
			}else {
				List<WebElement> columns= emgContactTable.findElements(By.tagName("td"));
				for(WebElement cell:columns) {
				System.out.print(cell.getText()+" ");
				}
				System.out.println("");

			}

		}
	}
	
	@AfterClass
	public void teardown() {
			driver.quit();
	}
}
