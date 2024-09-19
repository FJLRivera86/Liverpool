package com.apex.liverpool.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	// Page Elements
	@FindBy(xpath = "//title")
	private WebElement title;
	
	@FindBy(id = "username")
	private WebElement userInput;
	
	@FindBy(id = "password")
	private WebElement passwordInput;
	
	@FindBy(xpath = "//button[@name='action']")
	private WebElement loginButton;
	
	@FindBy(xpath = "//img[contains(@alt,'Playstation 5') and not(contains(@alt,'Consola'))]")
	private WebElement searchResults;
	
	// Methods
	public String titleText() {
		return title.getText();
	}
	public void login(String email, String password) {
		userInput.sendKeys(email);
		passwordInput.sendKeys(password);
		loginButton.click();
	}

}
