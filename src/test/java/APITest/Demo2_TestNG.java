package APITest;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Demo2_TestNG {

	@BeforeClass
	public void BC()
	{
		System.out.println("This will execute before class");
	}
	
	@BeforeMethod
	public void BM()
	{
		System.out.println("This will execute before each test");
	}
	
	@Test
	public void  testcase3()
	{
		System.out.println("This is my Third testcase");
		Assert.assertEquals("Ashish", "Ashish");
	}
	

	@AfterTest
	public void AT()
	{
		System.out.println("This will execute after all the Test");
	}
	
	@AfterSuite
	public void AS()
	{
		System.out.println("This will execute at the End");
	}	
	

}
