package com.cleartrip.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cleartrip.base.BaseClass;

public class HomePage extends BaseClass{
	
	
	@FindBy(id="RoundTrip")
	WebElement roundTripEle;
	
	@FindBy(id="FromTag")
	private WebElement departureCity;
	
	@FindBy(id="ToTag")
	private WebElement destinationCity;
	
	@FindBy(id="DepartDate")
	private WebElement departDate;
	
	@FindBy(id="ReturnDate")
	private WebElement returnDate;

	@FindBy(id="SearchBtn")
	private WebElement searchFlightBtn;
	
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement clickOnRoundTrip()
	{
		return roundTripEle;
	}
	
	
	public WebElement clickOnDepartDate()
	{
		return departDate;
	}
	
	public WebElement clickOnReturnDate()
	{
		return returnDate;
	}
	
	public WebElement deparatureCityDetails()
	{
		return departureCity;
	}
	
	public WebElement destinationCityDetails()
	{
		return destinationCity;
	}
	
	
	
	public WebElement clickOnSearchFlight()
	{
		return searchFlightBtn;
		//return new FlightResultPage();
	}  
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}