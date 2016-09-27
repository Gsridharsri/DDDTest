package com.vmetry.ntltaxi.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.LogStatus;
import com.vmetry.initializer.initializer;

public class screenShotGenerator extends initializer {
public static void generateScreenshot(ITestResult it) throws IOException
{
	Object[] data = it.getParameters();
	if(it.isSuccess())
	{
		String path = takeScreenshot(data[0].toString());
		log.addScreenCapture(path);
		log.log(LogStatus.PASS, "Testcase pass", path);
	}
	else 
	{
		String path = takeScreenshot(data[0].toString());
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

