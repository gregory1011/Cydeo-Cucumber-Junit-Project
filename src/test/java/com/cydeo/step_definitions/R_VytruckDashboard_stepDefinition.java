package com.cydeo.step_definitions;

import com.cydeo.pages.R_VytrackDashboardPage;
import com.cydeo.pages.R_VytrackLoginPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.rules.ExpectedException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class R_VytruckDashboard_stepDefinition {

    R_VytrackDashboardPage vytrackDashboardPage = new R_VytrackDashboardPage();
    R_VytrackLoginPage vytrackLoginPage = new R_VytrackLoginPage();

    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(4));

    @Then("user should be able to see following modules")
    public void user_should_be_able_to_see_following_modules(List<String> expectedModules) {

        BrowserUtils.sleep(4);
        List<String> actualModules = new ArrayList<>();

        for (WebElement eachModule : vytrackDashboardPage.allTopModules){
            actualModules.add(eachModule.getText());
        }

        Assert.assertEquals(expectedModules, actualModules);
    }


    @When("user enters below credentials")
    public void user_enters_below_credentials(Map<String, String> credentials) {

        String username = credentials.get("username");
        String password = credentials.get("password");
        vytrackLoginPage.login(username, password);
    }


    @Then("user should be able to see following information")
    public void user_should_be_able_to_see_following_information(Map<String, String> userInfo) {

       // BrowserUtils.sleep(4);

        wait.until(ExpectedConditions.visibilityOf(vytrackDashboardPage.userinfo));
        String actualUserInfo = vytrackDashboardPage.userinfo.getText();


        String expectedUserInfo = userInfo.get("firstname")+" "+userInfo.get("lastname");

        Assert.assertEquals(expectedUserInfo, actualUserInfo);


    }




}
