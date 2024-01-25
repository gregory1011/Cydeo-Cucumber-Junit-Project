package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class WOA_AOA_BasePage {

    public WOA_AOA_BasePage (){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(linkText = "Users")
    public WebElement usersLink;


    @FindBy (linkText = "Users")
    public WebElement dashboardLink;

    @FindBy (linkText = "Users")
    public WebElement booksLink;

}
