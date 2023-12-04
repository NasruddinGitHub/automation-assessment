package com.automation.assessment.testclasses;

import java.util.Properties;

import org.testng.annotations.Test;

import com.automation.assessment.hooks.ApplicationHooks;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class ApiTest {

	@Test
	public void validateResponseOfNetworkApi() {
		RestAssured.baseURI = "https://api.citybik.es";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get("/v2/networks");
		ResponseBody<?> body = response.getBody();
		JsonPath jsonPath = response.jsonPath();
		System.out.println(body.asPrettyString());
		System.out.println(jsonPath.getString("networks[1].location.latitude"));
		System.out.println(jsonPath.getString("networks[1].location.longitude"));
		
	}

}
