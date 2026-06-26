package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Activity17 {
public static void main(String[] args) {
	WebDriver driver=new FirefoxDriver();
	driver.get("https://training-support.net/webelements/selects");
	System.out.println("Title of the page is :"+driver.getTitle());
	WebElement dropdown=driver.findElement(By.xpath("/html/body/div/main/div/div/div/div/section/div[2]/select"));
	Select select=new Select(dropdown);
	select.selectByVisibleText("HTML");
	select.selectByIndex(5);
	select.selectByIndex(6);
	select.selectByIndex(7);
	select.selectByValue("nodejs");
	select.deselectByIndex(5);
	driver.quit();

}
}
