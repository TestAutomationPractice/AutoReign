package com.crm.qa.testcases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.utility.TestUtil;

import junit.framework.Assert;

public class HomePageTest extends TestBase
{
	HomePage homepage;
	String sheet_name="movie_details";
	
	public HomePageTest()
	{
	super();
	}

	
	@DataProvider
	public Object[][] getMovieTestData()
	{
		System.out.println("In the getCRMTestData method");
		
		Object data[][] = TestUtil.getTestData(sheet_name);
		
		System.out.println("Data is retrieved successfully");
		return data;
	}
	
  	@Test(priority=1, dataProvider="getMovieTestData")
	public void addMovieDetailsTest(String title, String director, String description, String category, String url, String rating)
	{
  		homepage = new HomePage();
		
		homepage.addMovieDetails(title, director, description, category, url, rating);
	}
	
}


