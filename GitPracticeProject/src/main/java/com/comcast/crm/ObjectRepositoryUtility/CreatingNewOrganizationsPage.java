package com.comcast.crm.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreatingNewOrganizationsPage {
	WebDriver driver;
	public CreatingNewOrganizationsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="accountname")
	private WebElement orgNameEdt;
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])[1]")
	private WebElement saveBtn;
	@FindBy(name="industry")
	private WebElement industryDD;
	@FindBy(xpath="//input[@id='phone']")
	private WebElement phoneNoedt;
	
	
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getOrgNameEdt() {
		return orgNameEdt;
	}

	public WebElement getIndustryDD() {
		return industryDD;
	}

	public WebElement getPhoneNoedt() {
		return phoneNoedt;
	}

	public WebElement getOrgName() {
		return orgNameEdt;
	}
	
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	public void createOrg(String orgName)
	{
		orgNameEdt.sendKeys(orgName);
		saveBtn.click();
		
	}
	public void createOrg(String orgName,String industry)
	{
		orgNameEdt.sendKeys(orgName);
		Select sel=new Select(industryDD);
		sel.selectByVisibleText(industry);
		saveBtn.click();
		
	}
	public void createOrgpno(String orgName,String phoneNo) throws InterruptedException
	{
		orgNameEdt.sendKeys(orgName);
		phoneNoedt.sendKeys(phoneNo);
		Thread.sleep(2000);
		saveBtn.click();
		
	}
	
	
	
	
}
