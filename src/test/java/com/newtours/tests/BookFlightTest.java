package com.newtours.tests;

import com.newtours.pages.*;
import com.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BookFlightTest extends BaseTest {

    private String noOfPassengers;
    private String expectedPrice;

    @BeforeTest
    @Parameters({"noOfPassengers", "expectedPrice"})
    public void setupParameters(String noOfPassengers,String expectedPrice){
        this.noOfPassengers = noOfPassengers;
        this.expectedPrice = expectedPrice;
    }

    @Test
    public void registrationTest(){
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.goTo();
        registrationPage.enterUserDetails("Cristian", "Davila");
        registrationPage.enterUserCredentials("krif07", "pass", "pass");
        registrationPage.submit();
    }

    @Test(dependsOnMethods = "registrationTest")
    public void registrationConfirmationTest(){
        RegistrationConfirmationPage registrationConfirmationPage = new RegistrationConfirmationPage(driver);
        registrationConfirmationPage.getTitle();
        registrationConfirmationPage.goToFlightDetailsPage();
    }

    @Test(dependsOnMethods = "registrationConfirmationTest")
    public void flightDetailsTest(){
        FlightDetailsPage flightDetailsPage = new FlightDetailsPage(driver);
        flightDetailsPage.selectPassengers(noOfPassengers);
        flightDetailsPage.goToBookFlightPage();
    }

    @Test(dependsOnMethods = "flightDetailsTest")
    public void bookFlightTest(){
        BookFlightPage bookFlightPage = new BookFlightPage(driver);
        bookFlightPage.goToEnterBillingAddress();
    }

    @Test(dependsOnMethods = "bookFlightTest")
    public void enterBillingAddressTest(){
        EnterBillingAddressPage enterBillingAddressPage = new EnterBillingAddressPage(driver);
        enterBillingAddressPage.goToFlightConfirmationPage();
    }

    @Test(dependsOnMethods = "enterBillingAddressTest")
    public void flightConfirmationTest(){
        FlightConfirmationPage flightConfirmationPage = new FlightConfirmationPage(driver);
        String header = flightConfirmationPage.getFlightConfirmationHeader();
        String actualPrice = flightConfirmationPage.getTotalPriceText();
        Assert.assertEquals(actualPrice, expectedPrice);
        flightConfirmationPage.signOffButtonClick();
    }

}
