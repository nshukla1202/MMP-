package org.iit.mmp.patientmodule.tests;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

import org.iit.mmp.base.TestBase;
import org.iit.mmp.helper.Helperclass;
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
	
	 
		
		WebDriver driver;
		Random rand = new Random();
		HashMap<String,String> hMap = new HashMap<String,String>();
	
		@Test(description="US_001 Registration of the Page",groups={"US_001","regression","sanity","patientmodule"})
		public void validateRegistration() throws InterruptedException 
		{  
			//instantiateDriver();
			launchApplicationURL("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");
			clickRegisterButton();
			fillData();
			clickOnSaveButton();
			Thread.sleep(3000);
			String actual = readSuccessMessage();
			String expected = " Thank you for registering with MMP ";
			System.out.println("Expected" +expected);
			Assert.assertEquals(actual, expected);
		}
		public String readSuccessMessage() 
		{
          
			Alert alrt= driver.switchTo().alert();
			String msg = alrt.getText();
			alrt.accept();
			return msg;	
			
		}
//		public void instantiateDriver()
//		{
//			WebDriverManager.chromedriver().setup();
//			driver  = new ChromeDriver();
//		}
		public void launchApplicationURL(String url)
		{
			driver.get(url);
			 
		}
		public void clickRegisterButton()
		{
			driver.findElement(By.xpath("//input[@value='Register'] ")).click();
		}
		public void enterFirstName()
		{
			String firstNameValue = "QATestName"+((char)(65+rand.nextInt(26)));
			driver.findElement(By.id("firstname")).sendKeys(firstNameValue);
			hMap.put("FName", firstNameValue);
			
		}
		public void enterLastName()
		{
			String lastNameValue = "TestName"+((char)(65+rand.nextInt(26)));
			driver.findElement(By.id("lastname")).sendKeys(lastNameValue);
			hMap.put("LName", lastNameValue);
		}
		public void enterDateOfBirth()
		{
			Date d = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			String datePickerValue = sdf.format(d);
			driver.findElement(By.id("datepicker")).sendKeys(datePickerValue);
			hMap.put("DatePicker", datePickerValue);
		}
		public void enterLicense()
		{
			String licenseValue = 9999999+ rand.nextInt(1000000)+"";
			//String licenseValue=Helperclass.generateRandom(7, 1000000);
			driver.findElement(By.id("license")).sendKeys(licenseValue);
			hMap.put("License", licenseValue);
			
			
		}
		public void enterSSN()
		{
			String ssnValue = Calendar.getInstance().getTimeInMillis()%1000000000+"";
			driver.findElement(By.id("ssn")).sendKeys(ssnValue);
			hMap.put("SSN", ssnValue);
		}
		public void enterState()
		{
			
			String stateValue = "New York";
			driver.findElement(By.id("state")).sendKeys(stateValue);
			hMap.put("State", stateValue);
			
		}
		public void enterCity()
		{
			String cityValue = "seattle";
			driver.findElement(By.id("city")).sendKeys(cityValue);
			hMap.put("City", cityValue);
		}
		public void enterAddressValue()
		{

			String addressValue = "9 Street";
			driver.findElement(By.id("address")).sendKeys(addressValue);
			hMap.put("Address", addressValue);
		}
		public void enterZipCodeValue()
		{

			String zipCodeValue = 9999+rand.nextInt(1000)+"";
			driver.findElement(By.id("zipcode")).sendKeys(zipCodeValue);
			hMap.put("ZipCode", zipCodeValue);
		}
		public void enterAgeValue()
		{
			String ageValue =  rand.nextInt(100)+"";
			driver.findElement(By.id("age")).sendKeys(ageValue);
			hMap.put("Age", ageValue);
		}
		public void enterHeightValue()
		{

			String heightValue =  rand.nextInt(100)+"";
			driver.findElement(By.id("height")).sendKeys(heightValue);
			hMap.put("Height", heightValue);
		}
		public void enterWeightValue()
		{

			
			String weightValue =  rand.nextInt(100)+"";
			driver.findElement(By.id("weight")).sendKeys(weightValue);
			hMap.put("Weight", weightValue);
			
		}
		public void enterPharmaDetails()
		{

			String pharmacyValue =  "MMP Pharmacy";
			driver.findElement(By.id("pharmacy")).sendKeys(pharmacyValue);
			hMap.put("Pharma", pharmacyValue);
			
			
			String pharma_adressValue = "12 Chipmunk Crossing";
			driver.findElement(By.id("pharma_adress")).sendKeys(pharma_adressValue);
			hMap.put("PharmaAddress", pharma_adressValue);
		}
		
		public void enterUserDetails()
		{
			String emailValue = "WalesQA"+rand.nextInt(100)+"@gmail.com";
			driver.findElement(By.id("email")).sendKeys(emailValue);
			hMap.put("Email", emailValue);
			
			
			String usernameValue = "WalesQA"+rand.nextInt(100);
			driver.findElement(By.id("username")).sendKeys(usernameValue);
			hMap.put("Username", usernameValue);
			
		 
			String passwordValue="WalesQA"+rand.nextInt(100);
			driver.findElement(By.id("password")).sendKeys(passwordValue);
			hMap.put("Password", passwordValue);
			
			
			driver.findElement(By.id("confirmpassword")).sendKeys(passwordValue);
			hMap.put("ConfirmPassword", passwordValue);
		}
		public void enterSecurityInfo()
		{
			Select select=new Select(driver.findElement(By.id("security")));
			select.selectByVisibleText("What is your mother maiden name");
			hMap.put("SecurityQuestion", "What is your mother maiden name");
			
			
			String answerValue = "WalesQA"+rand.nextInt(100);
			driver.findElement(By.id("answer")).sendKeys(answerValue);
			hMap.put("SecurityAnswer", answerValue);
			
		}
		public void clickOnSaveButton()
		{
			WebElement e=driver.findElement(By.name("register"));
			e.click();
		}
		public void fillData()
		{
			enterFirstName();
			enterLastName();
			enterDateOfBirth();
			enterLicense();
			enterSSN();
			enterState();
			enterCity();
			enterAddressValue();
			enterZipCodeValue();
			enterAgeValue();
			enterHeightValue();
			enterWeightValue();
			enterPharmaDetails();
			enterUserDetails();
			enterSecurityInfo();
			clickOnSaveButton();
		 	 
		}
	}



