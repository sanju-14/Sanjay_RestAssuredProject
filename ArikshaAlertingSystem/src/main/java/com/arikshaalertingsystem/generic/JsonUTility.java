package com.arikshaalertingsystem.generic;

import io.restassured.response.Response;

public class JsonUTility {
	
	public String getJSonPath(String jsonXpath, Response resp) {
		
		      String jsonData = resp.jsonPath().get(jsonXpath);
		return jsonData;
		
	}

}
