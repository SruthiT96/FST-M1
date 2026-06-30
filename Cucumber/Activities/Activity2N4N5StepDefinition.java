package stepDefinitions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Activity2N4N5StepDefinition {
	WebDriver driver;
	WebDriverWait wait;
	@Given("user is on the login homepage")
	public void givenFunctionName() {
		driver=new FirefoxDriver();
		driver.get("https://training-support.net/webelements/login-form");
		assertEquals(driver.getTitle(),"Selenium: Login Form");

	}

	@When("the user enters username and password")
	public void whenFunctionName() {
		driver.findElement(By.xpath("//input[@id=\"username\"]")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@id=\"password\"]")).sendKeys("password");
	}
	@When("the user enters {string} and {string}")
	public void parameterizedata(String uname, String pswrd) {
		driver.findElement(By.xpath("//input[@id=\"username\"]")).sendKeys(uname);
		driver.findElement(By.xpath("//input[@id=\"password\"]")).sendKeys(pswrd);
	}
	
	
	@And("clicks the submit button")
	public void AndFunctionName() {
		driver.findElement(By.xpath("//button[@class=\"svelte-1pdjkmx\"]")).click();
	}

	@Then("get the confirmation message and verify it")
	public void thenFunctionName() {
		String msg=driver.findElement(By.xpath("/html/body/div/main/div/div/div/div/div/h1")).getText();
		assertEquals("Login Success!",msg);
		
        String loginMessage = driver.findElement(By.cssSelector("h2.text-center")).getText();
        assertEquals("Welcome Back, Admin!", loginMessage);
	}
	@Then("get the confirmation text and verify message as {string}")
	public void parameterizeConfirm(String message) {
		String msg=driver.findElement(By.xpath("/html/body/div/main/div/div/div/div/div/h1")).getText();
		assertEquals(message,msg);
		
        String loginMessage = driver.findElement(By.cssSelector("h2.text-center")).getText();
        assertEquals("Welcome Back, Admin!", loginMessage);
	}
	
	@Then("get the confirmation text and verify message as {string}")
    public void confirmMessageAsInput(String expectedMessage) {
        // Find the message
        String message = "NOT FOUND";
        if (expectedMessage.contains("Invalid")) {
            message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h2#subheading"))).getText();
        } else {
            message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h2.mt-5"))).getText();
        }
        // Assert message
        Assertions.assertEquals(expectedMessage, message);
    }
}

