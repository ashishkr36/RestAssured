package APITest;


import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Demo_TestNG {
	
	@BeforeSuite
	public void BS()
	{
		System.out.println("This is going to execute before any test");
	}
	
	@BeforeTest
	public void BT()
	{
		System.out.println("This will run after Test Suite");
	}
	
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
	public void  testcase1()
	{
		System.out.println("This is my first testcase");
	}
	

	@Test
	public void  testcase2()
	{
		System.out.println("This is my second testcase");
	}
	
	@AfterMethod
	public void AM()
	{
		System.out.println("This will run after each test");
	}
	
	@AfterClass
	public void AC()
	{
		System.out.println("This will run after class");
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