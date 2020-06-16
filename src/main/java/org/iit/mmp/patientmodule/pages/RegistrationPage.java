package org.iit.mmp.patientmodule.pages;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

import org.iit.mmp.utility.Utility;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage {
	
   WebDriver driver;
  java.util.Random rand = new Random();
	
	HashMap<String,String> hMap = new HashMap<String,String>();
	Utility util;
	
	private String userName;
	private String password;
	private String ssn;
	
	By RegisterButtton=By.xpath("//input[@value='Register']");
	By FirstNameText=By.id("firstname");
	By LastNameText=By.id("lastname");
	By DateOfBirth=By.id("datepicker");
	By License=By.id("license");
	By SSN=By.id("ssn");
	By State=By.id("state");
	By City=By.id("city");
	By ZipCode=By.id("zipcode");
	By Age=By.id("age");
	By Height=By.id("height");
	By Weight=By.id("weight");
	By PharmacyName=By.id("pharmacy");
	By PharmacyAddress=By.id("pharma_adress");
	By EmailText=By.id("email");
	By UserName=By.id("username");
	By Password=By.id("password");
	By ConfirmPassword=By.id("confirmpassword");
	By Securityquestion=By.id("security");
	By SecurityAnswer=By.id("answer");
	By Savebtn=By.name("register");
	
	

	public RegistrationPage(WebDriver driver) 
	{
		this.driver=driver;
	}
	
	public void clickRegisterButton()
	{
		driver.findElement(RegisterButtton).click();
	}
	public void enterFirstName()
	{
		String firstNameValue = "QA"+((char)(65+rand.nextInt(26)));
		driver.findElement(FirstNameText).sendKeys(firstNameValue);
		hMap.put("FName", firstNameValue);
		
	}
	public void enterLastName()
	{
		String lastNameValue = "Test"+((char)(65+rand.nextInt(26)));
		driver.findElement(LastNameText).sendKeys(lastNameValue);
		hMap.put("LName", lastNameValue);
	}
	public void enterDateOfBirth()
	{
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String datePickerValue = sdf.format(d);
		driver.findElement(DateOfBirth).sendKeys(datePickerValue);
		hMap.put("DatePicker", datePickerValue);
	}
	public void enterLicense()
	{
		String licenseValue = 9999999+ rand.nextInt(1000000)+"";
		//String licenseValue=Helperclass.generateRandom(7, 1000000);
		driver.findElement(License).sendKeys(licenseValue);
		hMap.put("License", licenseValue);
	}
	public void enterSSN()
	{
		String ssnValue = Calendar.getInstance().getTimeInMillis()%1000000000+"";
		driver.findElement(SSN).sendKeys(ssnValue);
		hMap.put("SSN", ssnValue);
		this.ssn=ssnValue;
		System.out.println("SSNValue"+ ssnValue);
		
	}
	public void enterState()
	{
		
		String stateValue = "New York";
		driver.findElement(State).sendKeys(stateValue);
		hMap.put("State", stateValue);
		
	}
	public void enterCity()
	{
		String cityValue = "Buffalo";
		driver.findElement(City).sendKeys(cityValue);
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
		driver.findElement(Age).sendKeys(ageValue);
		hMap.put("Age", ageValue);
	}
	public void enterHeightValue()
	{

		String heightValue =  rand.nextInt(100)+"";
		driver.findElement(Height).sendKeys(heightValue);
		hMap.put("Height", heightValue);
	}
	public void enterWeightValue()
	{
		
		String weightValue =  rand.nextInt(100)+"";
		driver.findElement(Weight).sendKeys(weightValue);
		hMap.put("Weight", weightValue);
		
	}
	public void enterPharmaDetails()
	{

		String pharmacyValue ="MMP Pharmacy";
		driver.findElement(PharmacyName).sendKeys(pharmacyValue);
		hMap.put("Pharma", pharmacyValue);
		
		
		String pharma_adressValue ="12 Chipmunk Crossing";
		driver.findElement(PharmacyAddress).sendKeys(pharma_adressValue);
		hMap.put("PharmaAddress", pharma_adressValue);
	}
	public void enterUserDetails()
	{
		
		String emailValue = "QA"+rand.nextInt(10000)+"@gmail.com";
		driver.findElement( EmailText).sendKeys(emailValue);
		hMap.put("Email", emailValue);
       
		
		String usernameValue = "QATestName"+rand.nextInt(10000);
		driver.findElement(UserName).sendKeys(usernameValue);
		hMap.put("Username", usernameValue);
		System.out.println("usernameValue-> " + usernameValue);
		this.userName=usernameValue;
		
		
		String passwordValue="QATestName"+rand.nextInt(100);
		driver.findElement(Password).sendKeys(passwordValue);
		hMap.put("Password", passwordValue);
		System.out.println("PasswordValue"+passwordValue);
		this.password=passwordValue;
		
		
		driver.findElement(ConfirmPassword).sendKeys(passwordValue);
		hMap.put("ConfirmPassword", passwordValue);
		System.out.println("passwordValue");
		
	}
	public void enterSecurityInfo()
	{
		new Select(driver.findElement(Securityquestion)).selectByVisibleText("What is your mother maiden name");
		
		hMap.put("SecurityQuestion", "What is your mother maiden name");
		
		
		String answerValue = "QA"+rand.nextInt(100);
		driver.findElement(SecurityAnswer).sendKeys(answerValue);
		hMap.put("SecurityAnswer", answerValue);
		
	}
	public void clickOnSaveButton()
	{
		WebElement e=driver.findElement(Savebtn);
		e.click();
	}
	public String getUserName()
	{
		
		return userName;
		
	}
	
	public String getPassword()
	{
		
		return password;
		
	}
	
	public String getSSN()
	{
		return ssn;
	}

  
}
