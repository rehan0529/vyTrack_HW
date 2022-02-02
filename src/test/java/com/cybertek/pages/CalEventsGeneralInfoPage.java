package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CalEventsGeneralInfoPage extends BasePage {

    public CalEventsGeneralInfoPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    //General Information titles

    @FindBy(xpath = "//label[text()='Title']")
    public WebElement title;

    @FindBy(xpath = "//label[text()='Description']")
    public WebElement description;

    @FindBy(xpath = "//label[text()='Start']")
    public WebElement start;

    @FindBy(xpath = "//label[text()='End']")
    public WebElement end;

    @FindBy(xpath = "//label[text()='All-day event']")
    public WebElement allDayEvent;

    @FindBy(xpath = "//label[text()='Organizer']")
    public WebElement organizer;

    @FindBy(xpath = "//label[text()='Call via Hangout']")
    public WebElement callViaHangout;

    //General Information titles as a List

    @FindBy(css = "label[class='control-label']")
    public List<WebElement> generalInfoKeys;

    //General Information values as a web element list

    @FindBy(css = "div.control-group.attribute-row>div>div")
    public List<WebElement> keyValues;


}
