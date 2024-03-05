package com.wsp.pages;

import com.wsp.driver.DriverManager;
import com.wsp.reports.ExtentLogger;
import org.openqa.selenium.By;

import static com.wsp.utils.SeleniumUtils.*;


public class ConfirmationPage {

    private static final By getPrice = By.xpath("(//div[@id='totalAmount']//label)[2]");

    public String getTotalPrice() {
        waitUntilElementToBeVisible(getPrice);
        String price=DriverManager.getDriver().findElement(By.xpath("(//div[@id='totalAmount']//label)[2]")).getText();
        ExtentLogger.pass("The final flight fare including tax is:"+price);
        return price;
    }

}
