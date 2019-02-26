/*
 * This class covers:
 * Setup & tearDown methods for Chrome Browser launch
 * priority, groups, enabled keywords
 * View TestNG report using index file
 * 
 * Priority Tips:
 * 1. It run lowest no priority test first means (Ex. -10,-6,-1,0,1,5,9, etc)
 * 2. In case of same priority it consider in alphabetical order.
 * 3. No method with priority than run in alphabetical order.
 * 4. If class has some test with priority and some with non priority then it will run non priority test first.
 * 
 * Groups Tips:
 * 1. We can create group at class level or test level than include and exclude them in testng file.
 * 2. We can use regular expression also in testng file ...see tetng2.xml 
 * 
 * Ignore
 * We can use ignore annotation at
 * Test level
 * Class Level
 * Package level - For this create "package-info.java" - for creating this ...select rot package ->right click->
 * create package with same name and click package-info.java check box.
 
 */

package testNGTesing;


import org.testng.annotations.*;

//@Ignore
@Test(groups = "AllClassTests")
public class GoogleTest_Priority_Groups_Enabled_Ignore {
	
		
   @BeforeMethod
	public void setUP() {
	   
	}
   
   @Ignore
   @Test  (priority =1,groups = {"windows.Regression", "Sanity"}, enabled=true)
   public void googleTittleTest() {
	   System.out.println("Test 1");
   }
   
   @Test (priority =2, groups ="image element test",enabled=false)
   public void googleLogoTest() {
		  System.out.println("Test 2");
	  
   }
   
   @Test (priority =3)
   public void maillinkTest() {
	   System.out.println("Test 3");;
   }
   
    
   @Test (priority =4,groups ="linux.Regression")
   public void test4() {
	   System.out.println("test 4");
   }
   
   @Test (priority =5,groups = {"Function Test", "Sanity", "Title"})
   public void test5() {
	   System.out.println("test 5");
   }
   
   @Test (priority =6,groups ="Search Page Test Case")
   public void test6() {
	   System.out.println("test 6");
   }
   
   @AfterMethod
   public void tearDown() {
	 //  driver.quit();
   }

}
