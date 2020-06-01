package org.iit.mmp.patientmodule.tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.iit.adminmodule.pages.AdminHomePage;
import org.iit.adminmodule.pages.AdminPortalPage;
import org.iit.adminmodule.tests.PayFeeTest;
import org.iit.mmp.base.TestBase;
import org.iit.mmp.helper.Helperclass;
import org.iit.mmp.patientmodule.pages.LoginPage;
import org.iit.mmp.patientmodule.pages.ScheduleAppointmentPage;
import org.iit.mmp.patientmodule.tests.Test;
import org.iit.mmp.utility.Utility;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;
import io.github.bonigarcia.wdm.WebDriverManager;

//This test is about Scheduling an Appointment(US_005)

public class ScheduleAppointmentTest extends TestBase
{
	
	Utility util;
	Helperclass helperclass;
	AdminPortalPage adminPortalPage;
	AdminHomePage adminhomePage;


	@org.testng.annotations.Test(description="US_005 Schedule Appointment",groups={"US_005","regression","sanity","patientmodule"})
	public void validateAppointmentDetails() throws InterruptedException, IOException
	{

       Utility util=new Utility(driver);
	   helperclass=new Helperclass(driver);
	   //Launching the Patient Portal.
		helperclass.launchApplicationURL("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");
		helperclass.verifyvalidateLogin();
		//Navigating the module:Schedule Appointment
		helperclass.moduleNavigation("Schedule Appointment");
		//Click on Create New Appointment
		clickOnCreatenewAppointmentButton();
		helperclass.captureScreenshot("clickOnCreatenewAppointmentButton");
		//Booking an Appointment
		HashMap<String,String> hMap=selectDoctor("Dr.Charlie");
		Thread.sleep(3000);
		//Below Validating Appointment on Home Page as well as ScheduleappointmentPage.
		SoftAssert sa=new SoftAssert();
		sa.assertTrue(validateAppointmentDetailsinHomePage(hMap),"");
		
	
		helperclass.captureScreenshot("validateAppointmentDetailsinHomePage");
		sa.assertTrue(validateAppointmentDetailsinSchedulePage(hMap), "");
		
		helperclass.captureScreenshot("validateAppointmentDetailsinSchedulePage");
		sa.assertAll();
		
		Helperclass helperclass=new Helperclass(driver);
		//Now Login to Admin Module
		helperclass.launchApplicationURL("http://96.84.175.78/MMP-Release2-Admin-Build.2.1.000/login.php");
		helperclass.captureScreenshot("US_001_LaunchApplication");
		util.LoginUser("Thomas_444", "Edison_444");
		helperclass.captureScreenshot("US_002_verifyValidLogin");
		helperclass.moduleNavigation("Patients");
		
		AdminPortalPage adminPortalPage=new AdminPortalPage(driver);
		adminPortalPage.NavigatetoAndClickPatients();
		adminPortalPage.searchforPatient("UserTest");
		AdminHomePage adminhomePage=new AdminHomePage(driver);
		//Clicking on Create Visit
		adminhomePage.clickOnCreateVisit();
		helperclass.captureScreenshot("US003_clickOnCreateVisit");
		//Booking an Appointment through Admin.
		HashMap<String,String> hMap1=selectDoctor("Dr.Beth");
		
		//Now again Login to Patient Portal 
		helperclass.launchApplicationURL("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");
		helperclass.verifyvalidateLogin();
		helperclass.moduleNavigation("HOME");
		//Below Validating Appointment on Home as well as Schedule Appointment.
		SoftAssert sa1=new SoftAssert();
		sa1.assertTrue(validateAppointmentDetailsinHomePage(hMap),"");

	}


	public void clickOnCreatenewAppointmentButton() throws InterruptedException
	{
		Thread.sleep(3000);

		ScheduleAppointmentPage scheduleapp=new ScheduleAppointmentPage(driver);
		scheduleapp.clickOnCreatenewAppointmentButton();

	}


	public HashMap<String, String> selectDoctor(String doctorName)throws InterruptedException
	{

		ScheduleAppointmentPage scheduleapp=new ScheduleAppointmentPage(driver);
		return scheduleapp.selectDoctor("Dr.Beth");


	}

	public void switchtoFrameAvailable(String frameId, int timeinSecs)
	{
		helperclass.switchToAFrameAvailable("myframe",20);

	}


	public boolean validateAppointmentDetailsinHomePage(HashMap<String,String>hMap) throws InterruptedException
	{
		Thread.sleep(3000);

		ScheduleAppointmentPage scheduleapp=new ScheduleAppointmentPage(driver);

		return scheduleapp.validateAppointmentDetailsinHomePage(hMap);
	}

	public boolean validateAppointmentDetailsinSchedulePage(HashMap<String,String>hMap) throws InterruptedException
	{
		ScheduleAppointmentPage scheduleapp=new ScheduleAppointmentPage(driver);
		return scheduleapp.validateAppointmentDetailsinSchedulePage(hMap);


	}






}
