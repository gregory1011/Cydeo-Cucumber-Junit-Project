package com.cydeo.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Driver {

    // Create a private constructor

    private Driver (){}

    // we make webDriver private because we want to close access to the object from the outside the class
    // we are making it static , because we will use it in a static method
   // private static WebDriver driver; // default value is = null
    private static InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();


    // Create a re-usable method which will return the same driver instance once we call it.
    // if an instance doesn't exist, it will create 1st, and then it will always return same instance.

    public  static WebDriver getDriver(){

        if ( driverPool.get() == null ){
            //we will read the browserType from configuration properties file
            //this way, we can control which browser is opened from outside our code
            String browserType = ConfigurationReader.getProperty("browser");


            // depending on browserType returned from the configuration.properties
            // switch case will determine the 'case' and open the matching browser.
            switch ( browserType){
                case "chrome":
                  //  WebDriverManager.chromedriver().setup();
                  //  driver = new ChromeDriver();
                    driverPool.set (new ChromeDriver());
                    driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;
                case "safari":
                  //  WebDriverManager.safaridriver().setup();
                   // driver = new SafariDriver();
                    driverPool.set(new SafariDriver());
                    driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;
                case "headless-chrome":
                    // WebDriverManager.chromedriver().setup();
                    ChromeOptions option = new ChromeOptions();
                    option.addArguments("--headless=new");
                    driverPool.set(new ChromeDriver(option));
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;
            }
        }
        return driverPool.get();
    }


    // create a new Driver.closeDriver(); it will .quite() method to quite browser,
    // and then set the driver value back to null
    public static void closeDriver(){
        if ( driverPool.get() != null ){
            // this line will terminate the currently existing driver completely. It will not exist going forward
            driverPool.get().quit();
            // this will assign the value back to 'null' so that my 'singleton' can create a newer one if needed
           // driver = null;
            driverPool.remove();
        }
    }


}
