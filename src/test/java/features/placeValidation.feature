Feature: Validation place API's

@AddPlace
Scenario Outline: Verify if place is being addedd using AddPlaceAPI
	Given Add place payload with "<name>" "<language>" "<address>"
	When user call "AddPlaceAPI" using "post" http request
	Then the API call is success with status code 200
	And "status" in response body is "OK"
	And "scope" in response body is "APP"
	And verify the place_id to create maps to "<name>" using "GetPlaceAPI" 
	
Examples:
	|name  			|  language	| address  						|
	|BBQGrill		| French		| Italy France				|
	|BBQ				| Rome			| Rome France					|
	
@DeletePlace
Scenario: Verify if Delete place API is working
	Given Delete Place payload
	When user call "DeletePlaceAPI" using "post" http request
	Then the API call is success with status code 200
	And "status" in response body is "OK"
	
	
 