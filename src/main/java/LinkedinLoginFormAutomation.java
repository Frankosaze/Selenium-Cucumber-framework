import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinkedinLoginFormAutomation {
    public static void main (String [] args) {
//        Create a new instance
        WebDriver driver = new ChromeDriver();

//        Navigate to the web page and click on the signin page
        driver.get("https://www.linkedin.com/");
        driver.findElement(By.cssSelector("a[href*='login']")).click();

//        Locate the username and password element by ID
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));

//        Locate the login button by name
        WebElement loginButton = driver.findElement(By.cssSelector("button.btn__primary--large.from__button--floating"));

//        input username and password
        usernameField.sendKeys("fredanfianko@gmail.com");
        passwordField.sendKeys("Fred@629");

//        login to the page
        loginButton.click();

//        Verify if the login is Successful
        WebElement pageElement = driver.findElement(By.xpath("//input[@aria-label='Search']"));
        if (pageElement.isDisplayed()) {
            System.out.println("Login Successful");
        } else {
            System.out.println("Login Failed");
        }
    }
}
