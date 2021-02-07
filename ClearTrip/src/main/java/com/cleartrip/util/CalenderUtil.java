package com.cleartrip.util;

import org.openqa.selenium.JavascriptExecutor;

import com.cleartrip.base.BaseClass;

public class CalenderUtil extends BaseClass {
	
	public static void selectDate()
	{
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("document.getElementById('DepartDate').value='Fri, 12 Feb, 2021'");
		js.executeScript("document.getElementById('ReturnDate').value='Sun, 14 Feb, 2021'");

		
	}


}
