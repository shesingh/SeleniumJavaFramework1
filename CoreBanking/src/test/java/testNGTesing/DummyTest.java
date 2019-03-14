/*
 * This class covers:
 * This is Dummy test to help in copy paste for new test.
 */

package testNGTesing;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import library.SetupBase;

public class DummyTest extends SetupBase{
	
	
	  static String projectPath = System.getProperty("user.dir");
	  
		
		@BeforeClass
		public void startReport() {			
	    }
		
		
		@BeforeMethod
		public void setup() {
			SetupBase.initialization();
			}
		
		@Test
		public static void main() {
			
		 System.out.println("DONE");
		 driver.get("http://www.google.com/");
			
		}
		
		@AfterMethod
		   public void tearDown() { 
			driver.quit();
			}

		
		@AfterClass
		public void end() {
			
	    }
	}



