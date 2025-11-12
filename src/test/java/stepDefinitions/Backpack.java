package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Backpack {
    WebDriver driver;

    @Given("The user is on the homepage")
    public void TheUserIsOnTheHomepage() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        if (System.getenv("CI") != null) {
            options.addArguments("--headless=new", "--no-sandbox", "--disable-dev-shm-usage");
        }
        driver = new ChromeDriver(options);
        driver.get("https://www.saucedemo.com/");
    }

    @When("The user enters username")
    public void TheUserEntersUsername() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }

    @And("The user enters password")
    public void TheUserEntersPassword() {
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @Then("The user click on the login button")
    public void TheUserClicksOnTheLoginButton() {
        driver.findElement(By.name("login-button")).click();
    }

    @Then("The user should see the inventory items")
    public void TheUserShouldSeeTheInventoryItems(){
        boolean isLogoDisplayed = driver.findElement(By.className("app_logo")).isDisplayed();
        assert isLogoDisplayed;
    }

    @Then("The user select the backpack item")
    public void TheUserSelectTheBackpackItem() {
        driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']")).click();
    }

    @And("The user adds the item to cart")
    public void TheUserAddsTheItemToCart() {
        driver.findElement(By.id("add-to-cart")).click();
    }

    @Then("The user navigates to the shopping cart")
    public void TheUserNavigatesToTheShoppingCart() {
        driver.findElement(By.className("shopping_cart_link")).click();
    }

    @And("The user proceed to checkout")
    public void TheUserProceedToCheckout() {
        driver.findElement(By.id("checkout")).click();
    }

    @Then("The user provides valid credentials")
    public void TheUserProvidesValidCredentials() {
        driver.findElement(By.id("first-name")).sendKeys("Frank");
        driver.findElement(By.id("last-name")).sendKeys("Osaze");
        driver.findElement(By.id("postal-code")).sendKeys("302034");
    }

    @And("The user click on continue")
    public void TheUserClickOnContinue() {
        driver.findElement(By.id("continue")).click();
    }

    @And("The user click on finish")
    public void TheUserClickOnFinish() {
        driver.findElement(By.id("finish")).click();
    }

    @Then("The user should see a success message")
    public void TheUserShouldSeeASuccessMessage() {
        System.out.println("Order has been placed successfully");
    }

//        driver.quit():
}

