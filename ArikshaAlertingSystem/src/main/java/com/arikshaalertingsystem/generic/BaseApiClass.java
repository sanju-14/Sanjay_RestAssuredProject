package com.arikshaalertingsystem.generic;

import java.sql.SQLException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static io.restassured.RestAssured.*;

public class BaseApiClass {
	
	@BeforeSuite
	public void configBeforeSuite() {
		baseURI = "http://3.133.96.56";
		port = 8000;
		
		//DataBaseUtilities.connectToDB();
	}
	
	@AfterSuite
	public void configAfterSuite() throws SQLException {
		//DataBaseUtilities.closeDb();
	}

}
