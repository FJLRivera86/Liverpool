package com.apex.liverpool.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	// Create a WebDriver reference variable
	WebDriver driver;
	// Declare the constructor and WebDriver reference as parameter.
	public HomePage(WebDriver driver) {
		this.driver = driver;
		// Call initElements() method by PageFactory reference 
		PageFactory.initElements(driver, this);
	}
	
	// Page Elements to locate the elements in the page
	@FindBy(xpath = "//span[@class='a-header__topLink']")
	private WebElement loginButton;
	
	@FindBy(id = "mainSearchbar")
	private WebElement searchBar;
	
	@FindBy(xpath = "//img[contains(@alt,'Playstation 5') and not(contains(@alt,'Consola'))]")
	private WebElement searchResults;
	
	@FindBy(xpath = "//span[@class='a-header__topLink popover-session']")
	private WebElement userName;
	
	@FindBy(xpath = "(//i[@class='icon-zoom'])[1]")
	private WebElement searchItem;
	
	// Methods to perform operations
	public void clickLogin() {
		loginButton.click();
	}

	public String helloUser() {
		return userName.getText();
	}

	public void typeSearchBar(String searchItem) {
		searchBar.sendKeys(searchItem);
	}
	
	public void clickSearch() {
		searchItem.click();
	}
	
}
