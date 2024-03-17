package com.wsp.tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wsp.annotations.FrameworkAnnotation;
import com.wsp.data.BaseTest;
import com.wsp.endpoints.UserEndPoints;
import com.wsp.pages.BookFlightHomePage;
import com.wsp.pages.PassengerDetailsPage;
import com.wsp.payload.Root;
import com.wsp.payload.SearchCriterium;
import com.wsp.testdata.TestData;
import com.wsp.utils.DataProviderUtils;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ApiFlightBooking extends BaseTest {
    SoftAssert softassert = new SoftAssert();


    @FrameworkAnnotation
    @Test(description = "To check complete flight booking flow for fly dubai",
            dataProvider = "getData", dataProviderClass = DataProviderUtils.class)
    public void completeFlightJourneyApi(TestData testdata) throws IOException {
        ObjectMapper objectMapper=new ObjectMapper();
        Root root=objectMapper.readValue(new File("src/test/resources/sample.json"), Root.class);
        List<SearchCriterium> searchCr=new ArrayList<SearchCriterium>();
        SearchCriterium search1=new SearchCriterium();
        search1.setDate(testdata.originMonth);
        search1.setDirection(testdata.direction);
        search1.setIsDestMetro(false);
        search1.setIsOriginMetro(true);
        search1.setOrigin(testdata.originCity);
        search1.setDest(testdata.destinationCity);
        searchCr.add(search1);
        root.setSearchCriteria(searchCr);
        String responses= objectMapper.writeValueAsString(root);
        Response response= UserEndPoints.createUser(responses);
        Assert.assertEquals(response.getStatusCode(),200);

    }
}