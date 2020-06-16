package org.iit.mmp.patientmodule.tests;

import org.iit.mmp.base.TestBase;
import org.iit.mmp.helper.Helperclass;
import org.iit.mmp.utility.Utility;
import org.testng.annotations.Test;

public class EditUpdateProfileTestCase extends TestBase {

	Utility util;
	Helperclass helperclass;
	
	
	@Test(description="US_003 EditUpdatedProfile",groups={"US_005","regression","sanity","patientmodule"})
	public void ValidateEditUpadateProfile() throws InterruptedException
	{
		Utility util=new Utility(driver);
		   helperclass=new Helperclass(driver);
		   //Launching the Patient Portal.
			helperclass.launchApplicationURL("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");
			helperclass.verifyvalidateLogin();
			//Navigating the module:Schedule Appointment
			helperclass.moduleNavigation("Profile");
			
			
	}
	
	
}
