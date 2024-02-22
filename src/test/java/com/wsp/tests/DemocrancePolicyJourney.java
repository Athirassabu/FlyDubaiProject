package com.wsp.tests;

import com.wsp.annotations.FrameworkAnnotation;
import com.wsp.data.BaseTest;
import com.wsp.pages.InformationPage;
import com.wsp.testdata.TestData;
import com.wsp.utils.DataProviderUtils;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class DemocrancePolicyJourney extends BaseTest {
    SoftAssert softassert = new SoftAssert();
    InformationPage infoPage = new InformationPage();

    @FrameworkAnnotation
    @Test(description = "To check Democrance policy sales journey complete flow",
            dataProvider = "getData", dataProviderClass = DataProviderUtils.class)
    public void completePolicySalesJourney(TestData testdata) {
        String actualTitle = infoPage.getTitleTest();
        boolean isFileAvailable = infoPage.selectDOB(testdata.month, testdata.year, testdata.date).selectSalaryRange(testdata.salary).clickNextButton().clickTermsCondition().clickNextButton().clickTitle(testdata.title).enterFullName(testdata.name).selectNationality(testdata.nation).enterEmail(testdata.email).enterMobile(testdata.phone).enterEmiratesId(testdata.emiratesId).clickEmiratesIdExpiryDate(testdata.emiratesIdMonth, testdata.emiratesIdYear, testdata.emiratesIdDate).clickNextButton().clickNextButton().clickGenerateInvoice().clickDownload().isFileAvailable();
        softassert.assertEquals(actualTitle, testdata.expectedTitle);
        softassert.assertTrue(isFileAvailable, "Download file is available");
        softassert.assertAll();

    }
}