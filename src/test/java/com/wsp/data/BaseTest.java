package com.wsp.data;

import com.wsp.driver.Driver;
import org.apache.commons.io.FileUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;

public class BaseTest {
    String location=System.getProperty("user.dir")+"/src/test/resources/DownloadFiles";
@BeforeTest
public void cleanFolder()
{
    File directory=new File(location);
    try {
        FileUtils.cleanDirectory(directory);
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
}

    @BeforeMethod
    public void setUp() {
        Driver.initDriver();
    }

    @AfterMethod
    public void tearDown() {
        Driver.quitDriver();
    }

}
