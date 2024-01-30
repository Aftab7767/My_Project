package com.ObjectRepoPom.patientModule;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PatientLoginPage {
	
	//declaration
	
	@FindBy(name = "username")
	private WebElement untbxp;
	@FindBy(name = "password")
	private WebElement pwtbx;
	@FindBy(name = "submit")
	private WebElement lgbtn;
	@FindBy(xpath = "//a[contains(text(),'Forgot Password')]")
	private WebElement forgotPasswordLink;
	@FindBy(xpath = "//legend[contains(text(),'Sign in to your account')]")
	private WebElement signinMessegeText;	
    @FindBy(xpath = "//div[@class='copyright']")
    private WebElement copyRightText;
    @FindBy(xpath = "//a[contains(text(),'Create an account')]")
    private WebElement createAccountLink;
    @FindBy(xpath = "//h2[text()=' HMS | Patient Login']")
    private WebElement patientLoginText;
    @FindBy(partialLinkText = "Log-in")
    private WebElement newPatientLoginLink;
    
    //initialization
    
    public PatientLoginPage (WebDriver driver)
    {
    	PageFactory.initElements(driver, this);
    }

    //utilization
    
	public WebElement getUntbxp() {
		return untbxp;
	}

	public WebElement getNewPatientLoginLink() {
		return newPatientLoginLink;
	}

	public WebElement getUntbxd() {
		return untbxp;
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

	public WebElement getCopyRightText() {
		return copyRightText;
	}

	public WebElement getCreateAccountLink() {
		return createAccountLink;
	}

	public WebElement getPatientLoginText() {
		return patientLoginText;
	}
    
 
    //business logic
	public void setPatientLogin(String un,String pwd)
	{
		untbxp.sendKeys(un);
		pwtbx.sendKeys(pwd);
		lgbtn.click();
	}
	
    
}