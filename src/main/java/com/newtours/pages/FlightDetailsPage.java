package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightDetailsPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "passCount")
    private WebElement passengersSelect;

    @FindBy(id = "findFlights")
    private WebElement continueButton;

    public FlightDetailsPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public void selectPassengers(String numberOfPassengers){
        this.wait.until(ExpectedConditions.elementToBeClickable(this.passengersSelect));
        Select select = new Select(this.passengersSelect);
        select.selectByValue(numberOfPassengers);
    }

    public void goToBookFlightPage(){
        this.wait.until(ExpectedConditions.elementToBeClickable(this.continueButton));
        continueButton.click();
    }
}
