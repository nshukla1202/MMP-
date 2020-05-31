package org.iit.mmp.utility;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.iit.mmp.patientmodule.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Utility {

	
	private static final long timeinSecs = 0;
	
	int i =0;
	WebDriver driver;
	
	By ClickonCalendartext=By.cssSelector(".hasdatepicker");
	By Selecttime =By.id("time");
	By clickContinuebutton=By.id("ChangeHeatName");
   
    
	By Adminusername=By.id("username");
	By Adminpassword=By.id("password");
	By SignInButton=By.name("admin");

	By AdminPortal=By.xpath("//h3[@class='panel-title']");

	public Utility(WebDriver driver)
	{
		System.out.println("selenium "+ i +"webdriver");

		this.driver = driver;
	}
	
	public static String generateRandom(int n,int range)
	{
		String str = "";
		for(int j = 0 ; j < 5;j++)
		{
				str = str+ 9;	 
		}
		System.out.println(str);
			
		return str+new Random().nextInt(range);
	}
	
	public boolean LoginUser(String username,String password) throws InterruptedException {

		driver.findElement(Adminusername).sendKeys(username);

		driver.findElement(Adminpassword).sendKeys(password);
		driver.findElement(SignInButton);
		driver.findElement(SignInButton).click();
		Thread.sleep(2000);

		return driver.findElement(AdminPortal).isDisplayed();
	}


	
	
	public WebDriver clickonCalendertextBox() {
		driver.findElement(ClickonCalendartext).click();
		return driver;
	}
	
	public String getCalFutureDate(int days,String pattern)
	{
		Calendar cal= Calendar.getInstance();
		cal.add(Calendar.DATE, days);
		
		Date d=cal.getTime();
		SimpleDateFormat sdf=new SimpleDateFormat(pattern);
		String date=sdf.format(d);
		
		return date;
		
	}
	
	public String getCalFutureDate(int days)
	{
		//MM/dd/yyyy -> 06/11/2020
		Date d1 = null;
		Calendar cal= Calendar.getInstance();
		cal.add(Calendar.DATE, days);
		Date d= cal.getTime();
	     System.out.println(d);
		SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/YYYY");
	     //dd/MM/yyyy
	    // SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	    // SimpleDateFormat sdf = new SimpleDateFormat("Mm/dd/yy");
	   //SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/YYYY");
	     //SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/YYYY");
	    
		//SimpleDateFormat sdf=new SimpleDateFormat("mm/dd/yyyy");
		String date=sdf.format(d);
		  //System.out.println("MM/DD/YYYY -> " + date);
		System.out.println("MM/dd/yyyy -> " + date);
		
		  String[] futuredateArr = date.split("/");

			
	  	cal.set(Calendar.YEAR,Integer.parseInt(futuredateArr[2]));
	  	
	  	cal.set(Calendar.DAY_OF_YEAR, Integer.parseInt(futuredateArr[1]));
	  	
	  	int day = cal.get(Calendar.DAY_OF_MONTH);
	  	
	  	String updatedDate = futuredateArr[0]+"/"+day+"/"+futuredateArr[2];

		return updatedDate;
		
		
	}
	
	public String[][] readXls(String filePath)
	{
		String[][] str = new String[10][10];
		return str;
	}
	public String[][] readXlsx(String filePath)
	{
		String[][] str = new String[10][10];
		return str;
	}
	
	
	
    
}

	

		
		
	

		


	





