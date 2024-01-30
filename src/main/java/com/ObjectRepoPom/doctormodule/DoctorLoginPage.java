package com.ObjectRepoPom.doctormodule;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DoctorLoginPage {
	
	//declaration
	
@FindBy(name="username")
private WebElement untbxd;
@FindBy(name="password")
private WebElement pwtbx;
@FindBy(name="submit")
private WebElement lgbtn;
@FindBy(xpath="//a[contains(text(),'Forgot Password')]")
private WebElement forgotPasswordLink;
@FindBy(xpath="//legend[contains(text(),'Sign in to your account')]")
private WebElement signinMessegeText;
@FindBy(xpath="//h2[text()=' HMS | Doctor Login']")
private WebElement doctorLoginText;
@FindBy(xpath="//div[@class='copyright']")
private WebElement copyRightText;

//initialization
public DoctorLoginPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}

//utilization

public WebElement getUntbxd() {
	return untbxd;
}

public WebElement getPwtbx() {
	return pwtbx;
}

public WebElement getLgbtn() {
	return lgbtn;
}

public WebElement getForgotPasswordLink() {
	return forgotPasswordLink;
}

public WebElement getSigninMessegeText() {
	return signinMessegeText;
}

public WebElement getDoctorLoginText() {
	return doctorLoginText;
}

public WebElement getCopyRightText() {
	return copyRightText;
}

//business logic
public void setDoctorLogin(String un,String pwd)
{
	untbxd.sendKeys(un);
	pwtbx.sendKeys(pwd);
	lgbtn.click();
}


}
