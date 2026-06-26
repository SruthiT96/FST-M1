package activities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Activity16 {
	public static void main(String[] args) {
		WebDriver driver=new FirefoxDriver();
		driver.get("https://training-support.net/webelements/selects");
		System.out.println("Title of the page is :"+driver.getTitle());
		WebElement dropdown=driver.findElement(By.xpath("/html/body/div/main/div/div/div/div/section/div[1]/select"));
		Select select=new Select(dropdown);
		select.selectByVisibleText("Two");
		select.selectByIndex(3);
		select.selectByValue("four");
		List<WebElement> opns=select.getOptions();
		for(WebElement op:opns) {
			System.out.println(op.getText());
		}
		driver.quit();

	}
	}