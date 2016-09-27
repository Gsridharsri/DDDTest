package com.vmetry.ntltaxi.pages;

import org.openqa.selenium.WebDriver;

import com.vmetry.initializer.WebDriverFunction;
import com.vmetry.initializer.initializer;

public class HomePage extends initializer{

	public static void eneterusername(String username)
	{
		getWebelementbyxpath("HOMEPAGE_USERNAME_TYPE_XPATH").sendKeys(username);
	}
public static void entermobno(String mobileno)
{
	getWebelementbyxpath("HOMEPAGE_MOBILE_TYPE_XPATH").sendKeys(mobileno);
	}
public static void eneterpicadd(String picadd)
{
	getWebelementbyxpath("HOMEPAGE_PICADD_TYPE_XPATH").sendKeys(picadd);
	}
public static void eneterdropadd(String dropadd)
{
	getWebelementbyxpath("HOMEPAGE_DROPADD_TYPE_XPATH").sendKeys(dropadd);
	}

public static void selectbasic(String basic)
{
	WebDriverFunction.selectDropdownByVisibleText("HOMEPAGE_BASIC_SELECT_XPATH", basic);
	}

public static void clickbooklater()
{
	getWebelementbyxpath("HOMEPAGE_BOOKLATER_CLICK_XPATH").click();
	}
}

