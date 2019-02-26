/*
 * This class covers:
 * 1. Exception handing with try catch & finally block
 * 2. throws exception to calling function.
 * 3. Purposely throws new exception to calling function.
 * 
 * Note - you can use new try catch block in all your test.
 */

package testNGTesing;

import org.testng.annotations.Test;

public class ExceptionHandlingDemo {
	
	
	@Test
	public void test1() {
		
		try {
		System.out.println("Hello World.........");
		int i = 1/0;
		System.out.println("Completed.........");
	}
	catch(Exception exp) {
		System.out.println("I am inside Catch block");
		System.out.println("Message is :  "+exp.getMessage());
		System.out.println("Message is :  "+exp.getCause());
		exp.printStackTrace();
		}
		
	finally {
		System.out.println("I am inside finally block");
	}

	}
	
		
	
	@Test
	public void test2() {
		
		try {
			
			CodeForTest2();
			
			//Here we are calling code which has throws Exception so we have to do one of the following thing:
			//1. throw exception here also to somewhere else or
			//2. try catch here
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
	
	
	@Test
	public void test3() {
		try {
			CodeForTest3();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	
	
	
	
	
public void CodeForTest2() throws Exception {
		
		System.out.println("Hello World.........CodeForTEST2 Throws Exception");
		int i = 1/0;
		System.out.println("Completed.........CodeForTEST2 Throws Exception");
		
	}



public void CodeForTest3() throws Exception {
	
	System.out.println("Hello World.........CodeForTEST3 Throws Exception");
	throw new ArithmeticException("not valid operation");
	//Exception is thrown above so any code from here is unreachable.	
}
		
}
