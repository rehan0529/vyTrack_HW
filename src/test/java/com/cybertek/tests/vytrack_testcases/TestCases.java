package com.cybertek.tests.vytrack_testcases;


import com.cybertek.tests.TestBase;
import org.testng.annotations.Test;
import static com.cybertek.tests.Pages.*;


public class TestCases extends TestBase {

    // Test case #1
       /*   1. Go to “https://qa1.vytrack.com/"
            2. Login as a store manager
            3. Navigate to “Activities -> Calendar Events”
            4. Verify that page subtitle "Options" is displayed
       */
    @Test
    public void task01(){

        extentLogger.info("Verify that page subtitle 'Options' is displayed");
        calendarEventsPage.verifyPageSubTitle();

        extentLogger.pass("PASS");
    }

    // Test case #2
       /*   1. Go to “https://qa1.vytrack.com/"
            2. Login as a store manager
            3. Navigate to “Activities -> Calendar Events”
            4. Verify that page number is equals to "1"
       */
    @Test
    public void task02(){

        extentLogger.info("Verify that page number is equals to \"1\"");
        calendarEventsPage.verifyPageNumber("1");

        extentLogger.pass("PASS");
    }

    // Test case #3
    /*   1. Go to “https://qa1.vytrack.com/"
         2. Login as a store manager
         3. Navigate to “Activities -> Calendar Events”
         4. Verify that view per page number is equals to"25"
    */

    @Test
    public void task03(){

        extentLogger.info("Verify that view per page number is equals to 25");
        calendarEventsPage.verifyViewPerPageValue("25");

        extentLogger.pass("PASS");
    }

    // Test case #4
    /*   1. Go to “https://qa1.vytrack.com/"
         2. Login as a store manager
         3. Navigate to “Activities -> Calendar Events”
         4. Verify that number of calendar events (rows in the table) is equals to number of records
    */

    @Test
    public void task04() {

        extentLogger.info("Verify that number of calendar events (rows in the table) is equals to number of records");
        calendarEventsPage.verifyRecordsNumberEqualsToCountOfRecords();

        extentLogger.pass("PASS");
    }

    // Test case #5
    /*   1. Go to “https://qa1.vytrack.com/"
         2. Login as a store manager
         3. Navigate to “Activities -> Calendar Events”
         4. Verify that all calendar events were selected
    */
    @Test
    public void task05() {

        calendarEventsPage.selectCheckBox();

        extentLogger.info("Verify that all calendar events were selected");
        calendarEventsPage.verifyAllRowsSelected();

        extentLogger.pass("PASS");
    }

    // Test case #6
    /*   1. Go to “https://qa1.vytrack.com/"
         2. Login as a store manager
         3. Navigate to “Activities -> Calendar Events”
         4. Select “Testers meeting”
         5. Verify that following data is displayed:
    */

    @Test
    public void task06() {

        extentLogger.info("Select 'Testers meeting'");
        calendarEventsPage.filterWithTitle("Testers meeting");
        calendarEventsPage.clickToRow.click();
        calendarEventsPage.selectToRow();

        extentLogger.info("Verify that following data is displayed");
        calendarEventsInfoPage.verifyCalendarEventsInfo();

        extentLogger.pass("PASS");

    }
}
