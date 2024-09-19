package com.apex.liverpool.page;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StorePage {
	
	WebDriver driver;
	
	public StorePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	// Page Elements
	@FindBy(xpath = "(//a[(contains(@href, 'playstation-5') and contains(@href, 'consola')) or (contains(@href, 'ps5') and contains(@href, 'consola'))])[1]")
	private WebElement findConsole;
	
	//@FindBy(xpath = "()[1]")
	//sprivate WebElement findGame;

	@FindBy(xpath = "(//a[(contains(@href, 'playstation-5') and contains(@href, 'consola')) or (contains(@href, 'ps5') and contains(@href, 'consola'))])[1]//parent::h3")
	private WebElement itemTitle;

	@FindBy(xpath = "(//a[(contains(@href, 'playstation-5') and contains(@href, 'consola')) or (contains(@href, 'ps5') and contains(@href, 'consola'))])[1]//parent::p")
	private WebElement itemPrice;
	
	@FindBy(id = "searchBrand")
	private WebElement searchBrand;
	
	@FindBy(id = "brand-DIOR")
	private WebElement brandSearched;
	
	@FindBy(id = "brand-SONY")
	private WebElement brandFiltered;
	
	@FindAll(@FindBy(xpath = "//a[(contains(@href, 'playstation-5') and contains(@href, 'consola')) or (contains(@href, 'ps5') and contains(@href, 'consola'))]"))
	List<WebElement> allColsoles;
	
	@FindAll(@FindBy(xpath = "//a[contains(@href, 'ps5')  and contains(@href, 'f%C3%ADsico') and not(contains(@href, 'consola'))]"))
	List<WebElement> allGames;
	
	@FindAll(@FindBy(xpath = "//a[contains(@href,\"dior\")]"))
	List<WebElement> allItems;
	
	@FindAll(@FindBy(xpath = "//input[contains(@id,\"variants.normalizedSize\")]"))
	List<WebElement> allSizes;
	
	@FindAll(@FindBy(xpath = "//input[contains(@id,\"variants.prices.sortPrice\")]"))
	List<WebElement> allPrices;
	
	@FindBy(id ="variants.normalizedSize-55 pulgadas")
	private WebElement selectSize;
	
	@FindBy(id ="variants.prices.sortPrice-10000-700000")
	private WebElement selectPrice;

	@FindBy(className = "searchNum-result")
	private WebElement numResult;
	
	@FindAll(@FindBy(xpath = "//img[@loading=\"lazy\"]"))
	List<WebElement> tvsDisplayed;
	
	// Methods
	public int findConsoles() {
		return allColsoles.size();
	}
	
	public int findGames() {
		return allGames.size();
	}

	public void selectConsole() {
		findConsole.click();
	}
	
	public String getItemTitle() {
		return itemTitle.getText();
	}
	
	public String getItemPrice() {
		return itemPrice.getText(); 
	}
	
	public void searchBrand(String brand) {
		searchBrand.sendKeys(brand);
	}
	
	public void selectBrand() {
		brandSearched.click();
	}
	
	public void selectTVBrand() {
		brandFiltered.click();
	}
	
	public void selectTVPrice() {
		selectPrice.click();
	}
	
	public void selectTVSize() {
		selectSize.click();
	}
	
	public int brandItems() {
		return allItems.size();
	}
	
	public int sizeChecks() {
		return allSizes.size();
	}
	
	public int priceRadio() {
		return allPrices.size();
	}
	
	public int tvsDisplayed() {
		return tvsDisplayed.size();
	}

	public int totalResult() {
		String resultString;
		char resultChar;
		int resultInt;
		
		resultString = numResult.getText();
		resultChar = resultString.charAt(1);
		resultString = Character.toString(resultChar);
		resultInt = Integer.parseInt(resultString);
		
		return resultInt;	  
	}
	 
}
