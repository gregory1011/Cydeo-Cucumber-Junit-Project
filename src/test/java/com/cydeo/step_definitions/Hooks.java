package com.cydeo.step_definitions;


import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

// in this class we will be able to create the "pre" and "post condition
// for all the Scenarios and even Steps.
public class Hooks {

    @Before
    public void setupMethod(){
        System.out.println("---->@Before: Running Before each Scenario");
    }


    @After
    public void tearDownMethod(Scenario scenario){

        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "imag/png", scenario.getName());
        }

        System.out.println("---->@After: Running After each Scenario");
        BrowserUtils.sleep(2);
        Driver.closeDriver();
    }


   // @BeforeStep
    public void setupStep(){
        System.out.println("-->@BeforeStep: Running Before each Step");
    }

    // @AfterStep
    public void tearDownStep(){
        System.out.println("-->@AfterStep: Running After each Step");
    }





}
