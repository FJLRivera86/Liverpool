package com.apex.liverpool;

import org.testng.annotations.Test;
import com.apex.liverpool.base.BaseTest;


public class TC_ScenarioTest extends BaseTest{
	
  @Test(priority=1)
  public void scenario_test() throws InterruptedException {
	  System.out.println("************************************ debugScenario");
	  
	  driver.get("https://www.liverpool.com.mx/tienda/home");
	  pageH.typeSearchBar(item002);
	  pageH.clickSearch();
  }
}
