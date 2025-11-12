package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class OrangeHRM {

    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void setUp() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        if (System.getenv("CI") != null) {
            options.addArguments("--headless=new", "--no-sandbox", "--disable-dev-shm-usage");
        }
        driver = new ChromeDriver(options);
        driver.manage().window().maximize(); // To maximize the web browser
        wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // an instruction to telling the webdriver to wait for some seconds

    }

    @Given("the user is on the login page")
    public void theUserIsOnTheLoginPage() {
        driver.get("https://opensource-demo.orangehrmlive.com/"); // Getting into the webpage
    }

    @When("the user input valid username")
    public void theUserInputValidUsername() {
        WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username"))); // finding the username input field
        username.sendKeys("Admin"); // inputting the username
    }

    @And("the user input valid password")
    public void theUserInputValidPassword() {
        WebElement password = driver.findElement(By.name("password")); // finding the password input
        password.sendKeys("admin123"); // inputting the password
    }

    @And("the user clicks on login")
    public void theUserClicksOnLogin() {
        WebElement loginBtn = driver.findElement(By.cssSelector("button.oxd-button.oxd-button--main.orangehrm-login-button")); //finding the login button input field
        loginBtn.click(); // click login button
    }

    @When("the user clicks on recruitment")
    public void theUserClicksOnRecruitment() {
        WebElement recruitmentTab = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Recruitment']"))); // Navigating into the recruitment page
        recruitmentTab.click(); //Click the recruitment
    }

    @And("the user clicks on add")
    public void theUserClicksOnAdd() {
        WebElement addButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()=' Add ']"))); // finding the add button
        addButton.click(); // Clicking the add button
    }

    @And("the user input a candidate details")
    public void theUserInputACandidateDetails() {
        WebElement firstName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("firstName"))); // Finding the FirstName file
        firstName.sendKeys("Frank");

        WebElement lastName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("lastName")));
        lastName.sendKeys("Osaze");

        WebElement vacancyDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("i.oxd-icon.bi-caret-down-fill.oxd-select-text--arrow")));
        vacancyDropdown.click();

        WebElement seniorQAOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@role='option']//span[text()='Senior QA Lead']")));
        seniorQAOption.click();

        WebElement email = driver.findElement(By.cssSelector("input.oxd-input.oxd-input--active[placeholder='Type here']"));
        email.sendKeys("frankosaze@example.com");

        WebElement contactNumber = driver.findElement(By.cssSelector("input.oxd-input.oxd-input--active[placeholder='Type here']"));
        contactNumber.sendKeys("07050323105");

        WebElement keywordInput = driver.findElement(By.xpath("//input[@placeholder='Enter comma seperated words...']"));
        keywordInput.sendKeys("QA-Automation");

        WebElement noteInput = driver.findElement(By.cssSelector("textarea[placeholder='Type here']"));
        noteInput.sendKeys("Candidate has 4 years of QA experience, working for Tech, Finance, and Marketing Sector");
    }

    @And("the user consent the data and save")
    public void theUserConsentTheDataAndSave() {
        WebElement consentCheckbox = driver.findElement(By.cssSelector("span.oxd-checkbox-input.oxd-checkbox-input--active.--label-right"));
        consentCheckbox.click();
    WebElement save = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()=' Save ']")));
        save.click();
    }

    @And("the user shortlist the candidate")
    public void theUserShortlistTheCandidate() {
        WebElement shortlist = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.oxd-button.oxd-button--medium.oxd-button--success")));
        shortlist.click();
    }

    @And("the user adds note")
    public void theUserAddsNote() {
        WebElement note = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("textarea.oxd-textarea.oxd-textarea--active[placeholder='Type here']")));
        note.sendKeys("Candidate's profile looks good. Screening already conducted, kindly schedule candidate for first interview");
    }

    @And("the user clicks save")
    public void theUserClicksSave() {
        WebElement finalSave = driver.findElement(By.cssSelector("button.oxd-button.oxd-button--medium.oxd-button--secondary.orangehrm-left-space"));
        finalSave.click();
    }

    @Then("the user should get a success message")
    public void theUserShouldGetASuccessMessage() {
        System.out.println("Candidate application successful");
    }
}