package stepDefinitions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Activity1Stepdefinition {
	WebDriver driver;
	WebDriverWait wait;
	@Given("user is on the TS homepage")
	public void givenFunctionName() {
		driver=new FirefoxDriver();
		driver.get("https://training-support.net/");
		assertEquals(driver.getTitle(),"Training Support");

	}

	@When("the user clicks on the About Us link")
	public void whenFunctionName() {
		driver.findElement(By.linkText("About Us")).click();
	}

	@Then("they are redirected to another page")
	public void thenFunctionName() {
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//h1"))));
		System.out.println("New page title is "+driver.getTitle());
		assertEquals(driver.getTitle(),"About Training Support");
	}
}
