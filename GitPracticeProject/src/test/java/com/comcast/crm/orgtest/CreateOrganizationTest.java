package com.comcast.crm.orgtest;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.ObjectRepositoryUtility.CreatingNewOrganizationsPage;
import com.comcast.crm.ObjectRepositoryUtility.HomePage;
import com.comcast.crm.ObjectRepositoryUtility.OrganizationInformationPage;
import com.comcast.crm.ObjectRepositoryUtility.OrganizationsPage;
import com.comcast.crm.baseTest.BaseClass;
import com.comcast.crm.generic.webDriverutility.UtilityClassObject;

public class CreateOrganizationTest extends BaseClass {

	@Test
	public void CreateOrganization() throws Throwable {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		UtilityClassObject.getTest().log(Status.INFO, "NAVIGATE TO ORG PAGE");
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();
		OrganizationsPage op = new OrganizationsPage(driver);
		op.getCreateNewOrgBtn().click();
		UtilityClassObject.getTest().log(Status.INFO, "READING DATA FROM EXCEL");
		CreatingNewOrganizationsPage cnop = new CreatingNewOrganizationsPage(driver);
		String orgName = e.getDataFromExcel("organization", 1, 2) + j.getRandomNumber();
		cnop.createOrg(orgName);
		UtilityClassObject.getTest().log(Status.INFO, "CREATE NEW ORGANIZATION");
		OrganizationInformationPage oip = new OrganizationInformationPage(driver);
		String actOrgName = oip.getHeaderMsg().getText();
		Assert.assertEquals(true, actOrgName.contains(orgName));
	}

	@Test
	public void CreateOrganizationWithIndustries() throws Throwable {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();
		OrganizationsPage op = new OrganizationsPage(driver);
		op.getCreateNewOrgBtn().click();
		CreatingNewOrganizationsPage cnop = new CreatingNewOrganizationsPage(driver);
		String orgName = e.getDataFromExcel("organization", 1, 2) + j.getRandomNumber();
		cnop.createOrg(orgName, "Education");
		OrganizationInformationPage oip = new OrganizationInformationPage(driver);
		String actOrgName = oip.getHeaderMsg().getText();

	}

	@Test
	public void CreateOrganizationWithPhoneNumber() throws Throwable {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();
		OrganizationsPage op = new OrganizationsPage(driver);
		op.getCreateNewOrgBtn().click();
		CreatingNewOrganizationsPage cnop = new CreatingNewOrganizationsPage(driver);
		String orgName = e.getDataFromExcel("organization", 1, 2) + j.getRandomNumber();
		cnop.createOrgpno(orgName, "9902806405");
		Thread.sleep(2000);
		OrganizationInformationPage oip = new OrganizationInformationPage(driver);
		String actOrgName = oip.getHeaderMsg().getText();

	}
}
