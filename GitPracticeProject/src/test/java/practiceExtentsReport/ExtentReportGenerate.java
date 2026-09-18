package practiceExtentsReport;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.comcast.crm.baseTest.BaseClass;

public class ExtentReportGenerate extends BaseClass {

	@Test
	public void createContactTest()

	{
		
		driver.get("http://49.249.29.4:8888");
		TakesScreenshot eDriver = (TakesScreenshot) driver;
		String filePath = eDriver.getScreenshotAs(OutputType.BASE64);

		ExtentTest test = BaseClass.report.createTest("createContactTest");
		test.log(Status.INFO, "Login to app");
		test.log(Status.INFO, "navigate to contact Page");
		test.log(Status.INFO, "create contact");
		if ("var".equals("deepu"))
		{
			test.log(Status.PASS, "CONTACT CREATED");
		}
		else {
			test.log(Status.FAIL, "CONTACT NOT CREATED");
			test.addScreenCaptureFromBase64String(filePath, "ErrorFile");
		}
		
		

	}

}
