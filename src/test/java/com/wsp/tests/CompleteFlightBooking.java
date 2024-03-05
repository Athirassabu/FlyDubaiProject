package com.wsp.tests;

import com.wsp.annotations.FrameworkAnnotation;
import com.wsp.data.BaseTest;
import com.wsp.pages.BookFlightHomePage;
import com.wsp.pages.FlightDetailsPage;
import com.wsp.testdata.TestData;
import com.wsp.utils.DataProviderUtils;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CompleteFlightBooking extends BaseTest {
    SoftAssert softassert = new SoftAssert();
    BookFlightHomePage bhp=new BookFlightHomePage();
    FlightDetailsPage fdp=new FlightDetailsPage();


    @FrameworkAnnotation
    @Test(description = "To check complete flight booking flow",
            dataProvider = "getData", dataProviderClass = DataProviderUtils.class)
    public void completeFlightJourney(TestData testdata) {
       bhp.acceptCookies().selectDestination().clickDateRange().clickSearch().clickLowFare().getPrice();
       fdp.clickContinuePassengerDetails();

    }
}