package com.ObjectRepoPom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainHomePage {
//declaration
	@FindBy(xpath="//h3[text()='Admin Login']/../div//a[text()='Click Here']")
	private WebElement adminLoginLink;
	@FindBy(xpath="//h3[text()='Patients']/..//a[text()='Click Here']")
	private WebElement patientLoginlink;
	@FindBy(xpath="//h3[text()='Doctors Login']/ancestor::div[@class='text list_1_of_2']//a[text()='Click Here']")
	private WebElement doctorLoginLink;
	@FindBy(xpath="//img[@src=’images/grid-img3.png’]")
	private WebElement patientLogo;
	@FindBy(xpath="//h3[text()='Patients']")
	private WebElement patientText;
	@FindBy(xpath="//img[@src=’images/grid-img1.png’]")
	private WebElement doctorLogo;
	@FindBy(xpath="//h3[text()='Doctors Login']")
	private WebElement doctorLoginText;
	@FindBy(xpath="//img[@src=’images/grid-img2.png’]")
	private WebElement adminLogo;
	@FindBy(xpath="//h3[text()='Admin Login']")
	private WebElement adminLoginText;
	@FindBy(xpath="//div[@class=\"top-nav\"]//a[text()='Home']")
	private WebElement homeButton;
	@FindBy(xpath="//div[@class=\"top-nav\"]//a[text()='contact']")
	private WebElement contactButton;
	@FindBy(xpath="//a[text()='Hospital Management system']")
	private WebElement hmsVerificationText;
	//initialization
	public MainHomePage (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//utilization
	public WebElement getAdminLoginLink() {
		return adminLoginLink;
	}
	public WebElement getPatientLoginlink() {
		return patientLoginlink;
	}
	public WebElement getDoctorLoginLink() {
		return doctorLoginLink;
	}
	public WebElement getPatientLogo() {
		return patientLogo;
	}
	public WebElement getPatientText() {
		return patientText;
	}
	public WebElement getDoctorLogo() {
		return doctorLogo;
	}
	public WebElement getDoctorLoginText() {
		return doctorLoginText;
	}
	public WebElement getAdminLogo() {
		return adminLogo;
	}
	public WebElement getAdminLoginText() {
		return adminLoginText;
	}
	public WebElement getHomeButton() {
		return homeButton;
	}
	public WebElement getContactButton() {
		return contactButton;
	}
	public WebElement getHmsVerificationText() {
		return hmsVerificationText;
	}
	
	//business logic
	public void adminLoginLink()
	{
		adminLoginLink.click();
	}
	public void patientLoginLink()
	{
		patientLoginlink.click();
	}
	public void doctorLoginLink()
	{
		doctorLoginLink.click();
	}
	
}
