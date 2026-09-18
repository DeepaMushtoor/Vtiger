package com.comcast.crm.baseTest;

import java.sql.SQLException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.comcast.crm.ObjectRepositoryUtility.HomePage;
import com.comcast.crm.ObjectRepositoryUtility.LoginPage;
import com.comcast.crm.generic.databaseutility.DataBaseUtility;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webDriverutility.JavaUtility;

public class BaseClassParallel {
	/* Create Object */
	public DataBaseUtility d = new DataBaseUtility();
	public ExcelUtility e = new ExcelUtility();
	public FileUtility f = new FileUtility();
	public JavaUtility j = new JavaUtility();
	public WebDriver driver = null;

	@BeforeSuite
	public void configBS() throws SQLException {
		System.out.println("=======CONNECT TO DB,REPORT CONFIG=======");
		d.getDbconnection();
	}

	@Parameters("BROWSER")
	@BeforeClass
	public void configBC(String browser) throws Throwable {
		System.out.println("======LAUNCH BROWSER=====");
		String BROWSER = browser; // f.getDataFromPropertiesFile("browser");
		if (BROWSER.equalsIgnoreCase("chrome"))
			driver = new ChromeDriver();
		else if (BROWSER.equalsIgnoreCase("firefox"))
			driver = new FirefoxDriver();
		else if (BROWSER.equalsIgnoreCase("edge"))
			driver = new EdgeDriver();
		else
			driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@BeforeMethod
	public void configBM() throws Throwable {
		System.out.println("======LOGIN=====");
		String URL = f.getDataFromPropertiesFile("url");
		String USERNAME = f.getDataFromPropertiesFile("username");
		String PASSWORD = f.getDataFromPropertiesFile("password");
		LoginPage l = new LoginPage(driver);
		l.loginToApp(URL, USERNAME, PASSWORD);

	}

	@AfterMethod
	public void configAM() {
		System.out.println("=====LOGOUT=====");
		HomePage hp = new HomePage(driver);
		hp.logout();
	}

	@AfterClass
	public void configAC() {
		System.out.println("=======CLOSE THE BROWSER======");
		driver.quit();
	}

	@AfterSuite
	public void configAS() throws Throwable {
		System.out.println("=======CLOSE DB, REPORT BACKUP======");
		d.closeDBconnection();
	}
}
