package com.cydeo.step_definitions;

import com.cydeo.pages.WOA_LibraryDashboardPage;
import com.cydeo.pages.WOA_LibraryLoginPage;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WOA_LibraryLogin_stepDefinition {


    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

    WOA_LibraryLoginPage loginPage = new WOA_LibraryLoginPage();

    WOA_LibraryDashboardPage dashboardPage = new WOA_LibraryDashboardPage();

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {

        Driver.getDriver().get(ConfigurationReader.getProperty("qa2_url"));
    }

    @When("I login as a librarian")
    public void i_login_as_a_librarian() {

          // TO AVOID HARD CODING WE ARE USING METHOD " loginAsLibrarian() "
//        loginPage.emailInput.sendKeys(ConfigurationReader.getProperty("lib22_user"));
//        loginPage.passwordInput.sendKeys(ConfigurationReader.getProperty("lib22_pass"));
//        loginPage.signInBtn.click();

        // loginAsLibrarian() --> this method comes from LibraryLoginPage
       // loginPage.loginAsLibrarian(); or this method without parameters
        loginPage.loginAsLibrarian(ConfigurationReader.getProperty("lib22_user"),
                                  ConfigurationReader.getProperty("lib22_pass"));
    }

    @Then("dashboard should be displayed")
    public void dashboard_should_be_displayed() {

        String expectedURL = "dashboard";
        wait.until(ExpectedConditions.urlContains(expectedURL));
        String actualURl = Driver.getDriver().getCurrentUrl();


        Assert.assertTrue(actualURl.contains(expectedURL));

    }


    @When("I enter username {string}")
    public void i_enter_username(String email) {

        loginPage.emailInput.sendKeys(email);
    }
    @When("I enter password {string}")
    public void i_enter_password(String password) {

        loginPage.passwordInput.sendKeys(password);
    }

    @When("click the sign in button")
    public void click_the_sign_in_button() {

        loginPage.signInBtn.click();
    }
    @When("there should be {int} users")
    public void there_should_be_users(Integer userNum) {

       // String expectedUserCount = ""+userNum;
        String expectedUserCount =String.valueOf(userNum);
        wait.until(ExpectedConditions.invisibilityOf(dashboardPage.usersAmount));
        String actualUserCount = dashboardPage.usersAmount.getText();

        Assert.assertEquals(expectedUserCount, actualUserCount);


    }


    @When("I login using {string} and {string}")
    public void i_login_using_and(String email, String password) {

       loginPage.loginAsLibrarian(email, password);
    }
    @Then("account holder name should be {string}")
    public void account_holder_name_should_be(String expectedAccountName) {

        wait.until(ExpectedConditions.invisibilityOf(dashboardPage.usernameLink));
        String actualAccountName = dashboardPage.usernameLink.getText();

        Assert.assertEquals(expectedAccountName, actualAccountName);

    }







}
