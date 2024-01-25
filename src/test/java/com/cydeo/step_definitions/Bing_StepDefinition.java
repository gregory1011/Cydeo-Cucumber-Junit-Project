package com.cydeo.step_definitions;

import com.cydeo.pages.BingSearchPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;

public class Bing_StepDefinition extends BingSearchPage{


    BingSearchPage bingSearchPage = new BingSearchPage();



    @When("user is on Bing search page")
    public void user_is_on_bing_search_page() {
        // Write code here that turns the phrase above into concrete actions
        Driver.getDriver().get("https://www.bing.com");
    }
    @Then("user should see title is Bing")
    public void user_should_see_title_is_bing() {
        // Write code here that turns the phrase above into concrete actions

        String actualTitle = Driver.getDriver().getTitle();
        //String expectedTitle = "Bing";
        BrowserUtils.verifyTitle("Bing");

    }


    @When("user search for orange")
    public void user_search_for_orange() {
        // Write code here that turns the phrase above into concrete actions
        bingSearchPage.searchBox.sendKeys("orange"+ Keys.ENTER);
    }
    @Then("user should see orange in the title")
    public void user_should_see_orange_in_the_title() {
        // Write code here that turns the phrase above into concrete actions
        BrowserUtils.verifyTitle("orange - Search");

    }


    @When("user enters {word} in the Bing search box")
    public void userEntersTeslaInTheBingSearchBox(String word) {
        bingSearchPage.searchBox.sendKeys(word+ Keys.ENTER);
    }

    @Then("user should see Tesla in the title")
    public void userShouldSeeTeslaInTheTitle() {
        BrowserUtils.verifyTitle("Tesla - Search");
    }

    @When("user enters Toyota Highlander in the Bing search box")
    public void userEntersToyotaHighlanderInTheBingSearchBox() {
        bingSearchPage.searchBox.sendKeys("Toyota Highlander"+ Keys.ENTER);
    }

    @Then("user should see Toyota Highlander in the title")
    public void userShouldSeeToyotaHighlanderInTheTitle() {
        BrowserUtils.verifyTitle("Toyota Highlander - Search");
    }

    @When("user enters {string} in the Bing search box")
    public void userEntersInTheBingSearchBox(String searchKey) {
        bingSearchPage.searchBox.sendKeys(searchKey+Keys.ENTER);
    }

    @Then("user should see {string} in the title")
    public void userShouldSeeInTheTitle(String searchTitle) {
        BrowserUtils.verifyTitle("BMW cars - Search");
    }
}
