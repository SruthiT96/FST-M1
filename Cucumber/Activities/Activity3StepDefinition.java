package stepDefinitions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Activity3StepDefinition {
	Alert alert;
	WebDriver driver;
	WebDriverWait wait;
	@Given("User is on the page")
	public void givenFunctionName() {
		driver=new FirefoxDriver();
		driver.get("https://training-support.net/webelements/alerts");
		assertEquals(driver.getTitle(),"Selenium: Alerts");

	}

	@When("User clicks the Simple Alert button")
	public void whenFunctionNameSimple() {
		driver.findElement(By.id("simple")).click();
	}
	@When("User clicks the Confirm Alert button")
	public void whenFunctionNameConfirm() {
		driver.findElement(By.id("confirmation")).click();
	}
	@When("User clicks the Prompt Alert button")
	public void whenFunctionNamePrompt() {
		driver.findElement(By.id("prompt")).click();
	}

	@Then("Alert opens")
	public void thenFunctionName() {
		alert = driver.switchTo().alert();
	}	
	
	@And("Read the text from it and print it")
	public void readText() {
		System.out.println("alert has: "+alert.getText());
	}

	@And("Close the alert")
	public void closeAlert() {
		driver.switchTo().alert().accept();
	}
	@And("Close the alert with Cancel")
	public void closeAlertWithCancel() {
		driver.switchTo().alert().dismiss();
	}
	
	@And("Write a custom message in it")
	public void writetoAlert() {
		driver.switchTo().alert().sendKeys("wriring into alert");
	}
	
	@And("Read the result text")
	public void readResultText() {
		System.out.println(driver.findElement(By.xpath("//p[@id, 'result']")).getText());
	}
}
