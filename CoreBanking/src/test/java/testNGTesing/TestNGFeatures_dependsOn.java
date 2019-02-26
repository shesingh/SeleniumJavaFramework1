/*
 * This class covers:
 * dependsOnMethod keyword
 * invocationCount - This is for knowledge, no use in practical
 * expectedExceptions - This is for knowledge, no use in practical --
 *                      Passing test case even if there is suggested exception. or 
 *                      Managing exception without Try Catch
 *                      
 * If priority & dependency both are set then dependency will take preference.
 */
package testNGTesing;

import org.testng.annotations.Test;

public class TestNGFeatures_dependsOn {

	
	
	@Test
	public void loginTest() {
		System.out.println("login test");
	}
	
	@Test(dependsOnMethods="loginTest", groups ="group2")
	public void homePageTest() {
		System.out.println("Home Page test");
	}
	
	@Test(dependsOnMethods="loginTest", groups= {"group1"})
	public void searchPageTest() {
		System.out.println("Search Page test");
		
	}
	
	@Test(dependsOnGroups="group.*")
	public void registrationPageTest() {
		System.out.println("Registration Page test");
	}
	
	/*
	 
	@Test (invocationCount=10)
	public void sum() {
		int a = 10;
		int b = 20;
		int c = a+b;
		System.out.println("SUM is : "+c);
	}
	
	
	@Test (invocationTimeOut=2000) // time out value is set to 2 seconds
	public void infiniteLoopTest() {
		int i=1;
		while(i==1)
		{ 
			System.out.println("Count is now :  "+i);
		}
	}
	
	
	@Test(expectedExceptions=NumberFormatException.class)
	public void exceptionExpectedTest() {
		String x = "100A";
		Integer.parseInt(x);
		System.out.println("exceptionExpectedTest");
		System.out.println("Number is :  "+x);
	}
	
	*/
}
