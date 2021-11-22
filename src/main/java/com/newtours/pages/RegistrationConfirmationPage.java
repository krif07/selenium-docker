package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationConfirmationPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(css = "#register-confirm h1")
    private WebElement titleText;

    @FindBy(partialLinkText = "sign-in")
    private WebElement signInLink;

    @FindBy(linkText = "Flights")
    private WebElement flightsLink;

    public RegistrationConfirmationPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public String getTitle(){
        this.wait.until(ExpectedConditions.visibilityOf(this.titleText));
        return this.titleText.getText();
    }

    public void goToFlightDetailsPage(){
        this.wait.until(ExpectedConditions.visibilityOf(this.flightsLink));
        this.flightsLink.click();
    }
}
