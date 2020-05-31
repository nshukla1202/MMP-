package org.iit.mmp.helper;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Random;
import org.apache.commons.io.FileUtils;
import org.iit.mmp.patientmodule.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class Helperclass {
	
	WebDriver driver ;
	
	By modulenavigation =By.xpath("//span[contains(text(),'\"+moduleName+\"')]");
	
	

	
	public Helperclass(WebDriver driver)
	{
		this.driver = driver;
	}
	

	public void moduleNavigation(String moduleName)
	{
		driver.findElement(By.xpath("//span[contains(text(),'"+moduleName+"')]")).click();
	}
	 
	public void launchApplicationURL(String url)
	{
		driver.get(url);
		 
	}
	
	
	public WebDriver switchToAFrameAvailable(String frameId,int timeinSecs)
	{
		WebDriverWait wait = new WebDriverWait(driver,timeinSecs);
		driver = wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameId));
		return driver;
	}
	
	public void verifyvalidateLogin() throws InterruptedException {

//		LoginPage lpage=new LoginPage(driver);
//		if(lpage.LoginUser("TestQa", "Qa123456")) {
//			System.out.println("PateintLogin Sucessfull");
		LoginPage lpage=new LoginPage(driver);
		if(lpage.LoginUser("UserTest", "Ut@123456")) {
		System.out.println("PateintLogin Sucessfull");
		
		}
		
		
		
	}
	
	public void captureScreenshot(String tc_Name) throws IOException 
    {
		
		TakesScreenshot tsh=(TakesScreenshot)driver;
		File sourcefile=tsh.getScreenshotAs(OutputType.FILE);
		System.out.println(sourcefile.getAbsolutePath());
		String destinationPath=System.getProperty("user.dir")+"//screenshots//"+tc_Name+"_"+
				                          Calendar.getInstance().getTimeInMillis()%1000000000+".jpg";
		
	  File destfile=new File(destinationPath);
	  FileUtils.copyFile(sourcefile, destfile);
		
		
		
	}
	

	
	
	}
	
	




