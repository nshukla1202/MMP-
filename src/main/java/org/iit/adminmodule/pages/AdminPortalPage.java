package org.iit.adminmodule.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.iit.mmp.patientmodule.pages.LoginPage;
import org.iit.mmp.patientmodule.pages.RegistrationPage;
import org.iit.mmp.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class AdminPortalPage {

	private static final boolean Home = false;

	WebDriver driver;
	RegistrationPage registrationpage;
	By NavigateToPatientsTab=By.xpath("//span[@class='hidden-minibar' and contains(text(),'Patients')]");
	By searchPatient=By.id("search");
	By PatientText=By.xpath("//div[@class='panel-heading' and contains(text(),'Patients')]");
	By Search_Button=By.xpath("//input[@type='button']");
	By pListtablexpath=By.xpath("//div[@id='show']//td/a");
	By SearchBystatus=By.id("search");
	By SSNSearch=By.xpath("//td[2]");

	public AdminPortalPage(WebDriver driver) {


		this.driver=driver;
	}

	public boolean NavigatetoAndClickPatients() {


		WebElement e =driver.findElement(NavigateToPatientsTab);
		e.click();
		return driver.findElement(PatientText).isDisplayed();		

	}

	public void searchforPatient(String pName) throws InterruptedException
	{
		Thread.sleep(3000);	

		//driver.findElement(searchPatient).sendKeys("TestQ");
		driver.findElement(searchPatient).sendKeys("UserTest");
		driver.findElement(Search_Button).click();
		Thread.sleep(3000);
		List<WebElement> pList=driver.findElements(pListtablexpath);

		for(WebElement e: pList)
		{
			if(e.getText().equals(pName)) {
				System.out.println(e.getText());
				e.click();
			}


		}
	}

	public void SearchForPatientByStatus()
	{
		//			WebElement e=driver.findElement(SearchBystatus);
		//			e.click();
		//			
		//new Select(driver.findElement(SearchBystatus)));
		Select select1=new Select(driver.findElement(SearchBystatus));
		select1.selectByVisibleText("Pending");		

	}

	public void SearchBySSN() throws InterruptedException
	{

		List<WebElement> ssnlist=driver.findElements(SSNSearch);
		//registrationpage=new RegistrationPage(driver);
		//LoginPage lpage=new LoginPage(driver);

		//WebElement userName = driver.findElement(By.xpath("//td[1]/a[contains(text(),'"+ registrationpage.getUserName()+"')]"));

		//WebElement userName = driver.findElement(By.xpath("//td[1]/a[contains(text(),'"+ registrationpage.getUserName()+"')]"));
		// boolean b1=lpage.LoginUser(registrationpage.getUserName(), registrationpage.getPassword());
		//WebElement userName = driver.findElement(By.xpath("//td[1]/a[contains(text(),'"+ registrationpage.getUserName()+"')]"));

		//userName.click();

		for(WebElement e:ssnlist)
		{
			System.out.println("value of e "+ e.getText());

			RegistrationPage registrationpage=new RegistrationPage(driver);
			WebElement userName = driver.findElement(By.xpath("//td[1]/a[contains(text(),'"+ registrationpage.getUserName()+"')]"));

			System.out.println("My user name "+ registrationpage.getUserName());
			System.out.println("My SSN value"+ registrationpage.getSSN());

			if(e.getText().equals(registrationpage.getSSN()))
			{
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); 
				userName.click();
			}
		}



	}




}

















