import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverInfo;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class The50Project {
    public static void main (String[] args) {
//        Create new instance
        WebDriver driver = new ChromeDriver();

        driver.get("https://itstartswith50.com/");

        driver.findElement(By.cssSelector("a[href*='Inquiry']")).click();

        String title = driver.getTitle();
        if (title.contains("Project")) {
            System.out.println("Header Test Passed");
        } else {
            System.out.println("Header Test Failed");
        }
    }
}
