package org.iit.mmp.patientmodule.tests;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.iit.adminmodule.pages.AdminPortalPage;
import org.iit.mmp.base.TestBase;
import org.iit.mmp.helper.Helperclass;
import org.iit.mmp.patientmodule.pages.LoginPage;
import org.iit.mmp.patientmodule.pages.RegistrationPage;
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
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
public class RegistrationPatientTests extends TestBase {

	private static final long time = 0;


	Helperclass helperclass;
	Utility util;
	RegistrationPage registrationpage;
	AdminPortalPage adminPortalPage;
	//Random rand = new Random();
	//HashMap<String,String> hMap = new HashMap<String,String>();

	@Test(description="US_001 Registration of the Page",groups={"US_001","regression","sanity","patientmodule"})
	public void validateRegistration() throws InterruptedException, IOException 
	{  

		Utility util=new Utility(driver);
		helperclass=new Helperclass(driver);
		Thread.sleep(3000);
		helperclass.launchApplicationURL("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/registration.php");
		RegistrationPage registrationpage=new RegistrationPage(driver);
		registrationpage.enterFirstName();
		registrationpage.enterLastName();
		registrationpage.enterDateOfBirth();
		registrationpage.enterLicense();
		registrationpage.enterSSN();
		registrationpage.enterState();
		registrationpage.enterCity();
		registrationpage.enterAddressValue();
		registrationpage.enterZipCodeValue();
		registrationpage.enterAgeValue();
		registrationpage.enterHeightValue();
		registrationpage.enterWeightValue();
		registrationpage.enterPharmaDetails();
		registrationpage.enterUserDetails();
		registrationpage.enterSecurityInfo();
		//registrationpage.fillData();
		helperclass.captureScreenshot("RegistrationData");
		registrationpage.clickOnSaveButton();
		Thread.sleep(3000);
		String actual = readSuccessMessage();
		String expected = "Thank you for registering with MMP. ";
		System.out.println("Expected" +expected);
		Assert.assertEquals(actual, expected);
		Thread.sleep(3000);
		helperclass.launchApplicationURL("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");
		LoginPage lpage=new LoginPage(driver);
		System.out.println(registrationpage.getUserName());
		System.out.println(registrationpage.getPassword());

		//Entering the Username password on run time..
        
		boolean s=lpage.randomLogin(registrationpage.getUserName(),registrationpage.getPassword());
		Thread.sleep(3000);
		System.out.println("Entered the uname password"+s);
		String actualText=readmessage();
		String expectedText= "Admin Approval is pending. ";
		Assert.assertEquals(actual, expected);
		//Now Login to the admin Module
		helperclass.launchApplicationURL("http://96.84.175.78/MMP-Release2-Admin-Build.2.1.000/login.php");
		util.LoginUser("Thomas_444", "Edison_444");
		driver.manage().window().maximize(); 
		helperclass.moduleNavigation("Users");
		Thread.sleep(3000);
		AdminPortalPage adminPortalPage=new AdminPortalPage(driver);
		adminPortalPage.SearchForPatientByStatus();
		Thread.sleep(3000);
		adminPortalPage.SearchBySSN();
	}
	
	public String readSuccessMessage() 
	{

		Alert alrt= driver.switchTo().alert();
		String msg = alrt.getText();
		alrt.accept();
		return msg;	

	}

	public String readmessage() throws InterruptedException 
	{
		String alertText = null;

		try {
			Alert alert = driver.switchTo().alert();
			alertText = alert.getText();
			System.out.println("Alert data: " + alertText);

			alert.accept();

		} catch (UnhandledAlertException e) {
			e.printStackTrace();
		}

		return alertText;
	}

}









