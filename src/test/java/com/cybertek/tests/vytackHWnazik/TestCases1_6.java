package com.cybertek.tests.vytackHWnazik;


import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.CalEventsGeneralInfoPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.Map;

public class TestCases1_6 extends TestBase {

    @Test
    public void test1(){

        /*
        1. Go to “https://qa1.vytrack.com/"
        2. Login as a store manager
        3. Navigate to “Activities -> Calendar Events”
        4. Verify that page subtitle "Options" is displayed
         */

        LoginPage loginPage = new LoginPage();
        loginPage.loginAsStoreManager();

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        calendarEventsPage.navigateToModule("Activities", "Calendar Events");

        Assert.assertTrue(calendarEventsPage.options.isDisplayed(), "Verify Options is displayed");
    }

    @Test
    public void test2(){

        /*
        1. Go to “https://qa1.vytrack.com/"
        2. Login as a store manager
        3. Navigate to “Activities -> Calendar Events”
        4. Verify that page number is equals to "1"
         */

        LoginPage loginPage = new LoginPage();
        loginPage.loginAsStoreManager();

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        calendarEventsPage.navigateToModule("Activities", "Calendar Events");

        String expectedNumber = "1";

        Assert.assertEquals(calendarEventsPage.pageNumber.getAttribute("value"), expectedNumber, "Verify that page number is equals to 1");

    }

    @Test
    public void test3(){

        /*
        1. Go to “https://qa1.vytrack.com/"
        2. Login as a store manager
        3. Navigate to “Activities -> Calendar Events”
        4. Verify that view per page number is equals to "25"
         */

        LoginPage loginPage = new LoginPage();
        loginPage.loginAsStoreManager();

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        calendarEventsPage.navigateToModule("Activities", "Calendar Events");

        wait.until(ExpectedConditions.visibilityOf(calendarEventsPage.viewPerPage));

        System.out.println("view per page:"+calendarEventsPage.viewPerPage.getText());

        Assert.assertEquals(calendarEventsPage.viewPerPage.getText(), "25");
    }

    @Test
    public void test4() throws InterruptedException {
        /*
        1. Go to “https://qa1.vytrack.com/"
        2. Login as a store manager
        3. Navigate to “Activities -> Calendar Events”
        4. Verify that number of calendar events (rows in the table) is equals to number of records
         */

        LoginPage loginPage = new LoginPage();
        loginPage.loginAsStoreManager();

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        calendarEventsPage.navigateToModule("Activities", "Calendar Events");

        wait.until(ExpectedConditions.visibilityOf(calendarEventsPage.viewPerPage));

        calendarEventsPage.viewPerPage.click();

        calendarEventsPage.viewPerPage100.click();

        Thread.sleep(2000);

        String[] splitNumberOfRecords = calendarEventsPage.totalOfREcords.getText().split(" ");
        String numberOfRecords = splitNumberOfRecords[2];

        String numberOfRows = String.valueOf(calendarEventsPage.tableRows.size());

        Assert.assertEquals(numberOfRecords, numberOfRows);


    }

    @Test
    public  void test5(){
        /*
        1. Go to “https://qa1.vytrack.com/"
        2. Login as a store manager
        3. Navigate to “Activities -> Calendar Events”
        4. Click on the top checkbox to select all
        5. Verify that all calendar events were selected
         */
        LoginPage loginPage = new LoginPage();
        loginPage.loginAsStoreManager();

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        calendarEventsPage.navigateToModule("Activities", "Calendar Events");

        calendarEventsPage.checkbox.click();

        for (WebElement checkboxes: calendarEventsPage.tableCheckboxColumn) {
            Assert.assertTrue(checkboxes.isSelected());
        }
    }

    @Test
    public void test6(){
        /*
        1. Go to “https://qa1.vytrack.com/"
        2. Login as a store manager
        3. Navigate to “Activities -> Calendar Events”
        4. Select “Testers meeting”
        5. Verify that following data is displayed:
         */
        LoginPage loginPage = new LoginPage();
        loginPage.loginAsStoreManager();

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        calendarEventsPage.navigateToModule("Activities", "Calendar Events");
        CalEventsGeneralInfoPage calEventsGeneralInfoPage = new CalEventsGeneralInfoPage();

        wait.until(ExpectedConditions.visibilityOf(calEventsGeneralInfoPage.callViaHangout));

        Map<String,String> expectedMeetingInfo = new LinkedHashMap<>();
        expectedMeetingInfo.put("Title","Testers meeting");
        expectedMeetingInfo.put("Description","This is a a weekly testers meeting");
        expectedMeetingInfo.put("Start","Nov 27, 2019, 9:30 AM");
        expectedMeetingInfo.put("End","Nov 27, 2019, 10:30 AM");
        expectedMeetingInfo.put("All-Day Event","No");
        expectedMeetingInfo.put("Organizer","John Doe");
        expectedMeetingInfo.put("Call Via Hangout","No");

        Map<String,String> actualMeetingInfo = new LinkedHashMap<>();

        for (int i = 0; i < calEventsGeneralInfoPage.generalInfoKeys.size() ; i++) {
            actualMeetingInfo.put(calEventsGeneralInfoPage.generalInfoKeys.get(i).getText() ,
                                    calEventsGeneralInfoPage.keyValues.get(i).getText());
        }

        Assert.assertEquals(actualMeetingInfo, expectedMeetingInfo);

        for (int i = 0; i < calEventsGeneralInfoPage.generalInfoKeys.size(); i++) {
            System.out.println(calEventsGeneralInfoPage.generalInfoKeys.get(i).getText()+": "
                                + calEventsGeneralInfoPage.keyValues.get(i).getText() );
        }
    }

}
