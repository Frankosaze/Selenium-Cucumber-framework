package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Shopping {
    WebDriver driver;

    @Given("The user is on a new browser")

    public void theUserIsOnANewBrowser() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        if (System.getenv("CI") != null) {
            options.addArguments("--headless=new", "--no-sandbox", "--disable-dev-shm-usage");
        }
        driver = new ChromeDriver(options);

    }

    @And("The user navigates to the website")
    public void theUserNavigatesToTheWebsite() {
        driver.get("https://www.saucedemo.com/");
    }

    @When("The user enters valid username")
    public void  theUserEntersValidUsername() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }

    @And("The user enters valid password")
    public void theUserEntersValidPassword() {
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @And("The user clicks on the login button")
    public void theUserClicksOnTheLoginButton() {
        driver.findElement(By.name("login-button")).click();
    }

    @Then("The user should see the products page")
    public void theUserShouldSeeTheProductPage () {
        boolean isLogoDisplayed = driver.findElement(By.className("app_logo")).isDisplayed();
        assert isLogoDisplayed;
    }

    @When("The user sorts the items by Price low to high")
    public void theUserSortsTheItemsByPriceLowToHigh() {
        driver.findElement(By.cssSelector("[data-test='product-sort-container']")).click();
        Select sortDropdown = new Select(driver.findElement(By.cssSelector("[data-test='product-sort-container']")));
        sortDropdown.selectByVisibleText("Price (low to high)");
    }

    @And("The user selects the bike light item")
    public void theUserSelectsTheBikeLightItem() {
        driver.findElement(By.xpath("//div[text()='Sauce Labs Bike Light']")).click();
    }

    @And("The user adds the bike light item to cart")
    public void theUserAddsTheBikeLightItemToCart() {
        driver.findElement(By.id("add-to-cart")).click();
    }

    @And("The user goes back to the inventory items page")
    public void theUserGoesBackToTheInventoryItemsPage() {
        driver.findElement(By.id("back-to-products")).click();
    }

    @And("The user selects the fleece jacket")
    public void theUserSelectsTheFleeceJacket() {
        driver.findElement(By.xpath("//div[text()='Sauce Labs Fleece Jacket']")).click();
    }

    @And("The user adds the fleece jacket to cart")
    public void TheUserAddsTheFleeceJacketToCart() {
        driver.findElement(By.id("add-to-cart")).click();
    }

    @And("The user navigates into the shopping cart")
    public void theUserNavigatesIntoTheShoppingCart() {
        driver.findElement(By.className("shopping_cart_link")).click();
    }

    @And("The user remove fleece jacket from the cart")
    public void theUserRemoveFleeceJacketFromTheCart() {
        driver.findElement(By.id("remove-sauce-labs-fleece-jacket")).click();
    }

    @And("The user selects All Items")
    public void theUserSelectsAllItems() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

        wait.until(ExpectedConditions.elementToBeClickable(By.id("react-burger-menu-btn"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.id("inventory_sidebar_link"))).click();
    }

    @Then("The user should be redirected to the products page")
    public void theUserShouldBeRedirectedToTheProductsPage() {
        String pageTitle = driver.findElement(By.className("title")).getText();
        Assert.assertEquals("Products", pageTitle);
    }

    @When("The user navigates back into the shopping cart")
    public void theUserNavigatesBackToTheShoppingCart() {
        driver.findElement(By.className("shopping_cart_link")).click();
    }

    @And("The user proceeds to checkout")
    public void theUserProceedToCheckout() {
        driver.findElement(By.id("checkout")).click();
    }

    @And("The user enters valid credentials")
    public void TheUserEntersValidCredentials() {
        driver.findElement(By.id("first-name")).sendKeys("Frank");
        driver.findElement(By.id("last-name")).sendKeys("Osaze");
        driver.findElement(By.id("postal-code")).sendKeys("302034");
    }

    @And("The user clicks on continue")
    public void TheUserClicksOnContinue() {
        driver.findElement(By.id("continue")).click();
    }

    @And("The user verifies the tax is $0.80")
    public void TheUserVerifiesTheTaxIs_$0_80() {
        String actualTax = driver.findElement(By.className("summary_tax_label")).getText();
        Assert.assertEquals("Tax: $0.80", actualTax);
        System.out.println("Tax Displayed and Correct: " + actualTax);
    }

    @And("The user clicks on finish")
    public void TheUserClicksOnFinish() {
        driver.findElement(By.id("finish")).click();
    }

    @Then("The user should be shown a success message")
    public void TheUserShouldSeeASuccessMessage() {
        System.out.println("Thank you for your order! Your order has been dispatched, and will arrive just as fast as the pony can get there!");
    }
}
