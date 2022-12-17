package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.AddPlace;
import pojo.addPlaceLocation;

public class testDataBuild {
	
	public AddPlace addPlace(String name, String language, String address) {
		AddPlace a = new AddPlace();
		addPlaceLocation l = new addPlaceLocation();
		List<String> myList = new ArrayList<String>();
		myList.add("shoe park");
		myList.add("shop");
		
		l.setLat(-38.383494);
		l.setLng(33.427362);
		a.setAccuracy(50);
		a.setAddress(address);
		a.setLanguage(language);
		a.setLocation(l);
		a.setName(name);
		a.setPhone_number("(+91) 983 893 3937");
		a.setWebsite("http://google.com");
		a.setTypes(myList);
		return a;
	}
	
	public String deletePlaceID(String place_id) {
		
		return "{\r\n"
				+ "    \"place_id\":\""+place_id+"\"\r\n"
				+ "}";
		
	}

}
