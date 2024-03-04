package com.wsp.pages;

import com.wsp.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.wsp.utils.SeleniumUtils.*;


public class FlightDetailsPage {


    private static final By getPrice = By.xpath("(//div[@id='fareLbl'])[1]");
    private static final By enterFirstName = By.id("First_Name");
    private static final By enterLastName = By.id("Last_Name");
    private static final By enterEmail = By.id("Email_Address");
    private static final By selectFemale = By.id("Female.Text-input");
    private static final By continuePassengerDetails = By.xpath("(//span[text()='Continue to passenger details'])[1]");
    private static final By clickSearch = By.xpath("//input[@value='Search' and @type='submit' and @class='btn btn_yellow search-btn-style']");
    private static final By clickLowFare = By.xpath("(//div[@class='flex flight-list-item item-center'])[1]");
    private static final By selectLite= By.xpath("(//button[@class='mat-button mat-button-base'])[1]");
    private static final By clickLowFareReturn = By.xpath("(//div[@class='flex flight-list-item item-center'])[7]");

    public FlightDetailsPage clickLowFare() {
        click(clickLowFare,"Low fare");
        click(selectLite,"Lite");
        click(clickLowFareReturn,"Return flight");
        click(selectLite,"Lite");
        return this;
    }
    public String getPrice() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        waitUntilElementToBeVisible(getPrice);
       String price=DriverManager.getDriver().findElement(By.xpath("(//div[@id='fareLbl'])[1]")).getText();
        System.out.println("Price is:"+price);
        return price;
    }

    public FlightDetailsPage clickContinuePassengerDetails() {

       click(continuePassengerDetails,"Continue passenger details");
        return this;
    }
    public FlightDetailsPage enterPassengerDetails() {

       sendKeys(enterFirstName,"Athira","First name");
        sendKeys(enterLastName,"Sabu","Last name");
        sendKeys(enterEmail,"athirasabu7654@gmail.com","Email address");
        click(selectFemale,"Female");
        return this;
    }



}
