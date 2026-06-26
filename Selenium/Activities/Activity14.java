package activities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity14 {
	public static void main(String[] args) {
		WebDriver driver=new FirefoxDriver();
	    driver.get("https://training-support.net/webelements/tables");
		System.out.println("Title of the page is :"+driver.getTitle());
		List<WebElement> rows=driver.findElements(By.xpath("//table/tbody/tr"));
		System.out.println(rows.size());
		List<WebElement> columns=driver.findElements(By.xpath("//table/thead/tr/th"));
		System.out.println(columns.size());
		System.out.println(driver.findElement(By.xpath("//table/tbody/tr[5]/td[2]")).getText());
		driver.findElement(By.xpath("//table/thead/tr/th[5]")).click();
		System.out.println(driver.findElement(By.xpath("//table/tbody/tr[5]/td[2]")).getText());
		driver.quit();
	}
}
