package com.wsp.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.HashMap;
import java.util.Map;

public final class DriverFactory {

    private DriverFactory(){}

    public static WebDriver getDriver(String browserName){
        WebDriver driver;
        String location=System.getProperty("user.dir")+"/src/test/resources/DownloadFiles";

        if(browserName.equalsIgnoreCase("chrome")) {

            HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
            chromePrefs.put("download.default_directory",location);
            ChromeOptions options = new ChromeOptions();
          //  options.setExperimentalOption("prefs", chromePrefs);
            //options.addArguments("disable-notifications");
            options.addArguments("--disable-cookies");
            //options.addArguments("profile.default_content_setting_values.cookies", 2);
            driver = new ChromeDriver(options);



        }
        else if(browserName.equalsIgnoreCase("edge")){

            HashMap<String, Object> edgePrefs= new HashMap<String, Object>();
            edgePrefs.put("download.default_directory",location);
            EdgeOptions options = new EdgeOptions();
            options.setExperimentalOption("prefs", edgePrefs);
            driver = new EdgeDriver(options);
        }
        else {
            FirefoxOptions options = new FirefoxOptions();
            options.addPreference("browser.download.dir",location);
            options.addPreference("browser.download.folderList",2);
            options.addPreference("browser.helperApps.neverAsk.saveToDisk", "application/octet-stream");
            driver = new FirefoxDriver(options);
        }
        return driver;
    }
}
