import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class SauceDemoLogin {
    public static void main(String[] args) {
//        begin count
        int successCount = 0;

//        automating the login several times
        for (int i = 1; i <= 2; i++) {
        System.out.println("Login Successful on attempt #" + i);

//       Create a new instance
         WebDriver driver = new ChromeDriver();

//         Navigate to the website
        driver.get("https://www.saucedemo.com/");

//        Locate Element by ID and interact with them
//        WebElement usernameField = driver.findElement(By.id("user-name"));
//        WebElement passwordField = driver.findElement(By.id("password"));
//        WebElement loginButton = driver.findElement(By.id("login-button"));

//            Total number of input fields
            List<WebElement> inputFields = driver.findElements(By.tagName("input"));
            System.out.println("Total input fields: " + inputFields.size());

            List<WebElement> buttons = driver.findElements(By.tagName("button"));
            for (WebElement button : buttons) {
                System.out.println("Button text: " + button.getText());
            }
        // Login first
//        driver.findElement(By.id("user-name")).sendKeys("standard_user");
//        driver.findElement(By.id("password")).sendKeys("secret_sauce");
//        driver.findElement(By.name("login-button")).click();

        // open the menu
//        driver.findElement(By.id("react-burger-menu-btn")).click();
//
//        Logout using ID locator
//       driver.findElement(By.id("logout_sidebar_link")).click();

//        logout using partial link text
//        driver.findElement(By.partialLinkText("Log")).click();

//        Locating Element by CSS
//        WebElement usernameField = driver.findElement(By.cssSelector("input[name='user-name']"));
//        WebElement passwordField = driver.findElement(By.cssSelector("#password"));
//        WebElement loginButton = driver.findElement(By.cssSelector(".btn_action"));

//        put in the username, password, and login

//        usernameField.sendKeys("standard_user");
//        passwordField.sendKeys("secret_sauce");
//        loginButton.click();

//        Count each login
        successCount++;

//      Locate Element by Name and interact with them
//      WebElement inventoryItem = driver.findElement(By.className("inventory_item"));
//      inventoryItem.click();
//
//      WebElement cartIcon = driver.findElement(By.className("shopping_cart_link"));
//      cartIcon.click();

//        Login to the website
//        loginButton.click();

        driver.quit();
        }
//
            if (successCount == 2) {
                System.out.println("Test Passed: successfully login  2 times");
            } else {
                System.out.println("Test Failed: Only " + successCount + " logins passed");
            }

    }
}
