package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WOA_LibraryDashboardPage extends WOA_AOA_BasePage {

    public WOA_LibraryDashboardPage () {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (xpath = "//h2[@id='user_count']")
    public WebElement usersAmount;

    @FindBy  (xpath = "//a[@id='navbarDropdown']/span")
    public WebElement usernameLink;




}
