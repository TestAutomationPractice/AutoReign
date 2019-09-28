package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;
import com.crm.qa.base.TestBase;
import com.crm.qa.utility.TestUtil;
import com.crm.qa.utility.ExtentReports.ExtentTestManager;

public class LandingPage extends TestBase {
	
	public LandingPage()
	{

	PageFactory.initElements(driver, this);
	
	}
	
	/* @FindBy (xpath="//ul[@class='rd-navbar-nav']//child::span[contains(text(),'Log In')]")
	WebElement login; */
	
	@FindBy(xpath="//button[@class='btn btn-secondary']")
	WebElement hashLink;
	
	@FindBy(xpath="//li[@class='nav-item']/a[text()='Login']")
	WebElement loginLink;
	
	@FindBy(xpath="//li[@class='nav-item']//child::div[@class='card-body']/input[@name='password']")
	WebElement usernameLink;
	
	@FindBy(xpath="//li[@class='nav-item']//child::div[@class='card-body']/input[@name='username']")
	WebElement passwordLink;
	
	@FindBy(xpath="//li[@class='nav-item']//child::div[@class='card-body']/button[text()='Login']")
	WebElement loginbutton;
	
	@FindBy(xpath="//a[contains(text(),'add movie')]")
	WebElement addMovieLink;
	
	//Actions
	
	public void clickLoginLink()
	{
		
		hashLink.click();
		TestUtil.explicitWait();
		loginLink.click();
		      
		/* return new LoginPage();  */
		
	}
	
	public void login(String username, String password) throws InterruptedException 
	{
		
		usernameLink.sendKeys(password);
		Thread.sleep(3000);
		passwordLink.sendKeys(username);
		Thread.sleep(3000);
		
		loginbutton.click();
		
	}
		
		public HomePage clickAddMovieLink() throws InterruptedException
		{
			WebDriverWait wait = new WebDriverWait(driver,3);
			wait.until(ExpectedConditions.visibilityOf(addMovieLink)).click();
			Thread.sleep(3000);
			//addMovieLink.click();
			
			TestUtil.explicitWait();
			return new HomePage();
		}
	
}
	
