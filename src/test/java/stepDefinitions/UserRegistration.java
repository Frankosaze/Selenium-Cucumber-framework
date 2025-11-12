package stepDefinitions;

import ghBase.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserRegistration {
    WebDriver driver;

    @Given("The user is on the registration page")
    public void TheUserIsOnTheRegistrationPage() {
        driver = DriverManager.createDriver();
        driver.get("https://www.sportybet.com/ng/");
    }

    @When("The user enters valid registration details")
    public void TheUserEntersValidRegistrationDetails() {
        driver.findElement(By.name("phone")).sendKeys("8133231280");
        driver.findElement(By.name("psd")).sendKeys("Trial101");
        driver.findElement(By.xpath("//button[text()='Register']")).click();
    }

    @Then("The user should be registered successfully")
    public void TheUserShouldBeRegisteredSuccessfully() {
        System.out.println("Registration successful");
//        driver.quit():
    }
}
