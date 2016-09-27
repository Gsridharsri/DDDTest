package Temp;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ReportTest {
	static WebDriver wd = null;
	ExtentReports report;
	ExtentTest log;
	
	@Test(priority=1)
	public void googletest()
	{
		report = new ExtentReports("E:\\selenium\\testing1\\DDDTest\\Report\\sample.html");
		report.startTest("googletest");
		wd =new FirefoxDriver();
		wd.get("https://www.google.co.in");
		log = report.startTest("google.com");
	}
@Test(priority=2)
public void yahootest()
{
	wd.get("https://in.yahoo.com/");
log =	report.startTest("yahootest");
	
	}
@Test(priority=3)
public void bingTest()
{
	wd.get("https://www.bing.com/");
log =	report.startTest("bingtest");
	}
@AfterMethod
public void teardown(ITestResult it) throws IOException
{
	if(it.isSuccess())
	{
		String path = takeScreenshot(it.getName());
		log.addScreenCapture(path);
		log.log(LogStatus.PASS, "Testcase pass", path);
	}
	else 
	{
		String path = takeScreenshot(it.getName());
		log.addScreenCapture(path);
		log.log(LogStatus.FAIL, "Testcase pass", path);
	}
	report.endTest(log);
	report.flush();
	}
public static String takeScreenshot(String name) throws IOException
{
	File src =((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);
	File dst= new File("E:\\selenium\\testing1\\DDDTest\\Screenshot\\"+name+".jpg");
	FileUtils.copyFile(src,dst );
	return dst.toString();
	
	}
}

