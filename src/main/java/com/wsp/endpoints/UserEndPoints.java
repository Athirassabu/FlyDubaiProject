package com.wsp.endpoints;

import static io.restassured.RestAssured.given;

import com.wsp.reports.ExtentLogger;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


//UserEndPints.java
// Created for perform Create, Read, Update, Delete requests t the user API.

public class UserEndPoints {

		public static Response createUser(String payload)
		{
			Response response=given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload).log().all()
			.when()
				.post(Routes.post_url);
			ExtentLogger.pass("The status of the request is:"+response.statusCode());
			ExtentLogger.pass("Payload passed is"+payload);
			ExtentLogger.pass("Security token from response is : "+response.header("securityToken"));
			ExtentLogger.pass("Response payload is"+response.asString());
			return response;
		}
		
		

}
