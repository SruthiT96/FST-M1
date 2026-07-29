package project;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import project.ActionsBase;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity4 {
	AppiumDriver driver;
	WebDriverWait wait;

	
	@BeforeClass
	public void setup() throws MalformedURLException, URISyntaxException {
		//File object for application
		//set desired capabilities or options
		UiAutomator2Options options=new UiAutomator2Options();
		options.setPlatformName("android");
		options.setAutomationName("UiAutomator2");
		options.setAppPackage("com.android.chrome");
		options.setAppActivity("com.google.android.apps.chrome.Main");
		options.noReset();		
		//set server url
		URL serverurl=new URI("http://localhost:4723").toURL();//local host=127.0.0.1
		driver=new AndroidDriver(serverurl,options);
		
	}
	
	
	@Test(dataProvider = "tasks")
	public void webAppTest(String task) {
		driver.get("https://training-support.net/webelements");
		ActionsBase base=new ActionsBase();
		base.scrollVertically(driver, 2000, 200);
		base.scrollVertically(driver, 2000, 200);
		base.scrollVertically(driver, 2000, 200);
		base.scrollVertically(driver, 2000, 200);

		driver.findElement(AppiumBy.accessibilityId("To-Do List Elements get added at runtime!")).click();
		driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"todo-input\"]")).sendKeys(task);
		driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id=\"todo-add\"]")).click();

		driver.findElement(By.xpath("//android.widget.ListView/android.view.View[3]/android.view.View/android.widget.CheckBox")).click();
		List<WebElement> tasklist=driver.findElements(By.xpath("new UiSelector().className(\"android.widget.ListView\")"));
		int totalNumber=tasklist.size();
		Assert.assertEquals(totalNumber, 2);

	}
	
	
	@DataProvider(name="tasks")
	public Object[][] tasks(){
		return new Object[] [] {
			{"Add tasks to list"},
			{"Get number of tasks"},
			{"Clear the list"}
		};
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
