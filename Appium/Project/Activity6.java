package project;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
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

public class Activity6 {
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
	
	
	@Test
	public void webAppTest() throws InterruptedException {
		driver.get("https://training-support.net/webelements");
		ActionsBase base=new ActionsBase();
		base.scrollVertically(driver, 2000, 200);
		base.scrollVertically(driver, 2000, 200);
		base.scrollVertically(driver, 2000, 200);

		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Popups\"]")).click();
		base.clickOnpopUP(driver, 100, 550, 1200);//click on celebrate button
		base.clickOnpopUP(driver, 100, 255, 670); // click on popup
		driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"username\"]")).sendKeys("admin");
		driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"password\"]")).sendKeys("password");

		driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"Submit\"]")).click();
		
		String output=driver.findElement(By.xpath("//android.widget.TextView[@text=\"Login Success!\"]")).getText();
		String output2=driver.findElement(By.xpath("//android.widget.TextView[@text=\"Welcome Back, Admin!\"]")).getText();

		Assert.assertEquals(output+" "+output2, "Login Success! Welcome Back, Admin!");

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
