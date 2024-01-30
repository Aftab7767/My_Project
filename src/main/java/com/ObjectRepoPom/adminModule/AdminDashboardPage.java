package com.ObjectRepoPom.adminModule;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminDashboardPage {
@FindBy(xpath="//span[text()=' Dashboard ']")
 private WebElement dashBoardIcon;
@FindBy(xpath="//span[text()=' Doctors ']")
private WebElement doctorButton;
@FindBy(xpath="//span[text()=' Users ']")
private WebElement userButton;
@FindBy(xpath="//span[text()=' Patients ']")
private WebElement patientButton;
@FindBy(xpath="//span[text()=' Appointment History ']")
private WebElement appointmentHistorybutton;
@FindBy(xpath="//span[text()=' Conatctus Queries ']")
private WebElement contactusQueryButton;
@FindBy(xpath="//span[text()=' Doctor Session Logs ']")
private WebElement doctorSessionLoginbutton;
@FindBy(xpath="//span[text()=' User Session Logs ']")
private WebElement userSessionLoginButton;
@FindBy(xpath="//span[text()=' Reports ']")
private WebElement reportsButton;
@FindBy(xpath="//span[text()=' Patient Search ']")
private WebElement searchPatientButton;
@FindBy(xpath="//span[text()=' Doctor Specialization ']")
private WebElement doctorSpecializationButton;
@FindBy(xpath="//span[text()=' Add Doctor']")
private WebElement addDoctorButton;
@FindBy(xpath="//span[text()=' Manage Doctors ']")
private WebElement manageDoctorbutton;
@FindBy(xpath="//span[text()=' Manage Users ']")
private WebElement manageUserButton;
@FindBy(xpath="//span[text()=' Manage Patients ']")
private WebElement managePatientButton;
@FindBy(xpath="//span[text()=' Unread Query ']")
private WebElement unreadQueryButton;
@FindBy(xpath="//span[text()=' Read Query ']")
private WebElement readQueryButton;
@FindBy(xpath="//span[text()='B/w dates reports ']")
private WebElement betwwenDatesReportsButton;
@FindBy(xpath="//h1[text()='Admin | Dashboard']")
private WebElement dashBoardText;
@FindBy(xpath="//h2[text()='Manage Users']")
private WebElement manageusersText;
@FindBy(xpath="//a[contains(text(),'Total Users')]")
private WebElement totalUserLink;
@FindBy(xpath="//h2[text()='Manage Doctors']")
private WebElement manageDoctorText;
@FindBy(xpath="//a[contains(text(),'Total Doctors')]")
private WebElement totalDoctorLink;
@FindBy(xpath="//h2[text()=' Appointments']")
private WebElement appointmentsText;
 @FindBy(xpath = "//a[contains(text(),'Total Appointments')]")
 private WebElement totalAppointmentsLink;
 @FindBy(xpath="//h2[text()='Manage Patients']")
 private WebElement managePatientText;
 @FindBy(xpath = "//a[contains(text(),'Total Patients')]")
 private WebElement totalPatinetLinks;
 @FindBy(xpath="//a[contains(text(),'Total New Queries')]")
 private WebElement totalQueryLink;
 @FindBy(xpath="//h2[text()=' New Queries']")
 private WebElement newQueryText;
 
 //initalization
 public AdminDashboardPage(WebDriver driver)
 {
	 PageFactory.initElements(driver, this);
 }
 
//utilization

public WebElement getDashBoardIcon() {
	return dashBoardIcon;
}

public WebElement getDoctorButton() {
	return doctorButton;
}

public WebElement getUserButton() {
	return userButton;
}

public WebElement getPatientButton() {
	return patientButton;
}

public WebElement getAppointmentHistorybutton() {
	return appointmentHistorybutton;
}

public WebElement getContactusQueryButton() {
	return contactusQueryButton;
}

public WebElement getDoctorSessionLoginbutton() {
	return doctorSessionLoginbutton;
}

public WebElement getUserSessionLoginButton() {
	return userSessionLoginButton;
}

public WebElement getReportsButton() {
	return reportsButton;
}

public WebElement getSearchPatientButton() {
	return searchPatientButton;
}

public WebElement getDoctorSpecializationButton() {
	return doctorSpecializationButton;
}

public WebElement getAddDoctorButton() {
	return addDoctorButton;
}

public WebElement getManageDoctorbutton() {
	return manageDoctorbutton;
}

public WebElement getManageUserButton() {
	return manageUserButton;
}

public WebElement getManagePatientButton() {
	return managePatientButton;
}

public WebElement getUnreadQueryButton() {
	return unreadQueryButton;
}

public WebElement getReadQueryButton() {
	return readQueryButton;
}

public WebElement getBetwwenDatesReportsButton() {
	return betwwenDatesReportsButton;
}

public WebElement getDashBoardText() {
	return dashBoardText;
}

public WebElement getManageusersText() {
	return manageusersText;
}

public WebElement getTotalUserLink() {
	return totalUserLink;
}

public WebElement getManageDoctorText() {
	return manageDoctorText;
}

public WebElement getTotalDoctorLink() {
	return totalDoctorLink;
}

public WebElement getAppointmentsText() {
	return appointmentsText;
}

public WebElement getTotalAppointmentsLink() {
	return totalAppointmentsLink;
}

public WebElement getManagePatientText() {
	return managePatientText;
}

public WebElement getTotalPatinetLinks() {
	return totalPatinetLinks;
}

public WebElement getTotalQueryLink() {
	return totalQueryLink;
}

public WebElement getNewQueryText() {
	return newQueryText;
}
 
//business logic
 public void clickDoctorButton()
 {
	 doctorButton.click();
 }
 public void clickDocSpecialization()
 {
	 doctorSpecializationButton.click();
 }
 public void clickAddDoctor()
 {
	 addDoctorButton.click();
 }
 public void clickManageDoctor()
 {
	 manageDoctorbutton.click();
 }
 public void clickuserButton()
 {
	 userButton.click();
 }
 public void manageUser()
 {
	 manageUserButton.click();
 }
 public void clickPatientsButton()
 {
	 patientButton.click();
 }
 public void mangePatient() {
	 managePatientButton.click();
 }
 public void clickAppointmentHistory()
 {
	 appointmentHistorybutton.click();
 }
 public void clickcontactUsQuery()
 {
	 contactusQueryButton.click();
 }
 public void readQuery()
 {
	 readQueryButton.click();
 }
 public void unreadQuery()
 {
	 unreadQueryButton.click();
 }
 public void clickDoctorSessionLogin()
 {
	 doctorSessionLoginbutton.click();
 }
 public void clickUserSessionLogin()
 {
	 userSessionLoginButton.click();
 }
 public void clickReports()
 {
	 reportsButton.click();
 }
 public void reportsBetweenDate() {
	 betwwenDatesReportsButton.click();
 }
 public void clickSearchPatient() {
	 searchPatientButton.click();
 }
 




















}
