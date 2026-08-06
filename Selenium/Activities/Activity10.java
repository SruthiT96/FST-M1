package activity;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity10 {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
        driver.get("https://training-support.net/webelements/mouse-events");
        driver.manage().window().maximize();
        System.out.println("Page Title: " + driver.getTitle());

        Actions actions = new Actions(driver);
        WebElement cargoLock = driver.findElement(By.xpath("//h1[text()='Cargo.lock']"));
        WebElement cargoToml = driver.findElement(By.xpath("//h1[text()='Cargo.toml']"));
        
        actions
               .click(cargoLock).pause(1000)
               .moveToElement(cargoToml).pause(4000)
               .click()
               .build()
               .perform();

        WebElement resultText1 = driver.findElement(By.id("result"));
        System.out.println("First Action Result: " + resultText1.getText());

        WebElement src = driver.findElement(By.xpath("//h1[text()='src']"));
        WebElement target = driver.findElement(By.xpath("//h1[text()='target']"));
        actions
                .doubleClick(src).pause(4000)
                .contextClick(target).pause(4000)
                .build()
                .perform();

         WebElement openOption = driver.findElement(By.xpath("//div[@id='menu']/div/ul/li[1]"));
         openOption.click();

         WebElement resultText2 = driver.findElement(By.id("result"));
         System.out.println("Second Action Result: " + resultText2.getText());
         driver.quit();
        
    }
}
