package com.wsp.pages;

import com.wsp.config.ConfigFactory;
import com.wsp.driver.Driver;
import com.wsp.driver.DriverManager;
import com.wsp.reports.ExtentLogger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static com.google.common.util.concurrent.Futures.withTimeout;
import static com.wsp.driver.DriverManager.getDriver;
import static com.wsp.utils.SeleniumUtils.click;
import static com.wsp.utils.SeleniumUtils.sendKeys;


public class SummaryPage {

    String location = System.getProperty("user.dir") + "/src/test/resources/DownloadFiles";
    public static String download;

    private static final By nextButton = By.xpath("//button[@class='button button-next is-primary is-expanded']");
    private static final By clickGenerateInvoice = By.xpath("//button[@class='button is-fullwidth payment-button']//span[text()='Generate Invoice']");
    private static final By enterPaymentReference = By.xpath("//input[@class='input is-success']");
    private static final By clickContinue = By.xpath("//button[@class='button is-fullwidth is-primary payment-button']");
    private static final By clickDownload = By.xpath("//button[@class='button coiButton']");

    public SummaryPage clickNextButton() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(ConfigFactory.getConfig().timeout()));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("loading-background")));
        click(nextButton, "Next button");
        return this;
    }


    public SummaryPage clickGenerateInvoice() {

        click(clickGenerateInvoice, "Generate Invoice");
        sendKeys(enterPaymentReference, "12345", "PaymentReference");
        click(clickContinue, "Continue button");
        return this;
    }

    public SummaryPage clickDownload() {

        click(clickDownload, "Download button");
        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(DriverManager.getDriver());
        wait.withTimeout(Duration.ofMinutes(5))
                .pollingEvery(Duration.ofSeconds(2));
        wait.until(x -> {
            File folder = new File(location);
            File[] filesInDir = folder.listFiles();
            for (File fileInDir : filesInDir) {
                if (fileInDir.getName().startsWith("COI-UAE")) {
                    ExtentLogger.pass("File is downloaded successfully and waited until its downloaded using fluent wait");
                    return true;
                }
            }
            return false;
        });
        File folder = new File(location);
        File[] listofFiles = folder.listFiles();
        for (File listofFile : listofFiles) {
            if (listofFile.isFile()) {
                String fileName = listofFile.getName();
                download = System.getProperty("user.dir") + "/src/test/resources/DownloadFiles/" + fileName + "";
                ExtentLogger.pass("Downloaded file name :" + fileName + " Downloaded file is available in location:" + location);
            }
        }

        return this;

    }

    public boolean isFileAvailable() {
        File folder = new File(location);
        File[] listofFiles = folder.listFiles();
        boolean isFileAvailable = false;
        for (File listofFile : listofFiles) {
            if (listofFile.isFile()) {
                String fileName = listofFile.getName();
                if (fileName.contains("COI-UAE")) {
                    isFileAvailable = true;
                }
            }
        }
        return isFileAvailable;
    }
}
