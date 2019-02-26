/*
 * This class covers:
 * Use Ctrl+Shift+O key to do all the required imports
 * Corresponding log4j2.properties file is available in src/test/resources
 * It is going to show trace also because logger.file.level = trace & rootLogger.level = trace is set.
 * Log file is created at appender.file.fileName=${filename}/Mylogs.log where
 * ${filename} is coming from property.filename = logs log file.
 * 
 * ALso in property file, we have to enter package name...logger.file.name=testNGTesing 
 * 
 * 
 * Log4j - log levels

TRACE
Most detailed information. Expect these to be written to logs only. Since version 1.2.12

DEBUG
Detailed information on the flow through the system. Expect these to be written to logs only. Generally speaking, most lines logged by your application should be written as DEBUG

INFO
Interesting runtime events (startup/shutdown). Expect these to be immediately visible on a console, so be conservative and keep to a minimum.

WARN
Use of deprecated APIs, poor use of API, 'almost' errors, other runtime situations that are undesirable or unexpected, but not necessarily "wrong". Expect these to be immediately visible on a status console.

ERROR
Other runtime errors or unexpected conditions. Expect these to be immediately visible on a status console.

FATAL
Severe errors that cause premature termination. Expect these to be immediately visible on a status console.

OFF
The highest possible rank and is intended to turn off logging.




Note- Enter log path & log file name in XML or .properties file.
In my case relative path name is logs and file name is "Mylogs" in properties and "MyLogsFromXML" in xml file

Also in Logger section we have to give the test class package name if required. and logging level ...which is Trace or Debug etc
 */

package testNGTesing;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class Log4jDemo {
	
	//static String projectPath = System.getProperty("user.dir");
	static Logger logger = LogManager.getLogger(Log4jDemo.class);
	
		
	@BeforeMethod
	public void setUP() {
		
		System.out.println("\n Before Method \n");
		logger.trace("This is Trace message - Test 1");
		logger.info("This is information message - Before Method");
		logger.error("This is error message - Before Method");
		logger.warn("This is warning message- Before Method");
		logger.fatal("This is fatal message- Before Method");
		System.out.println("\n Completed \n");
		
    }
	
	@Test
	public static void test1() {
		
		System.out.println("\n Hello World -Test 1 \n");
		logger.trace("This is Trace message - Test 1");
		logger.info("This is information message - Test 1");
		logger.error("This is error message  - Test 1");
		logger.warn("This is warning message  - Test 1");
		logger.fatal("This is fatal message  - Test 1");
		System.out.println("\n Completed \n");
	
	}

	@Test
	public static void test2() {
		
		System.out.println("\n Hello World - Test 2\n");
		logger.trace("This is Trace message - Test 1");
		logger.info("This is information message - Test 2");
		logger.error("This is error message  - Test 2");
		logger.warn("This is warning message  - Test 2");
		logger.fatal("This is fatal message  - Test 2");
		System.out.println("\n Completed \n");
	
	}
	
	@AfterMethod
	public void end() {
		
    }
}
