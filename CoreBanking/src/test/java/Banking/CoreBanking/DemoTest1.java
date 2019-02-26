package Banking.CoreBanking;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoTest1 {
	
	@Test (priority =1)
	public void sum() {
	System.out.println("......SUM 2.......");
	Assert.assertEquals(30, 20+10);
	}

	
	@Test  (priority =2)
	public void sum2()  {
	System.out.println("......SUM 2 with out priority.......");
	Assert.assertEquals(30, 20+10);
	}

}
