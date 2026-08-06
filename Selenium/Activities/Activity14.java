package activity;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity14 {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
        driver.get("https://training-support.net/webelements/tables");
        driver.manage().window().maximize();
        System.out.println("Page Title: " + driver.getTitle());

        List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));
        System.out.println("Number of Rows: " + rows.size());

        List<WebElement> columns = driver.findElements(By.xpath("//table/thead/tr/th"));
        System.out.println("Number of Columns: " + columns.size());

        WebElement bookBeforeSort = driver.findElement(By.xpath("//table/tbody/tr[5]/td[1]"));
        System.out.println("Book in 5th Row (Before Sorting): " + bookBeforeSort.getText());

        WebElement priceHeader = driver.findElement(By.xpath("//table/thead/tr/th[contains(text(),'Price')]"));
        priceHeader.click();

        //Thread.sleep(1000);

        WebElement bookAfterSort = driver.findElement(By.xpath("//table/tbody/tr[5]/td[1]"));
        System.out.println("Book in 5th Row (After Sorting): " + bookAfterSort.getText());

       //driver.quit(); 
	}
}