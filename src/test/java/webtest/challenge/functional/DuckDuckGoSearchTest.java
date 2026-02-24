package webtest.challenge.functional;

import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import webtest.challenge.demo.DuckDuckGoPage;

public class DuckDuckGoSearchTest {
	

	// Declares page class object
	private final DuckDuckGoPage duckDuckGoPageTest = new DuckDuckGoPage();

    @Test
  	public void tc01_browseDuckDuckGo() {
    	
     //sets system property to find chromedriver.exe
     // System.setProperty(EXE, PATH);
	  
	  //Step 1. Open Chrome and Go To DuckDuckGo.com
	  //User can Chrome and Go To DuckDuckGo.com
	  System.out.println("Step 1. Launch Browser and Go To DuckDuckGo.com");
	  duckDuckGoPageTest.launch();
	  Reporter.log("Step 1. User can Launch Browser and Go To DuckDuckGo.com");

		//Step 2. Enter Text into text box to search for
		//User can Enter Text into text box to search for
		System.out.println("Step 2. Enter Text into text box to search");
		duckDuckGoPageTest.enterSearchText();
		Reporter.log("Step 1. User can Enter Text into text box to search");

		//Step 3. Click Search to search the web
		//User can Click Search to search the web
		System.out.println("Step 3. Click Search to search the web");
		duckDuckGoPageTest.clickSearch();
		Reporter.log("Step 3. User can Click Search to search the web");
  }

  @AfterMethod(alwaysRun = true)
  public void tearDown() {
	  if (duckDuckGoPageTest.driver != null) {
		  duckDuckGoPageTest.driver.quit();
	  }
  }
}
