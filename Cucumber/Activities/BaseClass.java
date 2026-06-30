package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {
	WebDriver driver;
	public BaseClass() {
		this.driver=new FirefoxDriver();
	}
}
