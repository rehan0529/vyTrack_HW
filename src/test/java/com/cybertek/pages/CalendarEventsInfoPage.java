package com.cybertek.pages;

import com.cybertek.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CalendarEventsInfoPage extends BasePage {

    @FindBy(xpath = "//div[@class='control-group attribute-row']/label")
    public List<WebElement> headers;

    @FindBy(xpath = "(//div[@class='controls']/div)[1]")
    public WebElement titleValue;

    @FindBy(xpath = "//div/p/span")
    public WebElement descriptionValue;

    @FindBy(xpath = "(//div[@class='controls']/div)[3]")
    public WebElement startValue;

    @FindBy(xpath = "(//div[@class='controls']/div)[4]")
    public WebElement endValue;

    @FindBy(xpath = "(//div[@class='controls']/div)[5]")
    public WebElement allDayEventValue;

    @FindBy(xpath = "(//div[@class='controls']/div)[6]//a")
    public WebElement organizerValue;

    @FindBy(xpath = "(//div[@class='controls']/div)[7]")
    public WebElement callViaHangoutValue;

    public Map<String,String> getActualInfo(){
        Map <String,String > info = new LinkedHashMap<>();
        info.put(BrowserUtils.getElementsText(headers).get(0),titleValue.getText());
        info.put(BrowserUtils.getElementsText(headers).get(1),descriptionValue.getText());
        info.put(BrowserUtils.getElementsText(headers).get(2),startValue.getText());
        info.put(BrowserUtils.getElementsText(headers).get(3),endValue.getText());
        info.put(BrowserUtils.getElementsText(headers).get(4),allDayEventValue.getText());
        info.put(BrowserUtils.getElementsText(headers).get(5),organizerValue.getText());
        info.put(BrowserUtils.getElementsText(headers).get(6),callViaHangoutValue.getText());

        return info;
    }

    public Map<String,String> getExpectedInfo(){
        Map<String,String> expectedInfo=new LinkedHashMap<>();
        expectedInfo.put("Title","Testers meeting");
        expectedInfo.put("Description","This is a a weekly testers meeting");
        expectedInfo.put("Start","Nov 27, 2019, 9:30 AM");
        expectedInfo.put("End","Nov 27, 2019, 10:30 AM");
        expectedInfo.put("All-Day Event","No");
        expectedInfo.put("Organizer","John Doe");
        expectedInfo.put("Call Via Hangout","No");

        return expectedInfo;
    }

    public void verifyCalendarEventsInfo(){
        Assert.assertEquals(getActualInfo(),getExpectedInfo(),"verify the table");
    }
}
