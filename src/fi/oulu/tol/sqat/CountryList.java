package fi.oulu.tol.sqat;

import java.util.Arrays;
import java.util.List;

//Stub class for service which gives the list for valid countries

public class CountryList {
	public List<String> getCountries(){
		List<String> coutries = Arrays.asList("Finland", "Estonia", "Sweden", "USA", "Russia");
		return coutries;
		
	}
}
