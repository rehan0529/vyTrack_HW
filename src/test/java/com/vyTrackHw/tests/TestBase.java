package com.vyTrackHw.tests;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.vyTrackHw.pages.CalendarEventsPage;
import com.vyTrackHw.pages.LoginPage;
import com.vyTrackHw.utilities.BrowserUtils;
import com.vyTrackHw.utilities.ConfigurationReader;
import com.vyTrackHw.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestBase {

    protected WebDriver driver;
    protected Actions actions;
    protected WebDriverWait wait;

//    Reporting With Extent Reports:
//    Step 1: Get the dependency
//    Step 2: create object for building the report
//    Step 3: you need to create another object for HTML report file

    protected ExtentReports report;
    protected ExtentHtmlReporter htmlReporter;
    protected ExtentTest extentLogger;

    CalendarEventsPage page;

    @BeforeTest
    public void setUpTest(){

        report = new ExtentReports();
        String projectPath = System.getProperty("user.dir");
        String path = projectPath+"/test-output/report.html";
        htmlReporter = new ExtentHtmlReporter(path);
        report.attachReporter(htmlReporter);

        htmlReporter.config().setReportName("VyTreack HomeWork Test Case");
        report.setSystemInfo("Environment","Test");
        report.setSystemInfo("Browser" , ConfigurationReader.get("browser"));
        report.setSystemInfo("OS", System.getProperty("os.name"));

    }

    @BeforeTest
    public void setUpEachCase(){

        driver = Driver.get();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        actions = new Actions(driver);
        wait = new WebDriverWait(driver,10);

        driver.get(ConfigurationReader.get("url"));
        new LoginPage().loginAsStoreManager();

        page = new CalendarEventsPage();
        page.navigateToModule("Activities", "Calendar Events");

    }

    @AfterMethod
    public void tearDown(ITestResult result) throws IOException {
        if(result.getStatus() == ITestResult.FAILURE){
            extentLogger.fail(result.getName());

            String screenShotPath = BrowserUtils.getScreenshot(result.getName());
            extentLogger.addScreenCaptureFromPath(screenShotPath);
            extentLogger.fail(result.getThrowable());
        }
        /*
            else{  // if you also want to get screenshot if scenario passes
            //record the name of passed test case

            extentLogger.pass(result.getName());

            //take the screenshot and return location of screenshot
            String screenShotPath= BrowserUtils.getScreenshot(result.getName());

            //add your screenshot to your report
            extentLogger.addScreenCaptureFromPath(screenShotPath);
        }  */

        Driver.closeDriver();

    }
    @AfterTest
    public void fullTearDown(){
        report.flush();
    }

}