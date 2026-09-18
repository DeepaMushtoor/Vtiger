package com.comcast.crm.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewConatctPage {

	WebDriver driver;
	public CreateNewConatctPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name='lastname']")
	private WebElement LastNameEdit;
	@FindBy(xpath = "//input[@name='support_start_date']")
	private WebElement StartDateEdit;
	@FindBy(xpath = "//input[@name='support_end_date']")
	private WebElement EndDateEdit;

	@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]")
	private WebElement SaveBtn;
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getStartDateEdit() {
		return StartDateEdit;
	}

	public WebElement getEndDateEdit() {
		return EndDateEdit;
	}

	public WebElement getLastNameEdit() {
		return LastNameEdit;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}
	

	public void createNewContactWithSupportDate(String lastName, String startDate, String endDate) {
		getLastNameEdit().sendKeys(lastName);
		getStartDateEdit().sendKeys(startDate);
		getEndDateEdit().sendKeys(endDate);
		getSaveBtn().click();
		
		
		
	}

	public void createContactWithOrg(String contactLastName, String orgName) {
	
		
	}
	
	

	
}
