package com.cydeo.step_definitions;

import com.cydeo.pages.GoogleSearchPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class Google_StepDefinitions {


    GoogleSearchPage googleSearchPage = new GoogleSearchPage();




    @When("user search for Apple")
    public void user_search_for_apple() {
        googleSearchPage.searchBox.sendKeys("Apple"+ Keys.ENTER);
    }
    @Then("user should see Apple in the title")
    public void user_should_see_apple_in_the_title() {
        BrowserUtils.verifyTitle("Apple - Google Search");
    }



    @When("user is on Google search page")
    public void user_is_on_google_search_page() {

        Driver.getDriver().get("https://www.google.com");
    }

    @Then("user should see title is Google")
    public void user_should_see_title_is_google() {

        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "Google";

        Assert.assertEquals(actualTitle, expectedTitle);


    }

}