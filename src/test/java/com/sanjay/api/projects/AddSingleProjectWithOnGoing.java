package com.sanjay.api.projects;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;
import com.sanjay.api.genericUtils.BaseApiClass;
import com.sanjay.api.genericUtils.DataBaseUtilities;
import com.sanjay.api.genericUtils.EndPoints;
import com.sanjay.api.pojoclass.Project;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Random;

public class AddSingleProjectWithOnGoing extends BaseApiClass{
	
	@Test
	public void createProjectWithCreatedStatus() throws Throwable {
		   int random = new Random().nextInt(2000);
		   Project projectObj = new Project("Deepak", "Grape-"+random, "On Going", 10);
		Response resp = given()
						  .contentType(ContentType.JSON)
						  .body(projectObj)
					   .when()
					   .post(EndPoints.addPRojecttest);
						
					   resp.then()
					      .assertThat().statusCode(201)
					      .log().all();
					   
					   String actMsg = resp.jsonPath().get("msg");
					   System.out.println(actMsg);
					   
					   String apiProjectID = resp.jsonPath().get("projectId");
					   System.out.println(apiProjectID);
					   
					   String dbProjectID = DataBaseUtilities.executeQueryAndGetData("select * from project", 1, apiProjectID);
						
						Assert.assertEquals(dbProjectID, apiProjectID);
					   
					
	      
	}

}
