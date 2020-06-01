package org.iit.mmp.patientmodule.tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.iit.adminmodule.pages.AdminHomePage;
import org.iit.adminmodule.pages.AdminLoginPage;
import org.iit.adminmodule.pages.AdminPortalPage;
import org.iit.mmp.base.TestBase;
import org.iit.mmp.helper.Helperclass;
import org.iit.mmp.patientmodule.pages.PayFeesPage;
import org.iit.mmp.patientmodule.tests.ScheduleAppointmentTest;
import org.iit.mmp.utility.Utility;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


//This Test Scenario is about creating Fee.
public class PayFeeTest extends TestBase
{
	Utility util;
	Helperclass helperclass;
	private By NavigateToPatientsTab;
	ScheduleAppointmentTest scheduleappTest;
	AdminLoginPage adminlogout;

	@Test(description="US_006 Pay Fees",groups={"US_001","regression","sanity","Adminmodulemodule"})
	public void validate() throws InterruptedException, IOException
	{
		Utility util=new Utility(driver);
		Helperclass helperclass=new Helperclass(driver);
		//Launching AdminUrl:
		helperclass.launchApplicationURL("http://96.84.175.78/MMP-Release2-Admin-Build.2.1.000/login.php");
		helperclass.captureScreenshot("US_001_LaunchApplication");
		util.LoginUser("Thomas_444", "Edison_444");
		helperclass.captureScreenshot("US_002_verifyValidLogin");
		helperclass.moduleNavigation("Patients");
		//Clicking on Patient Tab:
		NavigatetoAndClickPatients();
		searchforPatient();
		clickOnCreateVisit();
		helperclass.captureScreenshot("US003_clickOnCreateVisit");
		//Booking an Appointment from admin.
		HashMap<String,String> hMap=selectDoctor("Dr.Beth");
		helperclass.captureScreenshot("US004_selectDoctor");
		Thread.sleep(3000);
		helperclass.moduleNavigation("Patients");
		searchforPatient();
		//Clicking on Create Fee
		clickonCreateFeebutton();
		Thread.sleep(3000);
		HashMap<String,String> hMap1=FeeDetails();
		//helperclass.captureScreenshot("FeeDetails");
	    SoftAssert sa=new SoftAssert();
	    Thread.sleep(3000);
	    //Fee Sucessfully Entered.
		String actual = readSuccessMessage();
		String expected ="Fee Successfully Entered.";
		Thread.sleep(3000);
		//Log out from Admin
		AdminLoginPage adminlogout=new AdminLoginPage(driver);
		adminlogout.adminLogout();
		
		//Now Launching Patient Portal Login:
		helperclass.launchApplicationURL("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");
		//Verifying the Login.
		helperclass.verifyvalidateLogin();
		//Click On PayFee
		helperclass.moduleNavigation("Fees");
//		SoftAssert sA=new SoftAssert();
//		sA.assertTrue(scheduleappTest.validateAppointmentDetailsinHomePage(hMap),"");
//		
		Thread.sleep(3000);
		//PayFeesPage payFee=new PayFeesPage(driver);
		ClickOnPayNow();
		SelectPayment();
		ClickOnContinue();
		
		CardDetails(); 
		
	}

	public String readSuccessMessage() 
	{
		
		String alertText = null;

		    try {
		        Alert alert = driver.switchTo().alert();
		        alertText = alert.getText();
		        System.out.println("Alert data: " + alertText);
		        alert.accept();
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		    
		    return alertText;
		}
		
	public void NavigatetoAndClickPatients() throws InterruptedException
	{
		
		Helperclass helperclass=new Helperclass(driver);
		helperclass.moduleNavigation("Patients");
		AdminPortalPage patientpage=new AdminPortalPage(driver);
		patientpage.NavigatetoAndClickPatients();

	}

	public void searchforPatient() throws InterruptedException {

		AdminPortalPage patientpage=new AdminPortalPage(driver);
		//patientpage.searchforPatient("TestQ");
		patientpage.searchforPatient("UserTest");

	}

	public void clickOnCreateVisit() throws InterruptedException {


		AdminHomePage adminhomepage=new AdminHomePage(driver);
		adminhomepage.clickOnCreateVisit();
	}

	public HashMap<String, String> selectDoctor(String doctorName)throws InterruptedException
	{
		AdminHomePage adminhomepage=new AdminHomePage(driver);
		return adminhomepage.selectDoctor("Dr.Charlie");




	}

	public void clickonCreateFeebutton() throws InterruptedException
	{

		AdminHomePage adminhomepage=new AdminHomePage(driver);
		adminhomepage.clickonCreateFeebutton("Create Fee");

	}

	public HashMap<String,String>FeeDetails() throws InterruptedException
	{
		AdminHomePage adminhomepage=new AdminHomePage(driver);
		return adminhomepage.FeeDetails();


	}
	
	public void ClickOnPayNow()
	{
		PayFeesPage payFee=new PayFeesPage(driver);
		payFee.ClickOnPayNow();
	}

	
	public void SelectPayment() {
		PayFeesPage payFee=new PayFeesPage(driver);
		payFee.SelectPayment();
		
		
	}
	public void ClickOnContinue()
	{
		PayFeesPage payFee=new PayFeesPage(driver);
		payFee.ClickOnContinue();
		
	}
	
	public void CardDetails() throws InterruptedException {
		PayFeesPage payFee=new PayFeesPage(driver);
		payFee.CardDetails();
		
	}
	




}





