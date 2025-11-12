import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class SauceDemoTag {
    public static void main(String[] args) {
        //       Create a new instance
        WebDriver driver = new ChromeDriver();

//         Navigate to the website
        driver.get("https://www.saucedemo.com/");
//        Total number of input fields
//        List<WebElement> inputFields = driver.findElements(By.tagName("input"));
//        System.out.println("Total input fields: " + inputFields.size());
//
//        List<WebElement> buttons = driver.findElements(By.tagName("input"));
//        for (WebElement button : buttons) {
//            System.out.println("Button text: " + button.getText());
//        }

        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
    }
}
