package stepDefinations;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

import java.io.IOException;

import resources.APIResources;
import resources.Utils;
import resources.testDataBuild;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class placeValidationDefination extends Utils {
	
	RequestSpecification res;
	Response response;
	testDataBuild data = new testDataBuild();
	static String place_id;
	
	

	@Given("Add place payload with {string} {string} {string}")
	public void add_place_payload_with(String name, String language, String address) throws IOException {
		
		res = given().log().all().spec(requestSpecifications()).body(data.addPlace(name,language,address));
    }

	@When("user call {string} using {string} http request")
	public void user_call_using_http_request(String resource, String httpMethod) throws IOException {
    	
    	APIResources resourceAPI = APIResources.valueOf(resource);
    	
    	if(httpMethod.equalsIgnoreCase("post"))
    	response = res.when().post(resourceAPI.getResource()).then().extract().response();
    	else if(httpMethod.equalsIgnoreCase("get"))
    	response = res.when().get(resourceAPI.getResource()).then().extract().response();
		
        
    }

    @Then("the API call is success with status code {int}")
    public void the_api_call_is_success_with_status_code_something(Integer int1) throws Throwable {
    	assertEquals(response.getStatusCode(),200);
        
    }

    @Then("{string} in response body is {string}")
    public void something_in_response_body_is_something(String keyValue, String expectedValue) throws Throwable {
    	
    	
    	assertEquals(getJsonPath(response,keyValue),expectedValue);
    	
    	
    }
    
    @Then("verify the place_id to create maps to {string} using {string}")
    public void verify_the_place_id_to_create_maps_to_using_get_place(String ExpectedName, String resource) throws IOException {
    	place_id = getJsonPath(response,"place_id");
    	res = given().spec(requestSpecifications()).queryParam("place_id", place_id);
    	user_call_using_http_request(resource, "get");
    	String ActualName = getJsonPath(response,"name");
    	assertEquals(ActualName,ExpectedName);
    	    
    }
    
    //delete place API
    
    @Given("Delete Place payload")
    public void delete_place_payload() throws IOException {		
		
		res = given().spec(requestSpecifications()).body(data.deletePlaceID(place_id));
		System.out.println("practicing git");
		System.out.println("making changes in code");
		System.out.println("making changin in develop branch");
    }

}