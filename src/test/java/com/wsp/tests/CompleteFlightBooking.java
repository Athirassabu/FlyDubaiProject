package com.wsp.tests;

import com.wsp.annotations.FrameworkAnnotation;
import com.wsp.data.BaseTest;
import com.wsp.pages.BookFlightHomePage;
import com.wsp.pages.FlightDetailsPage;
import com.wsp.pages.PassengerDetailsPage;
import com.wsp.testdata.TestData;
import com.wsp.utils.DataProviderUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CompleteFlightBooking extends BaseTest {
    SoftAssert softassert = new SoftAssert();
    BookFlightHomePage bhp=new BookFlightHomePage();
    PassengerDetailsPage pdp=new PassengerDetailsPage();


    @FrameworkAnnotation
    @Test(description = "To check complete flight booking flow",
            dataProvider = "getData", dataProviderClass = DataProviderUtils.class)
    public void completeFlightJourney(TestData testdata) {
        bhp.acceptCookies().selectOrigin(testdata.originCity).selectDestination(testdata.destinationCity).clickOriginDateRange(testdata.originMonth,testdata.originYear, testdata.originDate).clickDestinationDate(testdata.destMonth,testdata.destYear,testdata.destDate).clickSearch().clickLowFare().clickContinuePassengerDetails().enterPassengerDetails(testdata.firstName,testdata.lastName,testdata.email,testdata.gender,testdata.country,testdata.number);
       String price= pdp.getPrice().substring(4);
       String finalPrice=pdp.clickReviewBooking().getTotalPrice();
        Assert.assertEquals(price,finalPrice);

    }
}