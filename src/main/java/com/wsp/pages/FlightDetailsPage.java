package com.wsp.pages;

import com.wsp.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static com.wsp.utils.SeleniumUtils.*;


public class FlightDetailsPage {


    private static final By getPrice = By.xpath("(//div[@id='fareLbl'])[1]");
    private static final By enterFirstName = By.id("First_Name");
    private static final By enterLastName = By.id("Last_Name");
    private static final By enterEmail = By.id("Email_Address");
    private static final By clickReviewBooking = By.xpath("(//span[@class='ng-star-inserted'])[2]");
    private static final By enterMobile = By.id("Mobile_Number");
    private static final By selectCountry = By.xpath("//span[text()='United Arab Emirates']");
    private static final By selectCode = By.xpath("(//input[@id='Email_Address']/following::div[starts-with(@class,'mat-form-field-infix ng-tns')])[1]");
    private static final By selectFemale = By.xpath("//mat-radio-button[@id='Female.Text']/label[1]/div[1]/div[1]");
    private static final By continuePassengerDetails = By.xpath("(//span[text()='Continue to passenger details'])[1]");
    private static final By clickSearch = By.xpath("//input[@value='Search' and @type='submit' and @class='btn btn_yellow search-btn-style']");
    private static final By clickLowFare = By.xpath("(//div[@class='flex flight-list-item item-center'])[1]");
    private static final By selectLite= By.xpath("(//button[@class='mat-button mat-button-base'])[1]");
    private static final By clickLowFareReturn = By.xpath("//label[text()='SELECT RETURNING FLIGHT']/following::div[@class='flight--duration']");

    public FlightDetailsPage clickLowFare() {
        waitUntilElementToBeVisible(clickLowFare);
        WebElement element = DriverManager.getDriver().findElement(clickLowFare);
        Actions actions = new Actions(DriverManager.getDriver());
        actions.moveToElement(element).click().build().perform();
        click(selectLite,"Lite");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        waitUntilElementToBeClickable(clickLowFareReturn);
        WebElement ret = DriverManager.getDriver().findElement(clickLowFareReturn);
        actions.moveToElement(ret).click().build().perform();
        click(selectLite,"Lite");
        return this;
    }
    public String getPrice() {
        waitUntilElementToBeVisible(getPrice);
       String price=DriverManager.getDriver().findElement(By.xpath("(//div[@id='fareLbl'])[1]")).getText();
        System.out.println("Price is:"+price);
        return price;
    }

    public PassengerDetailsPage clickContinuePassengerDetails() {

       click(continuePassengerDetails,"Continue passenger details");
        return new PassengerDetailsPage();
    }


}
