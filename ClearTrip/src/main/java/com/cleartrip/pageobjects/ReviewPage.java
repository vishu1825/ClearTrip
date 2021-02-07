/**
 * 
 */
package com.cleartrip.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cleartrip.base.BaseClass;

/**
 * @author Vishwajeet
 *
 */
public class ReviewPage extends BaseClass {
	
	ReviewPage rp= new ReviewPage();
	
	@FindBy(xpath="//h2[text()='Review your itinerary']")
	private WebElement reviewTitle;
	
	public ReviewPage()
	{
		PageFactory.initElements(driver, this);

	}
	
	public boolean reviewTitleConf()
	{
		boolean flag = reviewTitle.isDisplayed();
		return flag;
	}
}
