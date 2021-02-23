package com.arikshaalertingsystem.scripts;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import com.arikshaalertingsystem.generic.BaseApiClass;
import com.arikshaalertingsystem.generic.EndPoints;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

/**
 * 
 * @author Sanjay
 *
 */

public class ReadConfigUsingConfigkey extends BaseApiClass {

	@Test

	public void readConfigurationUsingConfigKey() throws Throwable {

		Response resp = given()
				.pathParam("config_key", "dell1")
				.queryParam("org_id", "dell44")
				
				.when()
				.get(EndPoints.ConfigKey);

		resp.then()
		.log().all()
		.assertThat().statusCode(200);
		

	}

}
