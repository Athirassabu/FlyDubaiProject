package com.wsp.pages;

import com.wsp.driver.DriverManager;
import com.wsp.reports.ExtentLogger;
import org.openqa.selenium.By;

import static com.wsp.utils.SeleniumUtils.*;


public class PassengerDetailsPage {


    private static final By getPrice = By.xpath("(//div[@id='fareLbl'])[1]");
    private static final By enterFirstName = By.id("First_Name");
    private static final By enterLastName = By.id("Last_Name");
    private static final By enterEmail = By.id("Email_Address");
    private static final By clickReviewBooking = By.xpath("(//span[@class='ng-star-inserted'])[2]");
    private static final By enterMobile = By.id("Mobile_Number");
    private static final By selectCountry = By.xpath("//span[text()='United Arab Emirates']");
    private static final By selectCode = By.xpath("(//input[@id='Email_Address']/following::div[starts-with(@class,'mat-form-field-infix ng-tns')])[1]");
    public String getPrice() {
        waitUntilElementToBeVisible(getPrice);
       String price=DriverManager.getDriver().findElement(By.xpath("(//div[@id='fareLbl'])[1]")).getText();
        ExtentLogger.pass("Price displayed in passenger detailed page is:"+price);
        return price;
    }

    public PassengerDetailsPage enterPassengerDetails(String firstName,String lastName,String email,String gender,String country,String number) {
        enterFirstName(firstName).enterLastName(lastName).enterEmail(email).selectRadio(gender).enterMobile(country,number);
        return this;
    }

    public PassengerDetailsPage enterFirstName(String firstName) {
        sendKeys(enterFirstName,firstName,"First name");
        return this;
    }
    public PassengerDetailsPage enterLastName(String lastName) {
        sendKeys(enterLastName,lastName,"Last name");
        return this;
    }
    public PassengerDetailsPage enterEmail(String email) {
        sendKeys(enterEmail,email,"Email address");
        return this;
    }
    public PassengerDetailsPage selectRadio(String gender) {
        By genders=By.xpath("//div[text()='"+gender+"']");
        click(genders,"Gender");
        return this;
    }
    public PassengerDetailsPage enterMobile(String country,String number) {
        click(selectCode,"Select code");
        click(selectCountry,country);
        sendKeys(enterMobile,number,"Mobile number");
        return this;
    }
    public ConfirmationPage clickReviewBooking() {
        click(clickReviewBooking,"Review booking");
        return new ConfirmationPage();
    }

}
