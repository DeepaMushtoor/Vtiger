package com.comcast.crm.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webDriverutility.WebDriverUtility;

public class HomePage {
	WebDriver driver;
	// declaration
	@FindBy(linkText = "Organizations")
	private WebElement orgLink;
	@FindBy(linkText = "Contacts")
	private WebElement contactLink;
	@FindBy(linkText = "Campaigns")
	private WebElement campaignsLink;
	@FindBy(linkText = "More")
	private WebElement moreLink;
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminImg;
	@FindBy(xpath = "//a[contains(.,'Sign Out')]")
	private WebElement signOut;

	// initialization
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrgLink() {
		return orgLink;
	}

	public WebElement getContactLink() {
		return contactLink;
	}

	public WebElement getCampaignsLink() {
		return campaignsLink;
	}

	public WebElement getMoreLink() {
		return moreLink;
	}

	public void logout() {

		WebDriverUtility w = new WebDriverUtility();
		w.mousehover(driver, adminImg);
		signOut.click();

	}

}
