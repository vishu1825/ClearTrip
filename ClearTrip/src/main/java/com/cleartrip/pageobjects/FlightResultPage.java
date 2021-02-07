/**
 * 
 */
package com.cleartrip.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cleartrip.base.BaseClass;

/**
 * @author vishwajeet
 *
 */
public class FlightResultPage  extends BaseClass {
	  
	FlightResultPage fsp= new FlightResultPage();
	
	@FindBy(xpath="//div[contains(@data-test-attrib,'onward-view')]/div/div[2]")
	private WebElement gngJourneyFlight;
	
	@FindBy(xpath="//div[contains(@data-test-attrib,'return-view')]/div/div[3]")
	private WebElement rtrnJourneyFlight;
	
	@FindBy(xpath="//button[text()='Book']")
	private WebElement bookBtn;
	
	public FlightResultPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement clickOnGngFlight()
	{
	    return  gngJourneyFlight;
	}
	
	public WebElement clickOnReturnFlight(){
		
		return rtrnJourneyFlight;
		
	}
	
	public WebElement clickOnBookBtn()
	{
		return bookBtn;
	}
	


}
