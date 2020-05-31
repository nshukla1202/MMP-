package org.iit.adminmodule.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.iit.mmp.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class AdminPortalPage {

	private static final boolean Home = false;

	WebDriver driver;

	By NavigateToPatientsTab=By.xpath("//span[@class='hidden-minibar' and contains(text(),'Patients')]");
	By searchPatient=By.id("search");
	By PatientText=By.xpath("//div[@class='panel-heading' and contains(text(),'Patients')]");
	By Search_Button=By.xpath("//input[@type='button']");

	By pListtablexpath=By.xpath("//div[@id='show']//td/a");


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
	
	
	
	
}
















