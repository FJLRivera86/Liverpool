package com.apex.liverpool.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Setup {
	
	public static WebDriver getDriver() {
		return new ChromeDriver();
	}

}
