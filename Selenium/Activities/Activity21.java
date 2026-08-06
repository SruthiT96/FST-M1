package activity;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity21 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
        driver.get("https://training-support.net/webelements/tabs");
        driver.manage().window().maximize();
        System.out.println("Page Title: " + driver.getTitle());
        
        driver.findElement(By.xpath("//button[contains(text(),'Open A New Tab')]")).click();
        Thread.sleep(2000);
        
        Set<String> handles = driver.getWindowHandles();
        System.out.println("Window Handles:");
        for (String handle : handles) {
            System.out.println(handle);
        }

        ArrayList<String> tabs = new ArrayList<>(handles);
        driver.switchTo().window(tabs.get(1));
        System.out.println("Second Tab Title: " + driver.getTitle());

        WebElement message = driver.findElement(By.tagName("h1"));
        System.out.println("Message: " + message.getText());
        driver.findElement(By.xpath("//button[contains(text(),'Open Another One')]")).click();
        Thread.sleep(2000);
        handles = driver.getWindowHandles();
        System.out.println("\nUpdated Window Handles:");
        for (String handle : handles) {
            System.out.println(handle);
        }

        tabs = new ArrayList<>(handles);
        driver.switchTo().window(tabs.get(2));
        System.out.println("Third Tab Title: " + driver.getTitle());
        message = driver.findElement(By.tagName("h1"));
        System.out.println("Message: " + message.getText());
        
        driver.quit();
    }
}
