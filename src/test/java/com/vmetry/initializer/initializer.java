package com.vmetry.initializer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.vmetry.ntltaxi.utils.ReportOptimizer;

public class initializer {
	public static FileInputStream envfis=null;
	public static Properties envprop=null;
	public static WebDriver wd=null;
	public static FileInputStream locfis = null;
	public static Properties locprop=null;
	public static ExtentReports report;
	public static ExtentTest log;
	public static boolean isArchive=true;

public static void initialize() throws IOException
{
	
	ReportOptimizer.archiveFiles();
	 envfis = new FileInputStream(new File("E:"+File.separator+"selenium"+File.separator+"testing1"+File.separator+"DDDTest"+File.separator+"src"+File.separator+"test"+File.separator+"java"+File.separator+"com"+File.separator+"vmetry"+File.separator+"ntltaxi"+File.separator+"config"+File.separator+"env.properties"));
	 envprop= new Properties();
	envprop.load(envfis);
	
	locfis = new FileInputStream("E:"+File.separator+"selenium"+File.separator+"testing1"+File.separator+"DDDTest"+File.separator+"src"+File.separator+"test"+File.separator+"java"+File.separator+"com"+File.separator+"vmetry"+File.separator+"ntltaxi"+File.separator+"config"+File.separator+"locator.properties");
	locprop= new Properties();
	locprop.load(locfis);
	
	report = new ExtentReports("E:\\selenium\\testing1\\DDDTest\\Report\\DDD.html");
	
	System.out.println(envprop.getProperty("Browser"));
	//if(wd==null)
	//{
	if(envprop.getProperty("Browser").equals("firefox"))
	{
		 wd = new FirefoxDriver();
	}
	else if(envprop.getProperty("Browser").equals("chrome"));
	{
	//	System.setProperty("", "");
	//	wd = new ChromeDriver();
	}
	//}
	wd.manage().window().maximize();
	wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	//wd.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	
	}
public static WebElement getWebelementbyxpath(String Xpath)
{
	return wd.findElement(By.xpath(locprop.getProperty(Xpath)));

}
}
