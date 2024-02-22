package com.wsp.pages;

import com.wsp.config.ConfigFactory;
import com.wsp.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.wsp.utils.SeleniumUtils.*;


public class InformationPage {

    private static final By clickDOBfield = By.xpath("//input[@data-e2e='field-insured_age']");

    private static final By year = By.xpath("(//span[@class='select'])[2]//select//option[@value='1994']");
    private static final By month = By.xpath("(//span[@class='select'])[1]//select//option[@value='2']");
    private static final By date = By.xpath("(//div[@class='datepicker-row']//following::span[text()='8'])[1]");
    private static final By salaryRange = By.xpath("//span[text()='AED 10,001 - AED 20,000']");
    private static final By nextButton = By.xpath("//button[@class='button button-next is-primary is-expanded']");
    public String getTitleTest(){
        getTitle(DriverManager.getDriver().getTitle());
        return DriverManager.getDriver().getTitle();
    }
   public InformationPage selectDOB(String m,String y,String d) {
        DriverManager.getDriver().manage().window().fullscreen();
       WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(ConfigFactory.getConfig().timeout()));
      wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("loading-background")));
       click(clickDOBfield, "DOB text box");
      By year = By.xpath("(//span[@class='select'])[2]//select//option[@value='"+y+"']");
      By month = By.xpath("(//span[@class='select'])[1]//select//option[@value='"+m+"']");
      By date = By.xpath("(//div[@class='datepicker-row']//following::span[text()='"+d+"'])[1]");
       click(month,"Month");
       click(year,"Year");
       click(date,"Date");
       return this;
   }
    public InformationPage selectSalaryRange(String sal)
    {
        By salaryRange = By.xpath("//span[text()='"+sal+"']");
        click(salaryRange,"Salary range");
        return this;
    }
    public YourQuotePage clickNextButton()
    {
        click(nextButton,"Next button");
        return new YourQuotePage();
    }
}
