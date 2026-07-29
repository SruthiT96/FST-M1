package project;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
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

public class Activity5 {
	AppiumDriver driver;
	WebDriverWait wait;

	@BeforeClass
	public void setup() throws MalformedURLException, URISyntaxException {
		// File object for application
		// set desired capabilities or options
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("android");
		options.setAutomationName("UiAutomator2");
		options.setAppPackage("com.android.chrome");
		options.setAppActivity("com.google.android.apps.chrome.Main");
		options.noReset();
		// set server url
		URL serverurl = new URI("http://localhost:4723").toURL();// local host=127.0.0.1
		driver = new AndroidDriver(serverurl, options);

	}

	@Test(priority=1)
	public void validDataTest() {
		driver.get("https://training-support.net/webelements");
		ActionsBase base = new ActionsBase();
		base.scrollVertically(driver, 2000, 200);
		base.scrollVertically(driver, 2000, 200);
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Login Form\"]")).click();
		driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"username\"]")).sendKeys("admin");
		driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"password\"]")).sendKeys("password");

		driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"Submit\"]")).click();

		String output = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Login Success!\"]")).getText();
		String output2 = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Welcome Back, Admin!\"]"))
				.getText();

		Assert.assertEquals(output + " " + output2, "Login Success! Welcome Back, Admin!");

	}

	@Test(priority=2)
	public void invalidDatatest() {
		driver.get("https://training-support.net/webelements");
		ActionsBase base = new ActionsBase();
		base.scrollVertically(driver, 2000, 200);
		base.scrollVertically(driver, 2000, 200);
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Login Form\"]")).click();
		driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"username\"]")).sendKeys("abcd");
		driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"password\"]")).sendKeys("xyzb");

		driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"Submit\"]")).click();

		String output = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Invalid credentials\"]"))
				.getText();
		Assert.assertEquals(output, "Invalid credentials");

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
