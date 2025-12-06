package com.example.stepdefs;

import com.example.pages.LoginPage;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class LoginSteps {
    private WebDriver driver = Hooks.getDriver();
    private LoginPage loginPage = new LoginPage(driver);

    @Given("the user navigates to the login page")
    public void the_user_navigates_to_the_login_page() {
        loginPage.open();
    }

    @When("the user enters username {string} and password {string}")
    public void the_user_enters_username_and_password(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
    }

    @Then("the user should be successfully logged in and see the Secure Area page")
    public void checkSecureArea() {
        Assert.assertTrue(loginPage.isSecureAreaVisible());
    }

    @Then("the user should see an error message {string}")
    public void wrongMessage(String expected) {
        Assert.assertTrue(loginPage.getFlashText().contains(expected));
    }

    @Then("the user should see {string} for both fields")
    public void emptyFields(String expected) {
        Assert.assertTrue(loginPage.getFlashText().contains(expected));
    }
}
