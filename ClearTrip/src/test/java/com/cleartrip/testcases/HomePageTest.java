package com.cleartrip.testcases;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cleartrip.base.BaseClass;
import com.cleartrip.pageobjects.HomePage;
import com.cleartrip.util.CalenderUtil;

public class HomePageTest extends BaseClass {

	HomePage homepage;
	@BeforeMethod
	public void setUp() {
		launchApp();
	}

	@Test
	public void enteringFlightDetails() throws InterruptedException {
		homepage = new HomePage();
		WebElement roundTrip = homepage.clickOnRoundTrip();
		roundTrip.click();
		Actions act= new Actions(driver);
		act.sendKeys(homepage.deparatureCityDetails(), "Bangalore").perform();
		act.sendKeys(Keys.ENTER).perform();
		act.sendKeys(homepage.destinationCityDetails(), "Mumbai").perform();
		act.sendKeys(Keys.ENTER).perform();
		CalenderUtil.selectDate();
		WebElement clickSearchFlightBtn = homepage.clickOnSearchFlight();
		clickSearchFlightBtn.click();
		Thread.sleep(3000);
		String actualtitle = driver.getTitle();
		System.out.println(actualtitle);
		
	
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
