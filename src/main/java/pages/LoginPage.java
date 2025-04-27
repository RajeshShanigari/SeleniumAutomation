package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.DriverFactory;

public class LoginPage {

    WebDriver driver = DriverFactory.getDriver();

    // Locators
    private final By usernameField = By.name("username");
    private final By passwordField = By.name("password");
    private final By loginButton = By.cssSelector("button[type='submit']");
    private final By dashboardHeader = By.xpath("//h6[text()='Dashboard']");

    //Locators using FindBy annotation
//    @FindBy(name = "username")
//    private WebElement usernameField;
//
//    @FindBy(name = "password")
//    private WebElement passwordField;
//
//    @FindBy(css = "button[type='submit']")
//    private WebElement loginButton;
//
//    @FindBy(xpath = "//h6[text()='Dashboard']")
//    private  WebElement dashboardHeader;
//
//    @FindBy(css = "p.oxd-text.oxd-alert-content-text")
//    private WebElement errorMessage;


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
    }

    public DashboardPage clickLogin() {
        WebElement login = driver.findElement(loginButton);
        login.click();
        return new DashboardPage(driver);
    }
    public void verifyDashboardPage() {
        boolean isDashboardVisible = driver.findElement(dashboardHeader).isDisplayed();
        if (!isDashboardVisible) {
            throw new AssertionError("Dashboard not displayed after login.");
        }
    }
}