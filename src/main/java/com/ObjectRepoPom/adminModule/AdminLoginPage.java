package com.ObjectRepoPom.adminModule;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminLoginPage {
	
//declaration
	@FindBy(name="username")
	private WebElement untbx;
	@FindBy(name="password")
	private WebElement pwtbx;
	@FindBy(name="submit")
	private WebElement lgbtn;
	@FindBy(xpath="//h2[text()='Admin Login']")
	private WebElement adminLoginText;
	@FindBy(xpath="//legend[contains(text(),'Sign in to your account')]")
	private WebElement signinMessageText;
	@FindBy(xpath="//div[@class='copyright']")
	private WebElement copyRightText;
	
		//initialization
		public AdminLoginPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
	
	//utilization
	public WebElement getCopyRightText() {
			return copyRightText;
		}
	public WebElement getAdminLoginText() {
		return adminLoginText;
	}
	public WebElement getSigninMessageText() {
		return signinMessageText;
	}
	public WebElement getUntbx() {
		return untbx;
	}
	public WebElement getPwtbx() {
		return pwtbx;
	}
	public WebElement getLgbtn() {
		return lgbtn;
	}
	//Business logic
	public void setAdminLogin(String un,String pwd)
	{
		untbx.sendKeys(un);
		pwtbx.sendKeys(pwd);
		lgbtn.click();
		
	}
}
