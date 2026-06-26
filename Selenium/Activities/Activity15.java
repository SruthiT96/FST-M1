package activities;

import java.time.Duration;

import org.apache.commons.collections.bag.SynchronizedSortedBag;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity15 {
	public static void main(String[] args) {
		WebDriver driver=new FirefoxDriver();
	    driver.get("https://training-support.net/webelements/dynamic-attributes");
		System.out.println("Title of the page is :"+driver.getTitle());
		driver.findElement(By.xpath("//input[contains(@id,'full-name-')]")).sendKeys("Anusha");
		driver.findElement(By.xpath("//input[contains(@id,'-email')]")).sendKeys("Anusha@gmail.com");
		driver.findElement(By.xpath("//input[contains(@type,'date')]")).sendKeys("2025-06-26");
		driver.findElement(By.xpath("//textarea[contains(@id,'-additional-details-')]")).sendKeys("some info");
		driver.findElement(By.xpath("//button[text()='Submit']")).click();

	    WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	   WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated((By.id("action-confirmation"))));
	    System.out.println("Success message: "+message.getText());
	    driver.quit();
	}
}
