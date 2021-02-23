package com.arikshaalertingsystem.scripts;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import com.arikshaalertingsystem.generic.BaseApiClass;
import com.arikshaalertingsystem.generic.EndPoints;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

/**
 * 
 * @author Sanjay Gond
 *
 */

public class CreateOrganization extends BaseApiClass {

	@Test

	public void createOrg() throws Throwable {

		JSONObject obj = new JSONObject();
		obj.put("org_id", "dell44");
		obj.put("org_name", "Dell Company");

		Response resp = given()
				.contentType(ContentType.JSON)
				.body(obj)
				.when()
				.post(EndPoints.Organization);
		resp.then().assertThat().statusCode(200).log().all();

	}

}
