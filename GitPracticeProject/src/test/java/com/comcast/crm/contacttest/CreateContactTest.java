package com.comcast.crm.contacttest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.comcast.crm.ObjectRepositoryUtility.ContactInformationPage;
import com.comcast.crm.ObjectRepositoryUtility.ContactPage;
import com.comcast.crm.ObjectRepositoryUtility.CreateNewConatctPage;
import com.comcast.crm.ObjectRepositoryUtility.HomePage;
import com.comcast.crm.baseTest.BaseClass;

public class CreateContactTest extends BaseClass {

	@Test
	public void CreateContact() throws Throwable {
		int ranInt = j.getRandomNumber();

		// read test script data from excel
		String lastname = e.getDataFromExcel("contact", 1, 2) + ranInt;
		HomePage hp = new HomePage(driver);
		hp.getContactLink().click();
		ContactPage cp = new ContactPage(driver);
		cp.getCreateNewContactBtn().click();
		CreateNewConatctPage cnp = new CreateNewConatctPage(driver);
		cnp.getLastNameEdit().sendKeys(lastname);
		cnp.getSaveBtn().click();
		ContactInformationPage cip = new ContactInformationPage(driver);
		String actheadertext = cip.getHeaderTxt().getText();
		boolean status=actheadertext.contains(lastname);
		Assert.assertEquals(status, true);
		String actLastName=driver.findElement(By.id("dtlview_Last Name")).getText();
		SoftAssert soft=new SoftAssert();
		soft.assertEquals(actLastName, lastname);
		
	}

}
