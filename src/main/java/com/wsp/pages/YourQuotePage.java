package com.wsp.pages;

import com.wsp.config.ConfigFactory;
import com.wsp.driver.DriverManager;
import com.wsp.reports.ExtentLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.wsp.driver.DriverManager.getDriver;
import static com.wsp.utils.SeleniumUtils.*;


public class YourQuotePage {

    private static final By termsConditionFirst = By.xpath("(//input[@type='checkbox'])[1]");
    private static final By termsConditionSecond = By.xpath("(//input[@type='checkbox'])[2]");
    private static final By nextButton = By.xpath("//button[text()='Next: Policy issuance and Payment']");
    public YourQuotePage clickTermsCondition()
    {
        WebElement termsConditionFirst = getDriver().findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        WebElement termsConditionSecond = getDriver().findElement(By.xpath("(//input[@type='checkbox'])[2]"));
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].click();", termsConditionFirst);
        ExtentLogger.pass("First terms and condition is clicked successfully");
        executor.executeScript("arguments[0].click();", termsConditionSecond);
        ExtentLogger.pass("Second terms and condition is clicked successfully");
        return this;
    }
    public PolicyIssuancePaymentPage clickNextButton()
    {
        DriverManager.getDriver().manage().window().fullscreen();
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(),Duration.ofSeconds(ConfigFactory.getConfig().timeout()));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("loading-background")));
        click(nextButton,"Next button");
        return new PolicyIssuancePaymentPage();
    }

}
