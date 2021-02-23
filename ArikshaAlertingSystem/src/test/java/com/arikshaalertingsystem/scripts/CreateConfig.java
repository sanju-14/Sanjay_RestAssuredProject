package com.arikshaalertingsystem.scripts;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import com.arikshaalertingsystem.generic.BaseApiClass;
import com.arikshaalertingsystem.generic.EndPoints;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

/**
 * 
 * @author Sanjay
 *
 */

public class CreateConfig extends BaseApiClass {

	@Test

	public void createConfiguration() throws Throwable {

		JSONObject obj = new JSONObject();
		obj.put("org_id", "acer44");
		obj.put("config_key", "acer");
		obj.put("config_value", "Acer");

		Response resp = given()
				.contentType(ContentType.JSON)
				.body(obj)
				.when()
				.post(EndPoints.Configuration);

		resp.then()
		.assertThat().statusCode(200)
		.assertThat().time(Matchers.lessThan(2000l))
		.log().all();

	}

}
