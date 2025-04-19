package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import utils.ExcelUtils;

public class LoginSteps {

    LoginPage loginPage = new LoginPage();
    ExcelUtils excelUtils = new ExcelUtils();

    @Given("the user navigates to the login page")
    public void the_user_navigates_to_the_login_page() {
        loginPage.openLoginPage();
    }

    @When("the user enters username {string} and password {string}")
    public void the_user_enters_username_and_password(String username, String password) {
        if (username == null || password == null) {
            throw new IllegalArgumentException("Username or Password cannot be null");
        }
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }
    @When("the user logs in using Excel data row {int}")
    public void the_user_logs_in_using_excel_data_row(Integer rowIndex) {
        String username = excelUtils.getCellData(rowIndex, 0);
        String password = excelUtils.getCellData(rowIndex, 1);

        System.out.println("Username from Excel: " + username);
        System.out.println("Password from Excel: " + password);

        if (username == null || username.trim().isEmpty()) {
            throw new IllegalArgumentException("Username is null or empty at Excel row: " + rowIndex);
        }

        if (password == null || password.trim().isEmpty()) {
            throw new IllegalArgumentException("Password is null or empty at Excel row: " + rowIndex);
        }

        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @Then("the user should be redirected to the dashboard")
    public void the_user_should_be_redirected_to_the_dashboard() {
        loginPage.verifyDashboardPage();
    }
}