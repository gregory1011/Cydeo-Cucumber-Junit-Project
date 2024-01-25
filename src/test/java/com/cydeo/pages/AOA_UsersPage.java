package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AOA_UsersPage  extends WOA_AOA_BasePage{

    public AOA_UsersPage (){
        PageFactory.initElements(Driver.getDriver(), this);
    }




    @FindBy (tagName = "th")
    public List<WebElement> tableHeaders;



}
