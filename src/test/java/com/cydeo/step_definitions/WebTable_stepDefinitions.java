package com.cydeo.step_definitions;

import com.cydeo.pages.WT_OrderPage;
import com.cydeo.pages.WT_loginPage;
import com.cydeo.pages.WT_viewAllOrdersPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class WebTable_stepDefinitions {

    @Given("user is on the Web Table app login page")
    public void user_is_on_the_web_table_app_login_page() {
        Driver.getDriver().get("https://web-table-2.cydeo.com/login");
    }

    WT_loginPage wtLoginPage = new WT_loginPage();

    @When("user enters correct username")
    public void user_enters_correct_username() {
        wtLoginPage.inputUsername.sendKeys("Test");
    }
    @When("user enters correct password")
    public void user_enters_correct_password() {
        wtLoginPage.inoutPassword.sendKeys("Tester");
    }
    @When("user clicks to login button")
    public void user_clicks_to_login_button() {
        wtLoginPage.loginBtn.click();
    }
    @Then("user should see orders word in the URL")
    public void user_should_see_orders_word_in_the_url() {
        String actualURL = Driver.getDriver().getCurrentUrl();
        String expectedURL = "orders";

        Assert.assertTrue(actualURL.contains(expectedURL));
    }

    @When("user enters {string} username and {string} password")
    public void userEntersUsernameAndPassword(String username, String password) {

        wtLoginPage.inputUsername.sendKeys(username);
        wtLoginPage.inoutPassword.sendKeys(password);

    }

    @When("user enters below correct credentials")
    public void userEntersBelowCorrectCredentials(Map<String, String> credentials) {

        wtLoginPage.inputUsername.sendKeys(credentials.get("username"));
        wtLoginPage.inoutPassword.sendKeys(credentials.get("password"));

    }


    @Given("user is already logged in to The Web table app")
    public void user_is_already_logged_in_to_the_web_table_app() {
        Driver.getDriver().get("https://web-table-2.cydeo.com/login");
        wtLoginPage.login();
    }


    WT_OrderPage wtOrderPage = new WT_OrderPage();


    @When("user is on the Order page")
    public void userIsOnTheOrderPage() {
        wtOrderPage.orderLink.click();
    }

    @Then("user sees below options under product dropdown")
    public void user_sees_below_options_under_product_dropdown(List<String> expectedOptions) {

        List<String > actualOptions = BrowserUtils.dropdownOptions_as_String(wtOrderPage.productDropdown);


        Assert.assertEquals(actualOptions, expectedOptions);


    }


    @Then("user sees Visa ad enabled payment option")
    public void userSeesVisaAdEnabledPaymentOption() {

        Assert.assertTrue(wtOrderPage.visaRadioButton.isEnabled());
    }

    @Then("user sees MasterCard ad enabled payment option")
    public void userSeesMasterCardAdEnabledPaymentOption() {

        Assert.assertTrue(wtOrderPage.masterCardRadioButton.isEnabled());
    }

    @Then("user sees AmericanExpress ad enabled payment option")
    public void userSeesAmericanExpressAdEnabledPaymentOption() {

        Assert.assertTrue(wtOrderPage.masterCardRadioButton.isEnabled());
    }


    @And("user enters quantity {string}")
    public void userEntersQuantity(String quantity) {
        wtOrderPage.inputQuantity.clear();
        wtOrderPage.inputQuantity.sendKeys("2");
    }

    @Then("user clicks to the calculate button")
    public void userClicksToTheCalculateButton() {
        wtOrderPage.calculateBtn.click();
    }

    @And("user enters customer name {string}")
    public void userEntersCustomerName(String name) {
        wtOrderPage.inputName.sendKeys(name);
    }

    @And("user enters street {string}")
    public void userEntersStreet(String street) {
        wtOrderPage.inputStreet.sendKeys(street);
    }

    @And("user enters city {string}")
    public void userEntersCity(String city) {
        wtOrderPage.inputCity.sendKeys(city);
    }

    @And("user enters state {string}")
    public void userEntersState(String state) {
        wtOrderPage.inputState.sendKeys(state);
    }

    @And("user enters zip {string}")
    public void userEntersZip(String zip) {
        wtOrderPage.inputZip.sendKeys(zip);
    }

    @And("user selects payment option {string}")
    public void userSelectsPaymentOption(String expectedCardType) {

        BrowserUtils.clickRadioBtn(wtOrderPage.cardTypes, expectedCardType);
    }

    @And("user enters credit card number {string}")
    public void userEntersCreditCardNumber(String cardNumber) {
        wtOrderPage.inputCreditCard.sendKeys(cardNumber);
    }

    @And("user enters expiration date {string}")
    public void userEntersExpirationDate(String expDate) {
        wtOrderPage.inputExpirationDate.sendKeys(expDate);
    }

    @And("user clicks to process order button")
    public void userClicksToProcessOrderButton() {
        wtOrderPage.processBtn.click();
    }


    WT_viewAllOrdersPage viewAllOrdersPage = new WT_viewAllOrdersPage();

    @Then("user should see {string} in the row of the web table")
    public void userShouldSeeInTheRowOfTheWebTable(String expectedName) {

        String actualName = viewAllOrdersPage.newCustomerCell.getText();

        Assert.assertEquals(actualName, expectedName);

    }




}
