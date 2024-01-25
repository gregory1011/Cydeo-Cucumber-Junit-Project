package com.cydeo.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {



    // in this class will be creating re-usable logic to read
    // from configuration.properties file

    //1. Create the property object.
    // private to secure its access
    // static is to make sure its created and loaded before everything else
    private static Properties properties = new Properties();

    static {

        try {

            //2. Open file using FileInputStream
            FileInputStream file = new FileInputStream("configuration.properties");

            //3. Load the "properties" object with "file" (oad properties)
            properties.load(file);

            // close the file in the memory
            file.close();

        }catch (IOException e){
            System.out.println("File not found with given path!");
            e.printStackTrace();
        }

    }

    // Create a utility method to use the object to read
    //4. Use "properties" object to read from file (read properties)

    public static String getProperty (String keyword) {

        return properties.getProperty(keyword);

        // getProperty() method is coming from selenium library.

    }



}
