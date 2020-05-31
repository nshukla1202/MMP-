package org.iit.adminmodule.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ScheduleAdminAppointmentPage {
	
	WebDriver driver;
	By SearchtextBox=By.id("search");
	By Searchbtn=By.xpath("//input[@class='tfbutton']");
	

	public ScheduleAdminAppointmentPage()
	{
		
		this.driver=driver;
	}
	
//	public void EnterPatientName( String EnterPatientName) {
//		
//		driver.findElement(SearchtextBox);
//		driver.findElement(Searchbtn).click();
//	}
	
	
	
}
