package com.cydeo.step_definitions;

import com.cydeo.pages.EmployeesMenuPage;
import com.cydeo.utilities.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

public class EmployeesMenu_stepDefs {

    EmployeesMenuPage employeesMenu = new EmployeesMenuPage();


    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {



    }
    @When("the user logged in as {string}")
    public void the_user_logged_in_as(String string) {


    }
    @When("the user clicks on the Employees in the menu tab")
    public void the_user_clicks_on_the_employees_in_the_menu_tab() {


    }
    @Then("the user should be able to see following modules")
    public void the_user_should_be_able_to_see_following_modules(List<String> expectedModules) {

        //List<String> actualModules = BrowserUtils.dropdownOptions_as_String()

    }


    @Then("the user should view the Company Structure by default")
    public void the_user_should_view_the_company_structure_by_default() {



    }


}
