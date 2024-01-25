package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WT_loginPage {


    public WT_loginPage () {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (name = "username")
    public WebElement inputUsername;
    @FindBy (name = "password")
    public WebElement inoutPassword;
    @FindBy (xpath = "//button[.='Login']")
    public WebElement loginBtn;


    // this method will login with username: "Test"  /  and password: "Tester"
    public void login(){
        this.inputUsername.sendKeys("Test");
        this.inoutPassword.sendKeys("Tester");
        this.loginBtn.click();
    }


    // this method will login with credentials that are provided in the method
    // at the time of calling it
    public void login(String user, String pass){
        this.inputUsername.sendKeys(user);
        this.inoutPassword.sendKeys(pass);
        this.loginBtn.click();
    }



}
