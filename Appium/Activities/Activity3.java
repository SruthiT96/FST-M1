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

public class Activity3 {
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
		
	}
	
	
	@BeforeMethod
	public void clearResult() {
		
		driver.findElement(AppiumBy.accessibilityId("clear")).click();

	}
	
	@Test
	public void addTest() {
		driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_5")).click();
		driver.findElement(AppiumBy.accessibilityId("plus")).click();
		driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_9")).click();
		driver.findElement(AppiumBy.accessibilityId("equals")).click();
		String result=driver.findElement(AppiumBy.id("com.google.android.calculator:id/result_final")).getText();
		System.out.println(result);
		Assert.assertEquals(result, "14");


	}
	
	@Test
	public void subtractTest() {
		driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_1")).click();
		driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_0")).click();

		driver.findElement(AppiumBy.accessibilityId("minus")).click();
		driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_5")).click();
		driver.findElement(AppiumBy.accessibilityId("equals")).click();
		String result=driver.findElement(AppiumBy.id("com.google.android.calculator:id/result_final")).getText();
		System.out.println(result);
		Assert.assertEquals(result, "5");


	}
	
	@Test
	public void multiplyTest() {
		driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_5")).click();

		driver.findElement(AppiumBy.accessibilityId("multiply")).click();
		driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_1")).click();
		driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_0")).click();
		driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_0")).click();

		driver.findElement(AppiumBy.accessibilityId("equals")).click();
		String result=driver.findElement(AppiumBy.id("com.google.android.calculator:id/result_final")).getText();
		System.out.println(result);
		Assert.assertEquals(result, "500");


	}
	
	@Test
	public void divideTest() {
		driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_5")).click();
		driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_0")).click();

		driver.findElement(AppiumBy.accessibilityId("divide")).click();
		driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_2")).click();
		driver.findElement(AppiumBy.accessibilityId("equals")).click();
		String result=driver.findElement(AppiumBy.id("com.google.android.calculator:id/result_final")).getText();
		System.out.println(result);
		Assert.assertEquals(result, "25");


	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
