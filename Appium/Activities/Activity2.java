package activities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity2 {
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
	public void webAppTest() {
		driver.get("https://training-support.net");
		String heading=driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Training Support\"]")).getText();
		System.out.println("Heading of the page is: "+heading);
		driver.findElement(AppiumBy.accessibilityId("About Us")).click();
		String abouYouHeading=driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"About Us\")")).getText();
		System.out.println("Heading of the About you screen is: "+abouYouHeading);

	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
