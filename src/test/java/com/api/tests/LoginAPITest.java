package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class LoginAPITest {
	
	@Test(description = "Verify if Login API is working...")
	public void loginTest() {
		RestAssured.baseURI = "http://64.227.160.186:8080";
		RequestSpecification x = RestAssured.given().header("Content-Type","application/json");
		RequestSpecification y = x.body("{\r\n"
				+ "  \"username\": \"Raubin\",\r\n"
				+ "  \"password\": \"Munna@4457\"\r\n"
				+ "}");
		Response response = y.post("/api/auth/login");
		System.out.println(response.asPrettyString());
		Assert.assertEquals(response.getStatusCode(), 200);
	}

}
