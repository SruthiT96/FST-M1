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

public class Activity1 {
	AppiumDriver driver;
	WebDriverWait wait;
	
	@BeforeClass
	public void setup() throws MalformedURLException, URISyntaxException {
		//File object for application
		File testApp=new File("src/test/resources/Calculator.apk");

		//set desired capabilities or options
		UiAutomator2Options options=new UiAutomator2Options();
		options.setPlatformName("android");
		options.setAutomationName("UiAutomator2");
		options.setApp(testApp.getAbsolutePath());
//		options.noReset();		
		//set server url
		URL serverurl=new URI("http://localhost:4723").toURL();//local host=127.0.0.1
		driver=new AndroidDriver(serverurl,options);
		
		//set desired capabilities or options for iOS
//		XCUITestOptions options=new XCUITestOptions();
//		options.setPlatformName("ios");
//		options.setAutomationName("XCUITest");
//		options.setApp(testApp.getAbsolutePath());
//		driver=new IOSDriver(serverurl, options);
		
	}
	
	
	@BeforeMethod
	public void clearResult() {
		
		driver.findElement(AppiumBy.accessibilityId("clear")).click();

	}
	
	
	@Test
	public void multiplyTest() {
		driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_7")).click();
		driver.findElement(AppiumBy.accessibilityId("multiply")).click();
		driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_3")).click();
		driver.findElement(AppiumBy.accessibilityId("equals")).click();
		String result=driver.findElement(AppiumBy.id("com.google.android.calculator:id/result_final")).getText();
		System.out.println(result);
		Assert.assertEquals(result, "21");


	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
