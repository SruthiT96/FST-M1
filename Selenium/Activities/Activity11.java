package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity11 {
	public static void main(String[] args) {
		WebDriver driver=new FirefoxDriver();
	    driver.get("https://training-support.net/webelements/keyboard-events");
		System.out.println("Title of the page is :"+driver.getTitle());
		Actions actions=new Actions(driver);
	    actions.sendKeys("Hi from the script").sendKeys(Keys.RETURN).build().perform();
	    System.out.println(driver.findElement(By.xpath("/html/body/div/main/div/div/div/div/div[2]/h1")).getText());
	    driver.quit();
	}
}
