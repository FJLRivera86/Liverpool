package com.apex.liverpool.base;

import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;

import com.apex.liverpool.page.CategoryPage;
import com.apex.liverpool.page.HomePage;
import com.apex.liverpool.page.ItemPage;
import com.apex.liverpool.page.LoginPage;
import com.apex.liverpool.page.StorePage;
import com.apex.liverpool.page.VerificationCodePage;

public class BaseTest {
	
	public WebDriver driver;
	public JavascriptExecutor js;
	public SoftAssert softAssert;
	public VerificationCodePage pageV;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public CategoryPage pageC;
	public HomePage pageH;
	public LoginPage pageL;
	public StorePage pageS;
	public ItemPage pageI;
	public String path = "";
	public String userName = "";
	public String email = "";
	public String password = "";
	public String item001 = "";
	public String item002 = "";
	public String brand001 = "";
	public String brand002 = "";
	
	@BeforeClass
	public void setup() {
		path = "C:\\Users\\chlos\\Documents\\workspace-java\\liverpool\\data\\credentials.xlsx";
		// Objects of the related Page classes
		driver = new ChromeDriver();
		softAssert = new SoftAssert();
		pageH = new HomePage(driver); 
		pageL = new LoginPage(driver); 
		pageI = new ItemPage(driver); 
		pageS = new StorePage(driver);
		pageC = new CategoryPage(driver); 
		pageV = new VerificationCodePage(driver);  
		
		js = (JavascriptExecutor) driver;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.liverpool.com.mx/tienda/home");
	}
	
	@AfterClass
	public void teardown() {
		if(driver != null) {
			// driver.close() sends some errors
			driver.quit();
		}
	}

}
