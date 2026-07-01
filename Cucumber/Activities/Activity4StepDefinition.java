package stepDefinitions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.By;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Activity4StepDefinition extends BaseClass{
	@Given("user is on the login homepage")
	public void loginHomepage() {
		driver.get("https://training-support.net/webelements/login-form");
		assertEquals(driver.getTitle(),"Selenium: Login Form");

	}

	@When("the user enters username and password")
	public void enterUnameNPassword() {
		driver.findElement(By.xpath("//input[@id=\"username\"]")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@id=\"password\"]")).sendKeys("password");
	}
	
	@And("clicks the submit button")
	public void clickOnSubmit() {
		driver.findElement(By.xpath("//button[@class=\"svelte-1pdjkmx\"]")).click();
	}

	@When("the user enters {string} and {string}")
	public void parameterizedata(String uname, String pswrd) {
		driver.findElement(By.xpath("//input[@id=\"username\"]")).sendKeys(uname);
		driver.findElement(By.xpath("//input[@id=\"password\"]")).sendKeys(pswrd);
	}
	@Then("get the confirmation text and verify message as {string}")
	public void parameterizeConfirmMsg(String message) {
		String msg=driver.findElement(By.xpath("/html/body/div/main/div/div/div/div/div/h1")).getText();
		assertEquals(message,msg);
		
        String loginMessage = driver.findElement(By.cssSelector("h2.text-center")).getText();
        assertEquals("Welcome Back, Admin!", loginMessage);
        driver.quit();

	}
}
