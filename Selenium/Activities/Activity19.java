package activity;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity19 {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
        driver.get("https://training-support.net/webelements/alerts");
        driver.manage().window().maximize();
        System.out.println("Page Title: " + driver.getTitle());
        
        driver.findElement(By.xpath("//button[contains(text(),'Confirm')]")).click();
        Alert alert = driver.switchTo().alert();
        System.out.println("Alert Text (OK): " + alert.getText());
        alert.accept();
        System.out.println("Clicked OK");

        driver.findElement(By.xpath("//button[contains(text(),'Confirm')]")).click();
        alert = driver.switchTo().alert();
        System.out.println("Alert Text (Cancel): " + alert.getText());
        alert.dismiss();
        System.out.println("Clicked Cancel");
        
        driver.quit();
    }
}