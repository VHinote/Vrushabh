package Test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(ListnerTest.class)
public class Demo {
	  private static final boolean False = false;

	@Test
	  public void test() {
		  System.out.println("Test is succefuly run");
	  }
	
	  @Test
	  public void test2() {
		  System.out.println("Test is failed");
		  Assert.assertTrue(False);
		  
	  }
	  
	  
	  @Test(dependsOnMethods= {"test2"})
	  public void test3() {
		  System.out.println("Test is failed");
		  
	  }
	  
	  @Test
	  public void test4(){
		  System.out.println("Test is run");
	  }
     

	  @Test
	  public void test5(){
		  System.out.println("Test is run");
	  }
}
