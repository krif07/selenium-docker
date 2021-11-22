package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightConfirmationPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(css = "#confirm-table tr:nth-child(1) td font")
    private WebElement flightConfirmationHeader;

    @FindBy(xpath = "//td[text()='Total Price']/following-sibling::td/font")
    private WebElement totalPriceText;

    @FindBy(id = "sign-on")
    private WebElement signOffButton;

    public FlightConfirmationPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public String getFlightConfirmationHeader(){
        this.wait.until(ExpectedConditions.visibilityOf(this.flightConfirmationHeader));
        System.out.println(this.flightConfirmationHeader);
        return this.flightConfirmationHeader.getText();
    }

    public String getTotalPriceText(){
        this.wait.until(ExpectedConditions.visibilityOf(this.totalPriceText));
        System.out.println(this.totalPriceText.getText());
        return this.totalPriceText.getText();
    }

    public void signOffButtonClick(){
        this.signOffButton.click();
    }
}
