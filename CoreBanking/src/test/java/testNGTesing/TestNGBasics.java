/*
 * This class covers:
 * 
 * Press ctrl + space Key to complete the word.
 * 
 * All 4 @Brfore Annotation 
 * Test Annotation
 * All 4 @After Annotation
 * Note - In practical we only use @BeforeMethod or @AfterMethod
 */

package testNGTesing;

import org.testng.annotations.*;

public class TestNGBasics {
	
	//Precondition annotations --Starting with @Before
	@BeforeSuite  //1
	public void setUp() {
		System.out.println("@BeforeSuite - setup system property for chrome");
		
	}
	
	@BeforeTest  //2
	public void launchBrowser() {
		System.out.println("@BeforeTest - launch browser");
		
	}
	
	@BeforeClass //3
	public void login() {
		System.out.println("@BeforeClass - login");
		
	}

	@BeforeMethod //4
	public void enterURL() {
		System.out.println("@BeforeMethod - Enter URL");
		
	}
	
	/*
	 * It is going to run @BeforeMehod before each test case and @AfterMethod after each test case.
	 */
	
		//test cases --starting with @Test
	@Test //5.1
	public void googleTitleTest() {
		System.out.println("TEST CASE 1 - Google Title Test");
		
	}
	
	@Test //5.2
	public void searchTest() {
		System.out.println("TEST CASE 2 - search test");
		
	}
	
	//Post conditions annotations --Starting with @After
	@AfterMethod //6
	public void logout() {
		System.out.println("@AfterMethod - logout");
		
	}
	
	@AfterClass //7
	public void closeBrowser() {
		System.out.println("@AfterClass - Close Browser");
		
	}
	
	@AfterTest //8
	public void deleteAllCookies() {
		System.out.println("@AfterTest - Delete All Cookies");
		
	}
	@AfterSuite //9
	public void generateTestReport() {
		System.out.println("@AfterSuite - Generate test report");
		
	}
	
}
