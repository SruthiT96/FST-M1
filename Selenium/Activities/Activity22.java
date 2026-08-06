package activity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity22 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
        driver.get("https://training-support.net/webelements/popups");
        driver.manage().window().maximize();
        System.out.println("Page Title: " + driver.getTitle());
        
        driver.findElement(By.id("launcher")).click();
        Thread.sleep(2000);
        
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("password");
        driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();
        
        String message = driver.findElement(By.cssSelector("h2.text-center")).getText();
        System.out.println("Login message text: " + message);
        
        driver.quit();
    }
}
