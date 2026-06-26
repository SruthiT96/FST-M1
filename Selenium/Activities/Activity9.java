package activities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity9 {
	public static void main(String[] args) {
		WebDriver driver=new FirefoxDriver();
	    driver.get("https://training-support.net/webelements/dynamic-content");
		System.out.println("Title of the page is :"+driver.getTitle());
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	    driver.findElement(By.id("genButton")).click();
	    wait.until(ExpectedConditions.textToBePresentInElementLocated((By.id("word")),"release"));
	    System.out.println("Expect text is:"+driver.findElement(By.id("word")).getText());
	    driver.quit();
	}
}
