package com.vyTrackHw.tests;

import com.vyTrackHw.utilities.ConfigurationReader;
import com.vyTrackHw.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {

    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    @BeforeMethod
    public void setUp(){
        driver = Driver.get();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        String url = ConfigurationReader.get("url");
        actions = new Actions(driver);
        wait = new WebDriverWait(driver,10);
        driver.get(url);
    }

    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }

}
