package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CalendarEventsPage extends BasePage {

    public CalendarEventsPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = "[title='Create Calendar event']")
    public WebElement createCalendarEvent;

    @FindBy(css = "div[class='btn-group actions-group']")
    public WebElement options;

    @FindBy(css = "input[type='number']")
    public WebElement pageNumber;

    @FindBy(css = "button[data-toggle='dropdown']")
    public WebElement viewPerPage;

    @FindBy(css = "ul.dropdown-menu.pull-right>li")
    public List<WebElement> viewPerPageOptions;

    @FindBy(css = "a[data-size='100']")
    public WebElement viewPerPage100;

    @FindBy(css = "table>tbody>tr")
    public List<WebElement> tableRows;

    @FindBy(xpath = "// label[contains(text(), 'records')]")
    public WebElement totalOfREcords;

    @FindBy(css = "input[tabindex='-1']")
    public List<WebElement> tableCheckboxColumn;

    @FindBy(css = "button.btn.btn-default.btn-small.dropdown-toggle>input[type='checkbox']")
    public WebElement checkbox;

    @FindBy(css = "td[data-column-label='Title']")
    List<WebElement> meetingTitle;

    public void getMeetingInfo(String title){
        waitUntilLoaderScreenDisappear();
        for (int i = 0; i < meetingTitle.size(); i++) {
            if(meetingTitle.get(i).getText().equals(title));
                meetingTitle.get(i).click();
                break;
        }
    }

}