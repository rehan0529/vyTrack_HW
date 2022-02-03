package com.cybertek.pages;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;



public class CalendarEventsPage extends BasePage {

    public CalendarEventsPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = "[title='Create Calendar event']")
    public WebElement createCalendarEvent;

    @FindBy(xpath = "//div[contains(text(),'Options')]")
    public WebElement subTitle;

    @FindBy(css = "input[type='number']")
    public WebElement pageNumber;

    @FindBy(xpath = "(//a[@class='dropdown-item'])[2]")
    public WebElement viewPerPageNumber25;

    @FindBy(xpath = "//label[contains(text(),'Total of')]")
    public WebElement numberOfRecords;

    @FindBy (css = "table>tbody>tr")
    public List<WebElement> numOfRows;

    @FindBy(xpath = "//label[contains(text(),'|')]")
    public WebElement pageTotalNumberAsString;

    @FindBy(xpath = "(//div[@class='btn-group dropdown'])[1]//input")
    public WebElement selectAllCheckBox;

    @FindBy(xpath = "//tr/td/input")
    public List<WebElement> checkBoxes;

    @FindBy(css = "i.fa-filter.hide-text")
    public WebElement filterBtn;

    @FindBy(xpath = "//div[contains(text(),'Title')]")
    public WebElement titleBtn;

    @FindBy (xpath = "//input[@name ='value']")
    public WebElement textBox;

    @FindBy(xpath = "//td/div/div/a")
    public WebElement clickToRow;

    @FindBy(xpath = "//div/ul/li/ul/li/a[@title='View']")
    public WebElement clickToView;

//    public Integer getPageTotalNumberAsInteger(){
//        String text = pageTotalNumberAsString.getText();
//        return Integer.parseInt(text.substring(3,text.length()-2));
//    }

//    public String totalAllRows() {
//        int total = 0;
//        int j = 0;
//        for (int i = 1; i<=getPageTotalNumberAsInteger(); i++) {
//            BrowserUtils.doubleClick(pageNumber);
//            pageNumber.sendKeys(String.valueOf(getPageTotalNumberAsInteger()-j) + Keys.ENTER);
//            waitUntilLoaderScreenDisappear();
//            List<WebElement> allRows = Driver.get().findElements(By.xpath("//*[@class='grid-body']/tr"));
//            total += allRows.size();
//            j++;
//        }
//        return String.valueOf(total);
//    }

    public String getNumberOfRecords(){

        return numberOfRecords.getText().split(" ")[2].trim();
    }

    public String numberOfRecords(String sendKeys){

        filterWithTitle(sendKeys);
        BrowserUtils.waitFor(10);
        return numOfRows.size() + "";

    }
    public void selectCheckBox(){
        BrowserUtils.waitForClickablility(selectAllCheckBox,5);
        JavascriptExecutor jse = (JavascriptExecutor) Driver.get();
        jse.executeScript("arguments[0].click();", selectAllCheckBox);
    }

    public void filterWithTitle(String sendKeys){
        // filterBtn.click();
        BrowserUtils.waitForClickablility(filterBtn,5).click();
        // titleBtn.click();
        BrowserUtils.waitForClickablility(titleBtn,5).click();

        textBox.sendKeys(sendKeys + Keys.ENTER);
        BrowserUtils.waitFor(5);
    }

    public void selectToRow(){
        Actions actions = new Actions(Driver.get());
        actions.moveToElement(clickToRow).perform();

        JavascriptExecutor jse = (JavascriptExecutor) Driver.get();
        jse.executeScript("arguments[0].click();", clickToView);

        BrowserUtils.waitFor(2);
    }

    public void verifyPageSubTitle(){
        BrowserUtils.waitForVisibility(subTitle, 5);
        Assert.assertTrue(subTitle.isDisplayed(),"Verify that page subtitle 'Options' is displayed");
    }

    public void verifyPageNumber(String pageNumberValue){
        //BrowserUtils.waitForVisibility(pageNumber,10);
        Assert.assertEquals(pageNumber.getAttribute("value"),pageNumberValue,"Verify that page number is equals to \"1\"");
    }

    public void verifyViewPerPageValue(String viewPerPageValue){
        //BrowserUtils.waitForVisibility(viewPerPageNumber25,10);
        Assert.assertEquals(viewPerPageNumber25.getAttribute("data-size"),viewPerPageValue,"Verify that per page number is equals to \"25\"");
    }

    public void verifyRecordsNumberEqualsToCountOfRecords(){
        BrowserUtils.waitForVisibility(numberOfRecords,10);
        Assert.assertEquals(numberOfRecords("testers meeting"),getNumberOfRecords(),"Verify that number of calendar events (rows in the table) is equals to number of records");
    }

    public void verifyAllRowsSelected(){
        for (WebElement each : checkBoxes) {
            Assert.assertTrue(each.isSelected(),"Verify that all calendar events were selected");
        }
    }



}
