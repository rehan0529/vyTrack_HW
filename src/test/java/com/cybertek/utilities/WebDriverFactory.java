package com.cybertek.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {

    //Task:
    //write a static method that takes a String parameter name: browserType
    //based on tha value of parameter
    //it will set up the browser and
    //the method will return chromedriver or fire fox driver object
    //name of the method getdriver


    public static WebDriver getDriver(String browserType){

        WebDriver driver = null;
        switch(browserType.toLowerCase()){


            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;



            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;



        }

        return driver;
    }

}
