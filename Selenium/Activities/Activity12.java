package activity;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity12 {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
        driver.get("https://training-support.net/webelements/drag-drop");
        driver.manage().window().maximize();
        System.out.println("Page Title: " + driver.getTitle());

        WebElement ball = driver.findElement(By.id("ball"));
        WebElement dropzone1 = driver.findElement(By.id("dropzone1"));
        WebElement dropzone2 = driver.findElement(By.id("dropzone2"));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(ball, dropzone1).build().perform();

        String dropzone1Text = dropzone1.getText();
        System.out.println("Dropzone 1 Text: " + dropzone1Text);

        if (dropzone1Text.contains("Ball")) {
                System.out.println("Ball successfully moved to Dropzone 1");
                }

        ball = driver.findElement(By.id("ball"));

        actions.dragAndDrop(ball, dropzone2).build().perform();

        String dropzone2Text = dropzone2.getText();
        System.out.println("Dropzone 2 Text: " + dropzone2Text);

        if (dropzone2Text.contains("Ball")) {
                System.out.println("Ball successfully moved to Dropzone 2");
            }

            driver.quit();
    }
}