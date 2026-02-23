package webtest.challenge.functional;

import org.testng.Reporter;
import org.testng.annotations.Test;


import webtest.challenge.demo.App;

public class AppTest {
	
	private static final String EXE = "webdriver.chrome.driver";
	private static final String PATH = "C:\\Users\\cagoss\\Documents\\Automation\\ChromeDriver\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe";

	
	// Declares page class object
	private App appTest = new App();

    @Test
  	public void tc01_addEmployeeNoDiscount() {
    	
     //sets system property to find chromedriver.exe
     System.setProperty(EXE, PATH);
	  
	  //Step 1. Login to demo Benefits Dashboard page
	  //User can login to Benefits Dashboard page	  
	  System.out.println("Step 1. Login to demo Benefits Dashboard page");
	  appTest.login();
	  Reporter.log("Step 1. User can login to Benefits Dashboard page");
	  
	  //Step 2. Select Add Employee	
	  //Add Employee & His dependents UI appears
	  System.out.println("Step 2. Select Add Employee");
	  appTest.launchAddEmployee();
	  Reporter.log("Step 2. Add Employee & His dependents UI appears");
	  
	  //Step 3. User Adds demo details in the fields - First Name, Last name, and 1 Dependents
	  //Users able to enter demo details - First Name, Last name, and 1 Dependents
	  // First Name does NOT begin with “A” or “a” Enter 1 Dependents"
	  System.out.println("Step 3. First Name does NOT begin with 'A' or 'a' Enter 2 Dependents");
	  appTest.addEmployee();
	  Reporter.log("Step 3. Users able to enter demo details - First Name, Last name, and 2 Dependents");
	  
	  //Step 4. Employee should save by clicking the submit button	
	  //Employee can click the submit button
	  System.out.println("Step 4. Employee should save by clicking the submit button");
	  appTest.clickSubmitBtn();
	  Reporter.log("Step 4. Employee can click the submit button");
	  
	  //Step 5. After submitting Employee, the user should see the demo in the table
	  //The user can see the demo in the table
	  System.out.println("Step 5. After submitting Employee, the user should see the demo in the table");
	  appTest.seeEmployeeInTable();
	  Reporter.log("Step 5. The user can see the demo in the table");
	  
	  //Step 6. Benefit cost calculations are correct
	  //Benefit cost calculations are correct (Benefits for this user are  $1500/year)
	  //Gross Pay = 2000 per paycheck - (2 dep) benefits (- 76.92 = net pay 1923.08)
	  System.out.println("Step 6. Benefit cost calculations are correct");
	  appTest.seeCorrectCalculations();
	  Reporter.log("Step 6. Benefit cost calculations are correct");


  }
}
