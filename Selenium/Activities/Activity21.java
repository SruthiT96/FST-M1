package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity21 {
public static void main(String[] args) {
	WebDriver driver=new FirefoxDriver();
	driver.get("https://training-support.net/webelements/tabs");
	System.out.println("Title of the page is :"+driver.getTitle());
    String currentHandle=driver.getWindowHandle();
    System.out.println(currentHandle);
    driver.findElement(By.xpath("//button[contains(text(), 'Open A New Tab')]")).click();
    System.out.println(driver.getWindowHandles());
    for(String window: driver.getWindowHandles()) {
    	if(window.equals(currentHandle)) {
    		continue;
    	}else {
    		driver.switchTo().window(window);
    	}
    }
	System.out.println("Title of the page is :"+driver.getTitle());
	System.out.println("Messge on page is "+driver.findElement(By.cssSelector("h2.mt-5")).getText());
	String currentHandle1=driver.getWindowHandle();
    System.out.println(currentHandle1);
    driver.findElement(By.xpath("//button[contains(text(), 'Open Another One')]")).click();
    System.out.println(driver.getWindowHandles());
    for(String window: driver.getWindowHandles()) {
    	if(window.equals(currentHandle1)) {
    		continue;
    	}else {
    		driver.switchTo().window(window);
    	}
    }
	System.out.println("Title of the page is :"+driver.getTitle());
	System.out.println("Messge on page is "+driver.findElement(By.cssSelector("h2.mt-5")).getText());
	driver.quit();
}
}
