package org.iit.adminmodule.tests;
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

public class PayFeeTest extends TestBase {

	//private static final String service = null;
	//private static final String appointment = null;


	Utility util;
	Helperclass helperclass;
	private By NavigateToPatientsTab;
	ScheduleAppointmentTest scheduleappTest;

	@Test(description="US_006 Pay Fees",groups={"US_001","regression","sanity","Adminmodulemodule"})
	public void validate() throws InterruptedException, IOException
	{
		Utility util=new Utility(driver);
		Helperclass helperclass=new Helperclass(driver);
		helperclass.launchApplicationURL("http://96.84.175.78/MMP-Release2-Admin-Build.2.1.000/login.php");
		helperclass.captureScreenshot("US_001_LaunchApplication");
		util.LoginUser("Thomas_444", "Edison_444");
		//helperclass.captureScreenshot("US_002_verifyValidLogin");
		helperclass.moduleNavigation("Patients");
		NavigatetoAndClickPatients();
		searchforPatient();
		clickOnCreateVisit();
		//helperclass.captureScreenshot("US003_clickOnCreateVisit");
		HashMap<String,String> hMap=selectDoctor("Dr.Beth");
		//helperclass.captureScreenshot("US004_selectDoctor");
		
		Thread.sleep(3000);
		helperclass.moduleNavigation("Patients");
		searchforPatient();
		
		
		
		clickonCreateFeebutton();
		Thread.sleep(3000);
		HashMap<String,String> hMap1=FeeDetails();
		//helperclass.captureScreenshot("FeeDetails");
	    SoftAssert sa=new SoftAssert();
	    Thread.sleep(3000);
		String actual = readSuccessMessage();
		String expected ="Fee Successfully Entered.";
		Thread.sleep(3000);
		//helperclass.captureScreenshot("Fee Successfully Entered.");
		//Assert.assertEquals(actual, expected);
		
		
		helperclass.launchApplicationURL("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");
		helperclass.verifyvalidateLogin();
		helperclass.moduleNavigation("Fees");
//		SoftAssert sA=new SoftAssert();
//		sA.assertTrue(scheduleappTest.validateAppointmentDetailsinHomePage(hMap),"");
//		
		
		Thread.sleep(3000);
		PayFeesPage payFee=new PayFeesPage(driver);
		payFee.ClickOnPayNow();
		payFee.SelectPayment();
		payFee.ClickOnContinue();
		//helperclass.captureScreenshot("CardDetails");
		payFee.CardDetails();
		 
		 
		
	}

	public String readSuccessMessage() 
	{
		
		String alertText = null;
	
//		Alert alrt  = driver.switchTo().alert();
//		String msg = alrt.getText();
//		System.out.println(msg);
//        Thread.sleep(3000);
//		alrt.accept();
//		System.out.println(alrt.getText());
//		DesiredCapabilities dc = new DesiredCapabilities();
//		dc.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
//		//d = new ChromeDriver(dc);
//		
//		try {
//		   
//		} catch (UnhandledAlertException f) {
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
		
		//return  readSuccessMessage();

	
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

	
	



}





