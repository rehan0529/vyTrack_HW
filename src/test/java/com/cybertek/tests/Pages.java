package com.cybertek.tests;

import com.cybertek.pages.*;



public class Pages extends TestBase {

    public static LoginPage loginPage;
    public static DashboardPage dashboardPage;
    public static CalendarEventsPage calendarEventsPage;
    public static CalendarEventsInfoPage calendarEventsInfoPage;


    public static void initialize(){

        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();
        calendarEventsPage = new CalendarEventsPage();
        calendarEventsInfoPage = new CalendarEventsInfoPage();
    }

    public static void testInitialize(){
        extentLogger = report.createTest("Contact Info Verification");
        extentLogger.info("Log in as a Store Manager");
        loginPage.loginAsStoreManager();

        extentLogger.info("Navigate to --> Activities -> Calendar Events");
        dashboardPage.navigateToModule("Activities","Calendar Events");
        calendarEventsPage.waitUntilLoaderScreenDisappear();

    }
}
