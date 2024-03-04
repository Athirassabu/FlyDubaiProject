package com.wsp.pages;

import com.wsp.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.wsp.utils.SeleniumUtils.*;


public class BookFlightHomePage {

    private static final By acceptCookie = By.xpath("//button[@class=' osano-cm-accept-all osano-cm-buttons__button osano-cm-button osano-cm-button--type_accept ']");
    private static final By selectDestination = By.id("airport-destination");
    private static final By selectDate = By.id("dateRangeTo");
    private static final By selectToday = By.xpath("(//div[text()='5'])[1]");
    private static final By selectNextDay = By.xpath("(//div[text()='8'])[1]");
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
    public String getTitleTest() {
        getTitle(DriverManager.getDriver().getTitle());
        return DriverManager.getDriver().getTitle();
    }

    public BookFlightHomePage acceptCookies() {
        click(acceptCookie, "Accept cookies");
        return this;
    }

    public BookFlightHomePage selectDestination() {
        sendKeys(selectDestination, "MCT", "Destination city");
        List<WebElement> optionList = DriverManager.getDriver().findElements(By.xpath("//ul[@class='full_width search-list-dropdown DestinationAirlist']//li"));
        for (WebElement ele : optionList) {
            String currentOption = ele.getText();
            if (currentOption.contains("MCT")) {
                ele.click();
                break;
            }
        }
        return this;
    }



    public BookFlightHomePage clickDateRange() {
        click(selectDate, "Date range");
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        click(selectToday,"Today");
        click(selectNextDay,"Next day");
        return this;
    }

    public FlightDetailsPage clickSearch() {
        click(clickSearch,"Search");
        return new FlightDetailsPage();
    }

    public BookFlightHomePage enterPassengerDetails() {

       sendKeys(enterFirstName,"Athira","First name");
        sendKeys(enterLastName,"Sabu","Last name");
        sendKeys(enterEmail,"athirasabu7654@gmail.com","Email address");
        click(selectFemale,"Female");
        return this;
    }



}
