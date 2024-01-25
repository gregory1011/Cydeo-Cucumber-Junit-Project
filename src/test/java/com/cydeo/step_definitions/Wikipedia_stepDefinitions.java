package com.cydeo.step_definitions;

import com.cydeo.pages.WikiResultPage;
import com.cydeo.pages.WikipediaSearchPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Wikipedia_stepDefinitions {

    WikipediaSearchPage wikipediaSearchPage = new WikipediaSearchPage();


    @Given("User is on Wikipedia page")
    public void user_is_on_wikipedia_page() {
        Driver.getDriver().get("https://www.wikipedia.org/");
    }
    @When("User enters {string} in search box")
    public void user_enters_in_search_box(String str) {
        wikipediaSearchPage.searchBox.sendKeys(str);
    }
    @When("User clicks wiki search button")
    public void user_clicks_wiki_search_button() {
        wikipediaSearchPage.searchBtn.click();
    }
    @Then("User should see {string} in the tile")
    public void user_should_see_in_the_tile(String expectedResult) {
        BrowserUtils.verifyTitleContains(expectedResult);
    }


    WikiResultPage wikiResultPage = new WikiResultPage();

    @Then("User should see {string} in main header")
    public void userShouldSeeInMainHeader(String expectedText) {

        String actualHeaderText = wikiResultPage.mainHeader.getText();

        Assert.assertEquals(actualHeaderText, expectedText);
    }

    @Then("User should see {string} is in the image header")
    public void userShouldSeeIsInTheImageHeader(String expectedText) {
        Assert.assertEquals(wikiResultPage.imageHeader.getText(), expectedText);
    }
}
