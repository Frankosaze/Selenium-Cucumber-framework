import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

    public class SeleniumTest {
        public static void main(String[] args) {
            // Create a new ChromeDriver instance (Selenium Manager handles driver)
            WebDriver driver = new ChromeDriver();
            // Navigate to a website
            driver.get("https://www.saucedemo.com/");

            // Find the search box and perform a search
            WebElement searchBox = driver.findElement(By.name("q"));
            searchBox.sendKeys("Selenium");
            searchBox.submit();

            // Verify the page title
            String title = driver.getTitle();
            if (title.contains("Selenium")) {
                System.out.println("Test Passed");
            } else {
                System.out.println("Test Failed");
            }
            // Close the browser
            driver.quit();
        }
    }

