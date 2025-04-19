package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.DriverFactory;

public class LoginPage {

    WebDriver driver = DriverFactory.getDriver();

    // Locators
    private By usernameField = By.name("username");
    private By passwordField = By.name("password");
    private By loginButton = By.cssSelector("button[type='submit']");
    private By dashboardHeader = By.xpath("//h6[text()='Dashboard']");

    // Actions
    public void openLoginPage() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    public void enterUsername(String username) {
        WebElement userField = driver.findElement(usernameField);
        userField.clear();
        userField.sendKeys(username);
    }

    public void enterPassword(String password) {
        WebElement passField = driver.findElement(passwordField);
        passField.clear();
        passField.sendKeys(password);
        driver.findElement(loginButton).click();
    }

    public void verifyDashboardPage() {
        boolean isDashboardVisible = driver.findElement(dashboardHeader).isDisplayed();
        if (!isDashboardVisible) {
            throw new AssertionError("Dashboard not displayed after login.");
        }
    }
}