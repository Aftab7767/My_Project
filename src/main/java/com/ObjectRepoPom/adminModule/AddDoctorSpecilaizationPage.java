package com.ObjectRepoPom.adminModule;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddDoctorSpecilaizationPage {
@FindBy(xpath="//h5[text()='Doctor Specialization']")
private WebElement docSpecializationText;
@FindBy(xpath="//h1[text()='Admin | Add Doctor Specialization']")
private WebElement specializationMainText;
@FindBy(name="doctorspecilization")
private WebElement specializationtextbox;
@FindBy(name="submit")
private WebElement submitButton;
@FindBy(xpath="//tbody/tr/td[2]")
private List<WebElement> specializationList;

@FindBy(xpath="//tbody/tr/td[5]//a[@class=\"btn btn-transparent btn-xs tooltips\"]")
private List<WebElement> deleteSpecialization;

@FindBy(xpath="//tbody/tr/td[5]//a[@class='btn btn-transparent btn-xs tooltips']")
private List<WebElement>deleteDoctorList;

public List<WebElement> getDeleteDoctorList() {
	return deleteDoctorList;
}

public AddDoctorSpecilaizationPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}

public WebElement getDocSpecializationText() {
	return docSpecializationText;
}
public List<WebElement> getDeleteSpecialization() {
	return deleteSpecialization;
}

public WebElement getSpecializationMainText() {
	return specializationMainText;
}

public WebElement getSpecializationtextbox() {
	return specializationtextbox;
}

public WebElement getSubmitButton() {
	return submitButton;
}

public List<WebElement> getSpecializationList() {
	return specializationList;
}
public void addSpecialization(String specialization)
{
	specializationtextbox.sendKeys(specialization);
	submitButton.click();
}

}
