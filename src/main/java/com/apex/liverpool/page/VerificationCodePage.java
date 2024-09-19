package com.apex.liverpool.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VerificationCodePage {
	
	WebDriver driver;
	
	public VerificationCodePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Page Elements
	@FindBy(xpath = "//h1")
	private WebElement mainTitle;
	
	@FindBy(id = "code")
	private WebElement codeInput;
	
	@FindBy(xpath = "//form/button[@name='action']")
	private WebElement sendCodeLink;
	
	@FindBy(xpath = "//div/button[@name='action']")
	private WebElement continuenButton;
	
	// Methods
	public String titleText() {
		return mainTitle.getText();
	}
	
	public void sendCode() {
		sendCodeLink.click();
	}
	
	public void clickContinue() {
		continuenButton.click();
	}

}