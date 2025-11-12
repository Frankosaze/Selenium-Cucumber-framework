import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class WebElementExercise {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.saucedemo.com");

//        Find the webelements
        WebElement usernameField = driver.findElement(By.id("user-name"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));

//        Login
        usernameField.sendKeys("standard_user");
        passwordField.sendKeys("secret_sauce");
        loginButton.click();


//      Using explicit Wait to confirm the product page has loaded
        WebElement productsTitle = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.className("title"))
        );
        System.out.println("Page Title: " + productsTitle.getText());

//      Using fluent wait to find and click the shopping cart icon.
//
        Wait<WebDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))     // total wait time
                .pollingEvery(Duration.ofSeconds(5))     // check every 5 seconds
                .ignoring(NoSuchElementException.class); // ignore errors while waiting
//
        WebElement cartIcon = fluentWait.until( d->
                driver.findElement(By.className("shopping_cart_link"))
        )                               ;

        cartIcon.click();


    }
}
