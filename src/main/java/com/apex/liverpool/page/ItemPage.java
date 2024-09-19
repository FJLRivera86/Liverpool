package com.apex.liverpool.page;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ItemPage {
	
	WebDriver driver;
	
	public ItemPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	// Page Elements	
	@FindBy(xpath = "//h1")
	private WebElement itemTitle;
	
	@FindBy(xpath = "(//p[contains(@class,\"a-product\")])[1]")
	private WebElement itemPrice;
	
	// Methods
	public String getItemTitle() {
		return itemTitle.getText();
	}
	// StringUtils its to avoid the line break
	public String getItemPrice() {
		String price;
		price = itemPrice.getText();
		price = StringUtils.left(price,6) + StringUtils.right(price,2);
		return price;	 
	}
}
