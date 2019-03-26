/* This test covers:
 * Parameters are coming from Testng file in src/test/resources
 * 
 * Tip:
 * 1. In testng file if we define parameters are suite level ...All the tests are going to get the value.
 * and if we define at test level than only that test is going to get the value
 * 
 * If two parameters have the same name, it's the one defined in test that has precedence. 
This is convenient if you need to specify a parameter applicable to all your tests and override its value only for certain tests.
 * 
 * 2. We can mark parameter as optional.
 * 
 * 3. We can use @parameter in class constructor or with @Test, @Before/after, @Factory
 */

package testNGTesing;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNGParametersDemo {
	
	// parameters are coming from testng file
	@Test
	@Parameters({"MyName"})
	public void test1(String name) {
		System.out.println("Name is : "+name);
	}

	
	@Test
	@Parameters({"MyName2"})
	public void test2(@Optional("Shefali") String name2) {
		System.out.println("Name is : "+name2);
	}
}
