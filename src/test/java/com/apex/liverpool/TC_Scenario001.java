package com.apex.liverpool;

import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.apex.liverpool.base.BaseTest;

public class TC_Scenario001 extends BaseTest{
	
  Set<Cookie> allCookies;
	
  @Test(priority=0)
  public void save_cookies() throws InterruptedException {
	  	System.out.println("************************************ Save Cookies");
		try {
			workbook = new XSSFWorkbook(path);
			sheet = workbook.getSheet("login");
			email = sheet.getRow(1).getCell(0).getStringCellValue();
			password = sheet.getRow(1).getCell(1).getStringCellValue();
			userName = sheet.getRow(1).getCell(2).getStringCellValue();
			item001 = sheet.getRow(1).getCell(3).getStringCellValue();
			item002 = sheet.getRow(1).getCell(4).getStringCellValue();
			brand001 = sheet.getRow(1).getCell(5).getStringCellValue();
			brand002 = sheet.getRow(1).getCell(6).getStringCellValue();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.liverpool.com.mx/tienda/home");
		driver.manage().window().maximize();
		
		pageH.clickLogin();
		pageL.login(email, password);
		pageV.sendCode();
		Thread.sleep(20000);
		pageV.clickContinue();
		//Save the cookies
		allCookies = driver.manage().getCookies();
		Assert.assertEquals(pageH.helloUser(), "Hola " + userName);
  }
  
  @Test(priority=1)
  public void scenario001() throws InterruptedException {
	  	System.out.println("************************************ Scenario001");

		driver.get("https://www.liverpool.com.mx/tienda/home");
		//Re use cookies stored
		for(Cookie cookie :allCookies) {
			driver.manage().addCookie(cookie);
		}
		driver.manage().window().maximize();
		
		pageH.typeSearchBar(item001);
		pageH.clickSearch();
		//Assert.assertTrue(pageS.findConsole());
		// Saving values for assert comparison
		String itemTitleS = pageS.getItemTitle();
		String itemPriceS = pageS.getItemPrice();
		js.executeScript("window.scrollBy(0,1000)", "");
		// softAsserts are only to validate if there is at least one item of each type
		softAssert.assertTrue(pageS.findGames() > 0);
		softAssert.assertTrue(pageS.findConsoles() > 0);
		softAssert.assertAll();
		pageS.selectConsole();
		Assert.assertEquals(pageI.getItemTitle(), itemTitleS);
		Assert.assertEquals(pageI.getItemPrice(), itemPriceS);
  }
  
  @Test(priority=2)
  public void scenario002() throws InterruptedException {
	  	System.out.println("************************************ Scenario002");

		driver.get("https://www.liverpool.com.mx/tienda/home");
		pageH.typeSearchBar(item002);
		pageH.clickSearch();
		Assert.assertTrue(pageS.sizeChecks() > 1);	
		Assert.assertTrue(pageS.priceRadio() > 1);	
		pageS.searchBrand(brand002);
		pageS.selectTVBrand();
		Thread.sleep(1000);
		pageS.selectTVPrice();
		Thread.sleep(1000);
		pageS.selectTVSize();
		Thread.sleep(1000);
		//System.out.println("-------------- " + pageS.tvsDisplayed());
		//System.out.println("-------------- " + pageS.totalResult());
		Assert.assertEquals(pageS.tvsDisplayed(), pageS.totalResult());
  }
  
  @Test(priority=3)
  public void scenario003() throws InterruptedException {
	  	System.out.println("************************************ Scenario003");

		driver.get("https://www.liverpool.com.mx/tienda/home");
		driver.manage().window().maximize();
		pageC.clickCategoryMenu();
		pageC.hoverCategoryOption();
		pageC.clickSubCategory();
		js.executeScript("window.scrollBy(0,600)", "");
		pageS.searchBrand(brand001);
		pageS.selectBrand();
		Assert.assertTrue(pageS.brandItems() > 1);	
  }
}
