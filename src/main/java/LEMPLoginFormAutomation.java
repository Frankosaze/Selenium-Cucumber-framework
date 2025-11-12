import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LEMPLoginFormAutomation {
    public static void main (String[] args) {
//        Create a new instance
        WebDriver driver = new ChromeDriver();

//        Navigate to the website
        driver.get("https://www.lyfebiteslemp.com/account/my-account");

//        Navigate to email login page
        WebElement emailButton = driver.findElement(By.xpath("//button[@data-testid='buttonElement']"));

        emailButton.click();

//        Locate username and password elements using ID
        WebElement usernameField = driver.findElement(By.id("input_input_emailInput_SM_ROOT_COMP1162"));
        WebElement passwordField = driver.findElement(By.id("input_input_passwordInput_SM_ROOT_COMP1162"));

//        Locate the login element using name
        WebElement loginButton = driver.findElement(By.id("okButton_SM_ROOT_COMP880"));

//        Enter the username and password
        usernameField.sendKeys("frankosazei@gmail.com");
        passwordField.sendKeys("trialtrial");

//        Login to the page
        loginButton.click();

//        Verify successful login
        WebElement pageField = driver.findElement(By.id("input_emailInput_SM_ROOT_COMP568"));
        if (pageField.isDisplayed()) {
            System.out.println("Login Successful");
        } else {
            System.out.println("Login Failed");
        }
    }
}
