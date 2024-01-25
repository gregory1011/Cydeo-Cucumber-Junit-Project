package com.cydeo.utilities;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BrowserUtils {


    public static void sleep (int seconds){
        // this method will accept int - seconds
        // and execute Thread.sleep method for given duration
        seconds *= 1000;
        try{
            Thread.sleep(seconds);
        }catch (InterruptedException e){

        }
    }



    public  static void switchWindowAndVerify(
            String expectedInURL, String expectedInTitle){

        // 4. Create a logic to switch to the tab where Etsy.com is open
        Set<String> allWindowsHandles = Driver.getDriver().getWindowHandles();

        for (String each : allWindowsHandles){
            Driver.getDriver().switchTo().window(each);
            System.out.println("Get current URL: "+ Driver.getDriver().getCurrentUrl());

            if ( Driver.getDriver().getCurrentUrl().contains(expectedInURL)){
                break;
            }
        }


        // 5. Assert: Title contains requirements
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertTrue( actualTitle.contains(expectedInTitle) );

    }


    public static void verifyTitle(String expectedTitle){

        Assert.assertEquals(Driver.getDriver().getTitle(), expectedTitle);

    }



    public static void verifyTitleContains( String expectedTitle){

        Assert.assertTrue(Driver.getDriver().getTitle().contains(expectedTitle));

    }



    // this method accepts webElement target and waits for the webElement not to be displayed
    public static void waitForInvisibilityOF(WebElement target){

        // create object from WebDriverWai class and set up the constructor args.
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

        // use the 'wait' object with the proper syntax to create explicit wait conditions.
        wait.until(ExpectedConditions.invisibilityOf(target));


    }



    // this method accepts String title and waits for the title to contain given String value
    public static void waitForTitleContains(String title){

        // create object from WebDriverWai class and set up the constructor args.
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

        // use the 'wait' object with the proper syntax to create explicit wait conditions.
        wait.until(ExpectedConditions.titleContains(title));


    }



    // this method accepts a dropdown element and returns a List<String> that contains all options values as String
    public static List<String> dropdownOptions_as_String (WebElement dropdownElement){

        Select month = new Select(dropdownElement);

        // storing all the actual options into a List webElements
        List<WebElement> actualMonth_as_WebElement = month.getOptions();

        //creating an Empty list of String to store Actual <option> as String
        List<String> actualMonth_as_String = new ArrayList<>();

        // looping through the List<WebElements>, getting all options texts, and storing into List<String>
        for (WebElement each : actualMonth_as_WebElement) {
            actualMonth_as_String.add(each.getText());
        }

        return actualMonth_as_String;
    }


    public static void clickRadioBtn(List<WebElement> radioBtn, String attributeValue){

        for (WebElement eachElement : radioBtn) {
            if ( eachElement.getAttribute("value").equals(attributeValue));
            eachElement.click();
        }

    }


    public static WebElement waitForVisibility(WebElement element, int time) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(time));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static List<String> getElementsText(List<WebElement> list) {
        List<String> elemTexts = new ArrayList<>();
        for (WebElement el : list) {
            elemTexts.add(el.getText());
        }
        return elemTexts;
    }



}
