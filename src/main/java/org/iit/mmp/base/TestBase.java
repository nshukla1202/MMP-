package org.iit.mmp.base;

import java.io.IOException;
import java.util.Properties;

import org.iit.mmp.config.ProjectConfiguration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	protected static  WebDriver driver;//Protected is useful for class which  are extending testbase class.
	
	@BeforeClass 
	public void instantiateDriver() throws IOException
	{
		
		ProjectConfiguration pConfig = new ProjectConfiguration();	
		Properties pro = pConfig.loadProperties();
		String browser = pro.getProperty("browser");
		
		if(browser.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver  = new ChromeDriver();
		}
		else if(browser.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
	}

}

// Priority of annotation method before suite, before test, before class, before method and then @Test.