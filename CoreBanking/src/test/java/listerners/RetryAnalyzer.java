/*
 * This class covers:
 * TO DO from Naveen automation lab 
 */

package listerners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

	private int retryCount = 0;
	private static final int maxRetryCount =3;
	
	@Override
	public boolean retry(ITestResult result) {
		
		if (retryCount<maxRetryCount) {
			retryCount++;
			return true;
		}
		
		return false;
	}

}
