package Banking.CoreBanking;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoTest {
	
	
	@Test (priority =1)
	public void sum() {
	System.out.println("......SUM.......");
	Assert.assertEquals(20, 10+10);
	}
	
	@Test (priority =2)
	public void sub() {
	System.out.println("......SUBSTRACT.......");
	Assert.assertEquals(10, 20-10);
	}
	
	
	@Test (priority =3)
	public void Mul() {
	System.out.println("......MULTIPLY.......");
	Assert.assertEquals(100, 10*10);
	}
	
}
