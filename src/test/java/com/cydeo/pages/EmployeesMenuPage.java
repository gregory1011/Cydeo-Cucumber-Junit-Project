package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class EmployeesMenuPage {

    public EmployeesMenuPage () {
        PageFactory.initElements(Driver.getDriver(), this);
    }



    @FindBy(xpath = "//*[@id='bx_left_menu_menu_company']/a")
    public WebElement employeesLink;

    @FindBy (xpath = "(//tbody)[4]/tr/td/div/div[1]/div/div[contains(@data-url,'company')]")
    public List<WebElement> employeesModules;


}
