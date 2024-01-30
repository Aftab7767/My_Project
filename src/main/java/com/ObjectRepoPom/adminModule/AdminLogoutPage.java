package com.ObjectRepoPom.adminModule;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.genericUtility.WebDriverUtils;

public class AdminLogoutPage extends WebDriverUtils
{
	//declaration
	
@FindBy(xpath="//span[@class='username']")
private WebElement adminprofileIcon;
@FindBy(partialLinkText = "Log Out")
private WebElement logoutLink;

//initialization

public AdminLogoutPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}

//utilization

public WebElement getAdminprofileIcon() {
	return adminprofileIcon;
}

public WebElement getLogoutLink() {
	return logoutLink;
}

//business logic

public void adminLogout(WebDriver driver)
{
	adminprofileIcon.click();
	implicitWait(driver, 20);
	logoutLink.click(); 
}


}
