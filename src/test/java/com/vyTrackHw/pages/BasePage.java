package com.vyTrackHw.pages;

import com.vyTrackHw.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    public BasePage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(id = "prependedInput")
    public WebElement usernamePart;

    @FindBy(id = "prependedInput2")
    public WebElement passwordPart;

    @FindBy(id = "_submit")
    public WebElement loginButton;

    public void SignInPage(){
        loginButton.click();
    }

    public void LoginPage(String username, String password){
        usernamePart.sendKeys(username);
        passwordPart.sendKeys(password);
    }







}
