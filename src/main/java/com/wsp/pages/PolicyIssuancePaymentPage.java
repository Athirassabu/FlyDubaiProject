package com.wsp.pages;

import com.wsp.config.ConfigFactory;
import com.wsp.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.wsp.utils.SeleniumUtils.*;


public class PolicyIssuancePaymentPage {
    private static final By enterName = By.xpath("//input[@name='full_name']");
    private static final By selectNationality = By.xpath("//input[@data-e2e='field-nationality']");
    private static final By selectIndia = By.xpath("//span[text()='India']");
    private static final By enterEmail = By.xpath("//input[@name='email_address']");
    private static final By enterMobile = By.xpath("//input[@placeholder='Mobile Number']");
    private static final By enterEmiratesId = By.xpath("//input[@data-e2e='field-emirates_id']");
    private static final By clickEmiratesIdExpiryDate = By.xpath("//input[@placeholder='dd/mm/yyyy']");
    private static final By nextButton = By.xpath("//button[@class='button button-next is-primary is-expanded']");

    public PolicyIssuancePaymentPage clickTitle(String t) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(ConfigFactory.getConfig().timeout()));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("loading-background")));
        By selectTitle = By.xpath("//span[text()='" + t + "']");
        click(selectTitle, "Title");
        return new PolicyIssuancePaymentPage();
    }

    public PolicyIssuancePaymentPage enterFullName(String name) {
        sendKeys(enterName, name, "Full name");
        return new PolicyIssuancePaymentPage();
    }

    public PolicyIssuancePaymentPage selectNationality(String nation) {
        click(selectNationality, "Nationality");
        By selectIndia = By.xpath("//span[text()='" + nation + "']");
        click(selectIndia, "India");
        return new PolicyIssuancePaymentPage();
    }

    public PolicyIssuancePaymentPage enterEmail(String email) {
        sendKeys(enterEmail, email, "Email");
        return new PolicyIssuancePaymentPage();
    }

    public PolicyIssuancePaymentPage enterMobile(String phone) {
        sendKeys(enterMobile, phone, "Mobile number");
        return new PolicyIssuancePaymentPage();
    }

    public PolicyIssuancePaymentPage enterEmiratesId(String eid) {
        click(enterEmiratesId, "Emirates id");
        sendKeys(enterEmiratesId, eid, "Emirates id");
        return new PolicyIssuancePaymentPage();
    }

    public PolicyIssuancePaymentPage clickEmiratesIdExpiryDate(String m, String y, String d) {
        click(clickEmiratesIdExpiryDate, "Date field");
        By year = By.xpath("(//span[@class='select'])[2]//select//option[@value='" + y + "']");
        By month = By.xpath("(//span[@class='select'])[1]//select//option[@value='" + m + "']");
        By date = By.xpath("(//div[@class='datepicker-row']//following::span[text()='" + d + "'])[1]");
        click(month, "Month");
        click(year, "Year");
        click(date, "Date");
        return new PolicyIssuancePaymentPage();
    }

    public SummaryPage clickNextButton() {
        waitUntilElementToBeClickable(nextButton);
        click(nextButton, "Next button");
        return new SummaryPage();
    }

}
