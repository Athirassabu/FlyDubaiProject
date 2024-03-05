package com.wsp.pages;

import com.wsp.config.ConfigFactory;
import com.wsp.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static com.wsp.utils.SeleniumUtils.*;


public class BookFlightHomePage {

    private static final By acceptCookie = By.xpath("//button[text()='Accept All']");
    private static final By selectDestination = By.id("airport-destination");
    private static final By selectOrigin = By.id("airport-origin");
    private static final By selectDate = By.id("dateRangeTo");
    private static final By clickSearch = By.xpath("//input[@value='Search' and @type='submit' and @class='btn btn_yellow search-btn-style']");

    public BookFlightHomePage acceptCookies() {
        waitUntilElementToBeClickable(acceptCookie);
        click(acceptCookie, "Accept cookies");
        return this;
    }

    public BookFlightHomePage selectDestination(String destination) {
        sendKeys(selectDestination, destination, "Destination city");
        List<WebElement> optionList = DriverManager.getDriver().findElements(By.xpath("//ul[@class='full_width search-list-dropdown DestinationAirlist']//li"));
        for (WebElement ele : optionList) {
            String currentOption = ele.getText();
            if (currentOption.contains(destination)) {
                ele.click();
                break;
            }
        }
        return this;
    }

    public BookFlightHomePage selectOrigin(String origin) {
        sendKeys(selectOrigin, origin, "Destination city");
        List<WebElement> optionList = DriverManager.getDriver().findElements(By.xpath("(//ul[@class='full_width search-list-dropdown airListDropDown'])[1]/li"));
        for (WebElement ele : optionList) {
            String currentOption = ele.getText();
            if (currentOption.contains(origin)) {
                ele.click();
                break;
            }
        }
        return this;
    }




    public BookFlightHomePage clickOriginDateRange(String originMonth,String originYear,String originDate) {
        click(selectDate, "Date range");
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(ConfigFactory.getConfig().timeout()));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//img[@class='show-desktop']")));
        By selectStartDate = By.xpath("(//option[text()='"+originMonth+"']//following::option[@value='"+originYear+"']//following::div[text()='"+originDate+"'])[1]");
        click(selectStartDate,"Start date");
        return this;
    }
    public BookFlightHomePage clickDestinationDate(String destMonth,String destYear,String destDate) {
        By selectReturnDate = By.xpath("(//option[text()='"+destMonth+"']//following::option[@value='"+destYear+"']//following::div[text()='"+destDate+"'])[1]");
        click(selectReturnDate,"Return date");
        return this;
    }

    public FlightDetailsPage clickSearch() {
        click(clickSearch,"Search");
        return new FlightDetailsPage();
    }


}
