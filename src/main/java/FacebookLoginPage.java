import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FacebookLoginPage {
    public static void main (String[] args) {
//        Create New Instance
        WebDriver driver = new ChromeDriver();

//        Navigate to the webpage
        driver.get("https://www.facebook.com/");

//        Reset Password with linktext
//        driver.findElement(By.cssSelector("a[href*='recover']")).click();

//        Reset Password with Partial linktext
//        driver.findElement(By.partialLinkText("Forgot")).click();

//        Enter Email and Password
        driver.findElement(By.id("email")).sendKeys("justfortest@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("notcorrect");

//        Login
        driver.findElement(By.name("login")).click();

//        Print Error message
        WebElement errorMessage = driver.findElement(By.cssSelector("div._9ay7"));
        System.out.println("errorMessage: " + errorMessage.getText());
    }
}
