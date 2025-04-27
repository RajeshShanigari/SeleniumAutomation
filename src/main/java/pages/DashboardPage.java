package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
    private final WebDriver driver;

    @FindBy(tagName = "h6")
    private WebElement dashboardHeader;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getDashboardHeaderText() {
        return dashboardHeader.getText();
    }

    public boolean isDashboardDisplayed() {
        return dashboardHeader.isDisplayed() && dashboardHeader.getText().contains("Dashboard");
    }
}