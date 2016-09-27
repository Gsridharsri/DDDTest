package com.vmetry.initializer;

import org.openqa.selenium.support.ui.Select;

public class WebDriverFunction  extends initializer{

public static  void selectDropdownByVisibleText(String Xpath,String option)
{
	Select s = new Select(getWebelementbyxpath(Xpath));
	s.selectByVisibleText(option);
	
}
}
