package com.vyTrackHw.tests;

import com.vyTrackHw.pages.CalendarEventsPage;
import com.vyTrackHw.pages.DashboardPage;
import com.vyTrackHw.pages.LoginPage;
import com.vyTrackHw.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase1_2_3 extends TestBase {

 /*
    Test case #1
    1. Go to “https://qa1.vytrack.com/"
    2. Login as a store manager
    3. Navigate to “Activities -> Calendar Events”
    4. Verify that page subtitle "Options" is displayed
 */

    @Test
    public void test1() {

    extentLogger = report.createTest("Activities, Calender Events verification");
    LoginPage loginPage = new LoginPage();

    String userName = ConfigurationReader.get("storemanager_username");
    String passWord = ConfigurationReader.get("storemanager_password");

        extentLogger.info("username: "+userName);
        extentLogger.info("password: "+passWord);
        extentLogger.info("Login as a Store Manager");

    loginPage.login(userName,passWord);

        extentLogger.info("navigate to --> Activities > Calendar Events");

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToModule("Activities","Calendar Events");

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        String actual = calendarEventsPage.options.getText();
        String expected = "Options";

        extentLogger.info("Verify that Options are available");
        Assert.assertEquals(actual, expected);

        extentLogger.pass("PASSED");

    }
    @Test
    public void test2(){

        extentLogger = report.createTest("Activities, Calender Events verification");
        LoginPage loginPage = new LoginPage();

        String userName = ConfigurationReader.get("storemanager_username");
        String passWord = ConfigurationReader.get("storemanager_password");

        extentLogger.info("username: "+userName);
        extentLogger.info("password: "+passWord);
        extentLogger.info("Login as a Store Manager");

        loginPage.login(userName,passWord);

        extentLogger.info("navigate to --> Activities > Calendar Events");

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToModule("Activities","Calendar Events");

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();


        String actual = calendarEventsPage.pageNumber.getAttribute("value");
        String expected = "1";

        Assert.assertEquals(actual, expected);


    }
    @Test
    public void test3(){

        extentLogger = report.createTest("Activities, Calender Events verification");
        LoginPage loginPage = new LoginPage();

        String userName = ConfigurationReader.get("storemanager_username");
        String passWord = ConfigurationReader.get("storemanager_password");

        extentLogger.info("username: "+userName);
        extentLogger.info("password: "+passWord);
        extentLogger.info("Login as a Store Manager");

        loginPage.login(userName,passWord);

        extentLogger.info("navigate to --> Activities > Calendar Events");

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToModule("Activities","Calendar Events");

//        //WebElement dropdown = driver.findElement(By.xpath("//div[@class='btn-group']/button/span"));
//
//
//        List<WebElement> dropdownOptions = driver.findElements(By.className("dropdown-item"));
//
//        //print size of options
//        System.out.println("dropdownOptions.size() = " + dropdownOptions.size());
//        Assert.assertEquals(dropdownOptions.size(),4,"Verify size of options");
//
//        //Print them 1 by 1
//
//        for (WebElement option : dropdownOptions) {
//            System.out.println(option.getText());
//        }
//
//        //click yahoo
//
//        dropdownOptions.get(2).click();


    }

}
