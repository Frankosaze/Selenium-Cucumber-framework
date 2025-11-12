# Selenium + Cucumber BDD Automation Testing Framework

![Maven Build](https://github.com/Frankosaze/Selenium-Cucumber-framework/actions/workflows/Maven-ci.yml/badge.svg)

![Selenium](https://img.shields.io/badge/Selenium-WebDriver-pink?logo=selenium)
![Selenium](https://img.shields.io/badge/Selenium-Automation-success?logo=selenium)
![Cucumber](https://img.shields.io/badge/Cucumber-BDD-blueviolet?logo=cucumber)
![Maven](https://img.shields.io/badge/Maven-Build%20Tool-yellow?logo=apachemaven)
![Java](https://img.shields.io/badge/Java-Programming-blue?logo=openjdk)
![Gherkin](https://img.shields.io/badge/Gherkin-Feature%20Files%20%26%20Readable%20Text-orange)
![Jenkins](https://img.shields.io/badge/Jenkins-CI%2FCD-green?logo=jenkins)
![JUnit](https://img.shields.io/badge/JUnit-Test%20Runner-red?logo=junit5)
![Status](https://img.shields.io/badge/Status-Active-blue)

A **scalable UI Test Automation Framework** built using **Selenium WebDriver + Cucumber BDD + JUnit**, developed to demonstrate clean automation architecture and real-world testing practices.  
This framework supports **behavior-driven testing**, **POM structure**, and is fully **CI/CD ready** with Jenkins pipeline execution and **Maven Surefire reporting**.

---

## 🎯 Purpose of This Framework

The goal of this framework is to:

- Provide **clear and maintainable UI automated tests**
- Enable collaboration through **readable Gherkin scenarios**
- Demonstrate **Page Object Model (POM)** design patterns
- Support **continuous testing** with Jenkins CI/CD
- Produce **high-quality test execution reports** via Maven Surefire

---

## 🏗️ Framework Architecture

                         ┌─────────────────────────┐
                         │       Feature Files     │
                         │   (.feature - Gherkin)  │
                         └────────────┬────────────┘
                                      │
                                      ▼
                         ┌─────────────────────────┐
                         │     Step Definitions    │
                         │  (Glue Code - Java)     │
                         └────────────┬────────────┘
                                      │Calls
                                      ▼
                         ┌─────────────────────────┐
                         │       Page Objects      │
                         │ (Element locators + UI  │
                         │   interaction methods)  │
                         └────────────┬────────────┘
                                      │Uses
                                      ▼
                         ┌─────────────────────────┐
                         │    Selenium WebDriver   │
                         │  (Browser Automation)   │
                         └────────────┬────────────┘
                                      │Managed By
                                      ▼
                         ┌─────────────────────────┐
                         │        Test Runner      │
                         │  (Cucumber + JUnit)     │
                         └────────────┬────────────┘
                                      │Supports
                                      ▼
                         ┌─────────────────────────┐
                         │       Reporting         │
                         │  (Maven surefire report)│
                         └─────────────────────────┘

This layered structure ensures the framework remains:

✅ Maintainable  
✅ Extensible  
✅ Scalable  

---

## 🧠 Tech Stack Overview

| Component | Technology | Purpose |
|----------|------------|---------|
| Language | Java | Core implementation |
| UI Automation | Selenium WebDriver | Browser interaction |
| BDD Framework | Cucumber JVM | Behavior-Driven Testing |
| Test Syntax | Gherkin | Human-readable test scenarios |
| Test Runner | JUnit | Scenario execution |
| Build Tool | Maven | Dependency + test lifecycle |
| CI/CD | Jenkins | Automated pipeline execution |
| Reporting | Maven Surefire Report | HTML test reporting |

---

## 📁 Project Structure
Osazeseleniumframework
```
┣ src/main/java
┃ ┗ Pages
┣ src/test/java
┃ ┣ StepDefinitions (glue code)
┃ ┗ Runner/ # JUnit Test Runner
┣ src/test/resources
┃ ┣ feature (Gherkin feature files)
┣ pom.xml (Dependencies & plugins)

```

## 🧩 Example Feature File (Gherkin)
```gherkin
Feature: Login Functionality

  Scenario: Successful login with valid credentials
    Given user is on the login page
    When user enter a valid username and password
    And user click the login button
    Then user should be redirected to the products page

```

## 🧩 Example Step Definition
```java
package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginSteps {
    WebDriver driver;

    @Given("user is on the login page")
    public void userIsOnLoginPage() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
    }

    @When("user enters valid username and password")
    public void userEntersValidCredentials() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @And("user clicks the login button")
    public void userClicksLoginButton() {
        driver.findElement(By.id("login-button")).click();
    }

    @Then("user should be redirected to the products page")
    public void userShouldBeRedirectedToProductsPage() {
        boolean isProductsDisplayed = driver.findElement(By.className("title")).isDisplayed();
        assert isProductsDisplayed;
    }
}

```

## 🚀 Future Enhancements
The following improvements are planned to make the framework  more robust:
| Enhancement                 | Benefit                       |
| --------------------------- | ----------------------------- |
| Parallel execution          | Faster regression cycles      |
| Cross-browser testing       | Chrome, Firefox, Edge support |
| Extent Reports integration  | Alternative reporting UI      |
| Screen recording on failure | Better debugging support      |


## 👨‍💻 Author

**Frank Osaze**  
Software QA / Test Engineer  
GitHub: https://github.com/Frankosaze  
Email: frankosazei@gmail.com
