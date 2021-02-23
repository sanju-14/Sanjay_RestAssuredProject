package com.arikshaalertingsystem.scripts;

import org.testng.annotations.Test;
import com.arikshaalertingsystem.generic.BaseApiClass;
import com.arikshaalertingsystem.generic.EndPoints;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;

/**
 * 
 * @author Sanjay
 *
 */

public class ReadOrganization extends BaseApiClass {

	@Test

	public void readOrg() throws Throwable {

		given()
		.queryParam("org_id", "Sanju14")

				.when().get(EndPoints.Organization)

				.then().assertThat().statusCode(200)
				.assertThat().contentType(ContentType.JSON)
				.log().all();

	}

}
