package com.vyTrackHw.pages;

import com.vyTrackHw.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalendarEventsPage extends BasePage {

    public CalendarEventsPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = "[title='Create Calendar event']")
    public WebElement createCalendarEvent;

    @FindBy(xpath = "//*[@class='btn-group actions-group']/div")
    public WebElement options;

    @FindBy(xpath = "//input[@type='number']")
    public WebElement pageNumber;

    @FindBy(xpath = "//div[@class='btn-group']/button/text()[1]")
    public WebElement viewPerPage;





}
