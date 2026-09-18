package PracticeListener;


import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.comcast.crm.baseTest.BaseClass;



@Listeners(com.comcast.crm.ListenerUtility.ListenerImplementationClass.class)
public class InvoiceTest extends BaseClass {
	@Test
	public void  createInvoiceTest()
	{
		System.out.println("EXECUTE createInvoiceTest");
		String actTitle=driver.getTitle();
		Assert.assertEquals(actTitle, "login");
		System.out.println("Step1");
		System.out.println("Step2");
		System.out.println("Step3");
		System.out.println("Step4");
	}
	@Test
	public void  createInvoiceWithContactTest()
	{
		System.out.println("EXECUTE createInvoiceWithContactTest");
		System.out.println("Step1");
		System.out.println("Step2");
		System.out.println("Step3");
		System.out.println("Step4");
		
	}
	@Test(retryAnalyzer = com.comcast.crm.ListenerUtility.RetryListenerListenerImplementation.class)
	public void  activateSim()
	{
		System.out.println("EXECUTE activateSim");
		Assert.assertEquals("", "sss");
		System.out.println("Step1");
		System.out.println("Step2");
		System.out.println("Step3");
		System.out.println("Step4");
	}
	
}
