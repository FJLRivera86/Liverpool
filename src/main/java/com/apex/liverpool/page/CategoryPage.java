package com.apex.liverpool.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CategoryPage {
	
	WebDriver driver;
	// Constructor
	public CategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	// Page Elements
	@FindBy(xpath = "//i[contains(@class,\"i-hammenu\")]")
	private WebElement categoryMenu;
	
	@FindBy(xpath = "//a[contains(@as,\"belleza\")]")
	private WebElement categoryOption;
	
	@FindBy(xpath = "//a[contains(@href,\"perfumes-hombre\")]")
	private WebElement subCategoryOption;
	
	// Methods
	public void clickCategoryMenu() {
		categoryMenu.click();
	}

	public void hoverCategoryOption() {
		Actions action = new Actions(driver);
		action.moveToElement(categoryOption).perform();
	}

	public void clickSubCategory() {
		subCategoryOption.click();
	}
}
