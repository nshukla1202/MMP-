package org.iit.adminmodule.tests;

import java.io.IOException;
import java.util.HashMap;

import org.iit.adminmodule.pages.AdminHomePage;
import org.iit.adminmodule.pages.AdminPortalPage;
import org.iit.adminmodule.pages.ScheduleAdminAppointmentPage;
import org.iit.mmp.base.TestBase;
import org.iit.mmp.helper.Helperclass;
import org.iit.mmp.utility.Utility;
import org.testng.annotations.Test;

public class ScheduleAdminTest extends TestBase {
	
	Utility util;
	Helperclass helperclass;
	
	
	
	@Test
	public void ValidateAppointmentInAdmin() throws IOException, InterruptedException
	{
		
		 Utility util=new Utility(driver);
		   helperclass=new Helperclass(driver);
		   
		   helperclass.launchApplicationURL("http://96.84.175.78/MMP-Release2-Admin-Build.2.1.000/login.php");
			helperclass.captureScreenshot("US_001_LaunchApplication");
			util.LoginUser("Thomas_444", "Edison_444");
			helperclass.captureScreenshot("US_002_verifyValidLogin");
			helperclass.moduleNavigation("Patients");
			AdminPortalPage adminPage=new AdminPortalPage(driver);
			adminPage.searchforPatient("UserTest");
			PayFeeTest admintest=new PayFeeTest();
			admintest.clickOnCreateVisit();
			HashMap<String,String> hMap=selectDoctor("Dr.Beth");
			
			
			
			
			
			
			
	}
	
	public void searchforPatient() throws InterruptedException
	{
		AdminPortalPage adminPage=new AdminPortalPage(driver);
		adminPage.searchforPatient("UserTest");
		
	}
	public HashMap<String, String> selectDoctor(String doctorName)throws InterruptedException
	{
		AdminHomePage adminhomepage=new AdminHomePage(driver);
		return adminhomepage.selectDoctor("Dr.Charlie");
	}

	
}
