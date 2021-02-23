package com.arikshaalertingsystem.scripts;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import com.arikshaalertingsystem.generic.BaseApiClass;
import com.arikshaalertingsystem.generic.EndPoints;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

/**
 * 
 * @author Sanjay Gond
 *
 */

public class ReadConfigUsingConfigkey extends BaseApiClass {

	@Test

	public void readConfiguration() throws Throwable {

		Response resp = given()
				.queryParam("org_id", "dell44")
				
				.when()
				.get(EndPoints.Configuration);

		resp.then()
		.log().all()
		.assertThat().statusCode(200)
		.assertThat().time(Matchers.lessThan(1200l));
		

	}

}
