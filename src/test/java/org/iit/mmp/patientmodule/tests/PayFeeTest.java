package org.iit.mmp.patientmodule.tests;

import java.io.IOException;

import org.iit.mmp.base.TestBase;
import org.iit.mmp.helper.Helperclass;
import org.iit.mmp.patientmodule.pages.LoginPage;
import org.iit.mmp.patientmodule.pages.PayFeesPage;
import org.iit.mmp.utility.Utility;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PayFeeTest extends TestBase {
	
	
	Utility util;
	Helperclass helperclass;
	PayFeesPage payFee;
	
	
	@Test(description="US_006 Pay Fees",groups={"US_001","regression","sanity","Adminmodulemodule"})
	public void validatePayFee() throws InterruptedException, IOException
	{
       Utility util=new Utility(driver);
		Helperclass helperclass=new Helperclass(driver);
		
		helperclass.launchApplicationURL("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");
	    helperclass.verifyvalidateLogin();
	    helperclass.captureScreenshot("US_006");
		helperclass.moduleNavigation("Fee");
		Thread.sleep(3000);
		PayFeesPage payFee=new PayFeesPage(driver);
		ClickOnPayNow();
		SelectPayment();
		ClickOnContinue();
		helperclass.captureScreenshot("CardDetails");
		 CardDetails();
		 
	}
	
	public void  ClickOnPayNow()
	{
	PayFeesPage payfee=new PayFeesPage(driver);
	
	payfee.ClickOnPayNow();
	
	
	}
	public void SelectPayment()
	{
		PayFeesPage payfee=new PayFeesPage(driver);
		payfee.SelectPayment();
		
	}
	public void ClickOnContinue() {
		PayFeesPage payfee=new PayFeesPage(driver);
		payfee.ClickOnContinue();
		
	}
	public void  CardDetails() throws InterruptedException {
		PayFeesPage payfee=new PayFeesPage(driver);
		payfee.CardDetails();
		
	}
	
	
}
