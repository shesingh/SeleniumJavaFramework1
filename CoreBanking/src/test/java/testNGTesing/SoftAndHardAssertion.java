/*
 * This class covers:
 * soft and hard assertion
 */

package testNGTesing;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAndHardAssertion {

	
	
	@Test
	public void test1() {
		SoftAssert softAssert = new SoftAssert();
		System.out.println("Open Browser");
		
		//hard assertion - Means test case will fail and terminated and following code will not be executed
		Assert.assertEquals(true, true);
		
		System.out.println("enter username");
		System.out.println("enter password");
		System.out.println("click on signin button");
		
		Assert.assertEquals(true, true);
		
		System.out.println("validate home page");
		//Soft Assertion - Even if this is fail test will PASS
		softAssert.assertEquals(true, false, "home page title is wrong");
		
		System.out.println("Go to deal page");
		System.out.println("create a deal");
		softAssert.assertEquals(true, false, "not able to create deal");
		
		System.out.println("Go to contact page");
		System.out.println("create a contact");
		softAssert.assertEquals(true, false);
		
		//This step will mark test case fail if any of the soft assert is fail.
		//This required if we want to fail test case in case of soft assert is failing but we want to run complete test case.
		softAssert.assertAll();
	}
	
	@Test
	public void test2() {
		SoftAssert softAssert2 = new SoftAssert();
		
		System.out.println("logout");
		softAssert2.assertEquals(true, true);
		
		softAssert2.assertAll();
	}
	
	/* Write softAssert.assertAll(); in each test case not in @AfterMethod. Otherwise
	 * it will Pass the test case but fail the assert.
	 * 
	 * We have to create SoftAssert object in each test other wise if Test 1 softassert is failed 
	 * it is going to fail test also fail because in this case information is in same object.
	 */
	
}
