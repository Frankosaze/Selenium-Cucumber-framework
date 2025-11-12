import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchExercise {
    public static void main (String[] args) {
        // Create a new instance
        WebDriver driver = new ChromeDriver();

        // Navigate to the website
        driver.get("https://www.google.com/");

        // Locate search element by name
        WebElement searchField = driver.findElement(By.name("q"));

        // Search for selenium driver
        searchField.sendKeys("Selenium Driver");

        // submit search
        searchField.submit();

        // verify the result is correct
        String title = driver.getTitle();
        if (title.contains("Selenium")) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }
    }
}
