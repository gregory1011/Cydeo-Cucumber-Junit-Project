package com.cydeo.step_definitions;

import com.cydeo.pages.AOA_UsersPage;
import com.cydeo.pages.WOA_LibraryDashboardPage;
import com.cydeo.utilities.BrowserUtils;
import com.google.common.collect.Table;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class AOA_Users_StepDefs {

    WOA_LibraryDashboardPage dashboardPage = new WOA_LibraryDashboardPage();
    AOA_UsersPage usersPage = new AOA_UsersPage();

    @Given("I click on {string} link")
    public void i_click_on_link(String link) {

        BrowserUtils.waitForVisibility(dashboardPage.dashboardLink, 10);

        switch (link.toLowerCase()) {
            case "dashboard":
                dashboardPage.dashboardLink.click();
                break;
            case "users":
                dashboardPage.usersLink.click();
                break;
            case "books":
                dashboardPage.booksLink.click();
                break;
        }
    }


    @Then("table should have following column names:")
    public void table_should_have_following_column_names(List<String> expectedTableHeaders) {

        List<String> actualTableHeaders = new ArrayList<>();

        for (WebElement eachTableHeader : usersPage.tableHeaders) {
            actualTableHeaders.add(eachTableHeader.getText());
        }

//      List<String> actualTableHeaders = BrowserUtils.getElementsText(usersPage.tableHeaders);
        
        Assert.assertEquals(expectedTableHeaders, actualTableHeaders);
    }






}
