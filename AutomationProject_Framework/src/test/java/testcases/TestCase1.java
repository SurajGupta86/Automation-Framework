package testcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.Test;

public class TestCase1 {
	
	@BeforeTest    //It will run once before the BeforeMethod and all the methods(@Test)
	public void Open() {
		System.out.println("Click on the URL to access flipkart\n");
	}
	
	@AfterTest   //It will run once after the AfterMethod and all the methods(@Test)
	public void Close() {
		System.out.println("Close the flipkart application\n");
	}
	
	@BeforeMethod  //It will run before all the methods(@Test) start
	public void Login() {
		System.out.println("Login into the flipkart portal");
	}
	
	@Test(priority=1)
	public void Search() {
		
		System.out.println("Search for a smartphone");
		System.out.println("Not like it, so will log-out");
		AssertJUnit.assertEquals(true, true);
	}
	
	@Test(priority=2, dependsOnMethods="Search")
	public void Buy() {
		System.out.println("Search for a watch");
		System.out.println("Purchase a watch");
		System.out.println("Payment done and order successful");
	}
	
	@AfterMethod     //It will run after all the methods(@Test) start
	public void LogOut() {
		System.out.println("LogOut from the flipkart application\n");
	}
	
}
