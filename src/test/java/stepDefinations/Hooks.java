package stepDefinations;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {
	
	@Before("@DeletePlace")
	public void beforeScenario() throws IOException {
		placeValidationDefination p = new placeValidationDefination();
		if(placeValidationDefination.place_id == null) {
			p.add_place_payload_with("dileep", "English", "Srinivasa Nagar");
			p.user_call_using_http_request("AddPlaceAPI", "post");
			p.verify_the_place_id_to_create_maps_to_using_get_place("dileep", "GetPlaceAPI");
		}
		
	}

}
