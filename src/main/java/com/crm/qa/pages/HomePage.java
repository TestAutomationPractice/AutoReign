package com.crm.qa.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;
import com.crm.qa.utility.TestUtil;

public class HomePage extends TestBase

{
	
	@FindBy(xpath="//input[@name='title']")
	WebElement movie_title;
	
	@FindBy (xpath="/input[@name='director']")
	WebElement movie_director;
	
	@FindBy(xpath="//textarea[@name='description']")
	WebElement movie_description;
	
	@FindBy(xpath="//select[@class='form-control']")
	WebElement movie_category;
	
	@FindBy(xpath="//input[@name='file']")
	WebElement movie_url;
	
	@FindBy(xpath="//label[contains(text(),'Rating')]//parent::*//child::div//child::svg[1]")
	WebElement movie_ratings;
	
	public HomePage() 
	{
		
		PageFactory.initElements(driver, this);

	}
	//Actions

	public void addMovieDetails(String title, String director, String description, String category, String url, String ratings)
	
	{
		
		movie_title.sendKeys(title);
		movie_director.sendKeys(director);
		movie_description.sendKeys(description);
		
		Select cat = new Select(movie_category);
		cat.selectByVisibleText(category);
		
		movie_url.sendKeys(url);
		
		movie_ratings.click();
		
	}
	
	
	
	/*public ContactsPage clickContactsLink()
	{
		System.out.println("In the ContactsLink() method, clicking contactsLink on the Page");
		
		//driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.visibilityOf(contactsLink));
	
		contactsLink.click();
		TestUtil.explicitWait();
		return new ContactsPage();
	}*/

