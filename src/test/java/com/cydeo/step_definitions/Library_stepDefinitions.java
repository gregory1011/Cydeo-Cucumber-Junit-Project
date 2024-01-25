package com.cydeo.step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Library_stepDefinitions {


    @Given("user is on the login of the library application")
    public void user_is_on_the_login_of_the_library_application() {
        System.out.println("User is on the login of the library application");
    }


    @When("user enters librarian username")
    public void user_enters_librarian_username() {
        System.out.println("User enters librarian username");
    }



    @When("user enters librarian password")
    public void user_enters_librarian_password() {
        System.out.println("User enters librarian password");
    }



    @Then("user should see the dashboard")
    public void user_should_see_the_dashboard() {
        System.out.println("User see the dashboard");

    }

    @When("user enters student username")
    public void user_enters_student_username() {
        System.out.println("User enters student username");
    }



    @When("user enters student password")
    public void user_enters_student_password() {
        System.out.println("User enters student password");

    }


    @Given("user is on the login page of the library application")
    public void userIsOnTheLoginPageOfTheLibraryApplication() {
        System.out.println("user is on the login page of the library application");

    }

    @When("user enters admin username")
    public void userEntersAdminUsername() {
        System.out.println("User enters admin username");

    }

    @And("user enters admin password")
    public void userEntersAdminPassword() {
        System.out.println("User enters admin password");

    }





}
