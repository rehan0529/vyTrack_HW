package com.vyTrackHw.tests;

import com.vyTrackHw.pages.CalendarEventsPage;
import com.vyTrackHw.pages.DashboardPage;
import com.vyTrackHw.pages.LoginPage;
import com.vyTrackHw.utilities.ConfigurationReader;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
    public void verifyOptionsTest() {
        extentLogger = report.createTest("Verify Option Link");
        extentLogger.info("Preconditions Loaded");
        extentLogger.info("Verify that Options Link is Displayed");

        Assert.assertTrue(page.options.isDisplayed(), "Verify that Link is Displayed");
        extentLogger.pass("Options is Displayed");

    }

    @Test
    public void verifyPageNumber() {

        extentLogger = report.createTest("Verify Page Number");
        extentLogger.info("Verifying the Page Number");

        int pageNumber = Integer.parseInt(page.pageNumber.getAttribute("value"));
        Assert.assertEquals(pageNumber, 1, "Page number is Equal to 1");

        extentLogger.pass("Verified that Page number is 1");

    }

    @Test
    public void viewPerPage() {

        extentLogger = report.createTest("Verify View Per Page Test");
        extentLogger.info("Verifying view per page is 25");

        wait.until(ExpectedConditions.visibilityOf(page.viewPerPage));
        int viewPerPage = Integer.parseInt(page.viewPerPage.getText());
        Assert.assertEquals(viewPerPage, 25, "Verify that view per page is 25");

        extentLogger.pass("Test Passed");

    }
}


