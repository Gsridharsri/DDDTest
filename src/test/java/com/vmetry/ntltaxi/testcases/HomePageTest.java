package com.vmetry.ntltaxi.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vmetry.initializer.initializer;
import com.vmetry.ntltaxi.inputreader.inputReader;
import com.vmetry.ntltaxi.pages.HomePage;
import com.vmetry.ntltaxi.utils.screenShotGenerator;

public class HomePageTest extends initializer {

	@BeforeTest
	public void setup() throws IOException {
		initialize();
	}

	@Test(dataProvider = "HomePageTest")
	public void validatehomepage(String testdata, String username,
			String mobileno, String Picadd, String Dropadd, String basic)
			throws IOException {
		log = report.startTest(testdata);
		
		wd.get(envprop.getProperty("URL"));
		// wd.findElement(By.xpath(locprop.getProperty("HOMEPAGE_USERNAME_TYPE_XPATH"))).sendKeys("test");
		HomePage.eneterusername(username);
		HomePage.entermobno(mobileno);
		HomePage.eneterpicadd(Picadd);
		HomePage.eneterdropadd(Dropadd);
		HomePage.selectbasic(basic);
		HomePage.clickbooklater();

	}

	@DataProvider(name = "HomePageTest")
	public static Object[][] getHomePageData() throws Exception {

		if(inputReader.runModeVerification("HomePageTest")){
		Object[][] data =inputReader.selectSingleDataOrMulitiData("HomePageTest");

		return data;
		}
		return null;

	}

	@AfterMethod
	public void tearDown(ITestResult it) throws IOException {
		screenShotGenerator.generateScreenshot(it);

	}
	
	
//	
//	@DataProvider(name = "HomePageTest")
//	public static Object[][] getHomePageData() {
//
//		Object[][] data = new Object[3][6];
//		data[0][0] = "HomePageTest_DataSet1";
//		data[0][1] = "testa";
//		data[0][2] = "123456789";
//		data[0][3] = "ADYAR";
//		data[0][4] = "ADYAR";
//		data[0][5] = "Sedan";
//
//		data[1][0] = "HomePageTest_DataSet2";
//		data[1][1] = "testb";
//		data[1][2] = "123456789";
//		data[1][3] = "ADYAR";
//		data[1][4] = "ADYAR";
//		data[1][5] = "Sedan";
//
//		data[2][0] = "HomePageTest_DataSet3";
//		data[2][1] = "testc";
//		data[2][2] = "123456789";
//		data[2][3] = "ADYAR";
//		data[2][4] = "ADYAR";
//		data[2][5] = "Sedan";
//
//		return data;
//
//	}
}
