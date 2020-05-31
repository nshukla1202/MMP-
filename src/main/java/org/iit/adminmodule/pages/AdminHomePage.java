package org.iit.adminmodule.pages;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.iit.mmp.helper.Helperclass;
import org.iit.mmp.utility.Utility;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AdminHomePage {

	WebDriver driver;

    By createVisit=By.xpath("//div[@id='container_body']/p[1]");
    By datePicker=By.id("datepicker");
    By Selecttime =By.id("time");
	By clickContinuebutton=By.id("ChangeHeatName");
	//By symptoms=By.id("sym");
	By symptoms=By.name("sym");
	By submitbutton=By.xpath("//input[@type='submit']");
	By createFee=By.xpath("//div[@id='container_body']/p[3]");
	By SelectiondropdownDate=By.xpath("//select[@id='app_date']");
	By selectservice=By.xpath("//select[@id='service']");
	By submitFee=By.xpath("//input[@type='submit']");



	public AdminHomePage(WebDriver driver)
	{
		this.driver=driver;
	}

	public void clickOnCreateVisit() throws InterruptedException {
		
		Thread.sleep(3000);
		driver.findElement(createVisit).click();
		
	}
	
	public HashMap<String,String> selectDoctor(String doctorName) throws InterruptedException
	{
		HashMap<String,String> hMap=new HashMap<String,String>();
		Thread.sleep(3000);		
		driver.findElement(By.xpath("//h4[contains(text(),'"+doctorName+"')]/ancestor::td//button[@id='opener']")).click();
		Thread.sleep(3000);
		Utility util=new Utility(driver);
		Helperclass helperclass=new Helperclass(driver);
		driver=helperclass.switchToAFrameAvailable("myframe",20);
		
		
		//WebElement dateOfAppointment=driver.findElement(datePicker);
		
		String dateOfAppointment=util.getCalFutureDate(20);
		WebElement e=driver.findElement(datePicker);
		
		//e.sendKeys("06/14/2020");
		e.sendKeys(dateOfAppointment);
		String time= "10Am";
		new Select(driver.findElement(Selecttime)).selectByVisibleText(time);
		Thread.sleep(3000);
		
		driver.findElement(clickContinuebutton).click();
		String symptoms="Booking an Appointment "+doctorName +"ondate:"+util.getCalFutureDate(20)+"for symptom fever";
		System.out.println("symptoms");
		Thread.sleep(3000);
		driver.findElement(By.name("sym")).clear();
		driver.findElement(By.name("sym")).sendKeys(symptoms);
		//driver.findElement(By.id(symptoms)).click();
	
		 driver.findElement(submitbutton).sendKeys(symptoms);
		 
		 hMap.put("dateOfAppointment", dateOfAppointment);
		 hMap.put("time", time);
		 hMap.put("symptoms", symptoms);
		 hMap.put("ProviderName", doctorName);
		 
		 //System.out.println(Arrays.asList(hMap)); 
		 System.out.println("Printing hashmap Values " + Collections.singletonList(hMap));
		return hMap;
		
		
	}
	
	public void clickonCreateFeebutton(String Clickontab) throws InterruptedException
	{
		Thread.sleep(3000);
		List<WebElement> list=driver.findElements(createFee);

		for(WebElement e:list)
		{
			if(e.getText().equals(Clickontab))
				System.out.println(e.getText());
			{
				e.click();
			}
		}


	}

	public HashMap<String,String> FeeDetails()  throws InterruptedException
	{
		
		HashMap<String,String> hMap= new HashMap<String,String>();
		driver.findElement(SelectiondropdownDate).click();
		Thread.sleep(3000);
		Utility util=new Utility(driver);
		//String selectAppointments="";
		String selectAppointments=util.getCalFutureDate(20);
		
		//new Select(driver.findElement(Selectiondropdown)).getAllSelectedOptions();
		//new Select(driver.findElement(Selectiondropdown)).selectByVisibleText(selectAppointments);
		
	
		//WebElement e=driver.findElement(Selectiondropdown);
		//e.click();
		//Select select=new Select(e);
		
		//select.selectByVisibleText(selectAppointments);
		//select.selectByVisibleText("06/14/2020");

		String service="vaccination";
		WebElement e1=driver.findElement(selectservice);
		e1.click();
		Select select1=new Select(e1);
		Thread.sleep(2000);
		select1.selectByVisibleText("vaccination");

		driver.findElement(submitFee).click();
		//driver.wait(2000);

		hMap.put("SelectiondropdownDate",selectAppointments);
		hMap.put("selectservice", service);

		return hMap;

	}

	public String readSuccessMessage() throws InterruptedException 
	{
      
		Alert alrt= driver.switchTo().alert();
		String msg = alrt.getText();
		
		Thread.sleep(3000);
		System.out.println(alrt.getText());
		alrt.accept();
		return msg;	
		
	}


}
//








