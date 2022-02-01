package com.vyTrackHw.pages;

import com.vyTrackHw.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CalendarEventsPage extends BasePage {

    public CalendarEventsPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = "[title='Create Calendar event']")
    public WebElement createCalendarEvent;

    @FindBy(css = "div[class='btn btn-link dropdown-toggle']")
    public WebElement options;

    @FindBy(xpath = "//input[@type='number']")     //By css "input[type='number']"
    public WebElement pageNumber;

    //@FindBy(xpath = "//div[@class='btn-group']/button")
    @FindBy(css = "button[class='btn dropdown-toggle ']")
    public WebElement viewPerPage;


}






