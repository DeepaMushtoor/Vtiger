package com.comcast.crm.orgtest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.comcast.crm.ObjectRepositoryUtility.ContactPage;
import com.comcast.crm.ObjectRepositoryUtility.CreateNewConatctPage;
import com.comcast.crm.ObjectRepositoryUtility.CreatingNewOrganizationsPage;
import com.comcast.crm.ObjectRepositoryUtility.HomePage;
import com.comcast.crm.ObjectRepositoryUtility.OrganizationsPage;
import com.comcast.crm.baseTest.BaseClass;

public class WorkInProgress extends BaseClass {
	
	@Test
	public void CreateContactWithOrgTest() throws Throwable {
		int ranInt = j.getRandomNumber();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		String orgName = e.getDataFromExcel("organization", 1, 2) + j.getRandomNumber();
		String contactLastName = e.getDataFromExcel("contact", 4, 2) + ranInt;
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();
		OrganizationsPage op = new OrganizationsPage(driver);
		op.getCreateNewOrgBtn().click();
		CreatingNewOrganizationsPage cnop = new CreatingNewOrganizationsPage(driver);
		cnop.createOrg(orgName);
		String actOrgName = driver.findElement(By.id("mouseArea_Organization Name")).getText();
		if (actOrgName.equals(orgName)) {
			System.out.println(orgName + " is created=====pass");
		} else {
			System.out.println(orgName + " is not created=====Fail");
		}
		hp.getContactLink().click();
		ContactPage cp=new ContactPage(driver);
		cp.getCreateNewContactBtn().click();
		CreateNewConatctPage cnc=new CreateNewConatctPage(driver);
		cnc.createContactWithOrg(contactLastName,orgName);
		actOrgName = driver.findElement(By.id("mouseArea_Organization Name")).getText();
		if (actOrgName.trim().equals(orgName)) {
			System.out.println(orgName + "  information  is created=====pass");
		} else {
			System.out.println(orgName + " information is not created=====Fail");
		}
		
		
	}
		

	@Test
	public void CreateContactWithSupportDateTest() throws Throwable {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		int ranInt = j.getRandomNumber();

		// read test script data from excel
		String LastName = e.getDataFromExcel("contact", 4, 2) + ranInt;
		HomePage hp = new HomePage(driver);
		hp.getContactLink().click();
		ContactPage cp = new ContactPage(driver);
		cp.getCreateNewContactBtn().click();

		String startDate = j.getSystemDateYYYYDDMM();
		String endDate = j.getRequiredDateYYYYDDMM(30);
		CreateNewConatctPage cnp = new CreateNewConatctPage(driver);
		cnp.createNewContactWithSupportDate(LastName, startDate, endDate);

		String actStartDate = driver.findElement(By.id("dtlview_Support Start Date")).getText();
		if (actStartDate.contains(startDate)) {
			System.out.println(startDate + " is verified==== pass");
		} else {
			System.out.println(startDate + " is not verified====Fail");
		}
		String actEndDate = driver.findElement(By.id("dtlview_Support End Date")).getText();
		if (actEndDate.contains(endDate)) {
			System.out.println(endDate + " is verified=====pass");
		} else {
			System.out.println(endDate + " is not verified =====Fail");
		}

	}
}
