package webtest.challenge.employee;

import static org.openqa.selenium.remote.DesiredCapabilities.*;
import static org.testng.Assert.fail;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

//this class method runs the tests
public class App {
	
	// Page Constants section
    // The login.html page is local on my web drive 
	//private static final String LOGIN_URL = "login.html";
	private static final String LOGIN_URL = "login.html";
	private static final String USER = "testUser";
	private static final String PASS = "Test1234";	
	private static final String FIRST = "Leo";
	private static final String LAST = "Goss";	
	private static final String DEPENDENTS = "2";
	private static final String BENEFIT_COST = "76.92";	
	private static final String NET_PAY = "1923.08";


	WebDriver driverObj;
	WebElement element;

	/**
	 * Login Employee Dashbaord. Finds the Username and Password elements and enters credentials.
	 * Then clicks Login Button
	 * 
	 */
    public void login(){
    	
		//creates clean session-clean cache etc
		//DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		//capabilities.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);

		ChromeOptions NewChromeOptions = new ChromeOptions();

		//WebDriverManager.chromedriver().setup();
        driverObj= new ChromeDriver();
		
		WebDriverWait wait;
        wait = new WebDriverWait(driverObj, Duration.ofSeconds(20));

        //tries to execute commands to open chrome > navigate to login
				try {
					if (driverObj == null) {
						System.out.println("Driver is null");
						return;
					}
					driverObj.navigate().to("https://www.google.com");
					Thread.sleep(50);
					driverObj.manage().window().maximize();
					
					//explicit wait - to wait for the button to be click-able
					wait.until(ExpectedConditions.elementToBeClickable(By.id(Elems.LOGIN_BUTTON.getElem())));
					
					//Enter USername
					driverObj.findElement(By.name(Elems.LOGIN_USERNAME.getElem())).sendKeys(USER);
					Thread.sleep(2000);
					//Enter Password
					driverObj.findElement(By.name(Elems.LOGIN_PASSWORD.getElem())).sendKeys(PASS);
					Thread.sleep(2000);
					//Click Login
					driverObj.findElement(By.id(Elems.LOGIN_BUTTON.getElem())).click();
					Thread.sleep(5000);
					
					//Set element object to Add Employee element
					element = driverObj.findElement(By.id(Elems.ADD_EMPLOYEE_BTN.getElem()));
					
					//Checks to see if the Add Employee button is displayed to show dashbaord logged in
					if (element.isDisplayed()){
						System.out.println("Expected Result Returned, Login Benefits Dashboard page launched");
					}else{
						fail("Expected Result Was NOT Returned, Login Benefits Dashboard page page Has Failed");
						System.out.println("Expected Result Was NOT Returned, Login Benefits Dashboard page Has Failed");
					}
					
					//if exception executing above code, outputs issues
				} catch (InterruptedException e) {
					e.printStackTrace();
				} 

	}

	/**
	 * Launches the Add Employee UI
	 * 
	 */
	public void launchAddEmployee() {
		try {
			
			driverObj.findElement(By.id(Elems.ADD_EMPLOYEE_BTN.getElem())).click();
			Thread.sleep(5000);			
		
			//Set element object to Submit btn element
			element = driverObj.findElement(By.xpath(Elems.SUBMIT_BTN.getElem()));
			
			//Checks to see if the button is displayed 
			if (element.isDisplayed()){
				System.out.println("Expected Result Returned, Add Employee & His dependents page launched");
			}else{
				fail("Expected Result Was NOT Returned, Add Employee & His dependents page Has Failed");
				System.out.println("Expected Result Was NOT Returned, Add Employee & His dependents page Has Failed");
			}
			
			//if exception executing above code, outputs issues
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
		
	}

	/**
	 * Fills out new employee data
	 * 
	 */
	public void addEmployee() {
		
	    WebDriverWait wait = new WebDriverWait(driverObj, Duration.ofSeconds(20));
	    
		try {
			//explicit wait - to wait for the submit button to be click-able
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Elems.SUBMIT_BTN.getElem())));
			
			//First Name
			driverObj.findElement(By.xpath(Elems.ADD_EMPLOYEE_FIRST.getElem())).sendKeys(FIRST);
			Thread.sleep(2000);
			//Last Name
			driverObj.findElement(By.xpath(Elems.ADD_EMPLOYEE_LAST.getElem())).sendKeys(LAST);
			Thread.sleep(2000);
			//Dependents
			driverObj.findElement(By.xpath(Elems.ADD_EMPLOYEE_DEPENDENTS.getElem())).sendKeys(DEPENDENTS);
			Thread.sleep(2000);
				
			System.out.println("Expected Result Returned: Users able to enter employee details - First Name, Last name, and 2 Dependents");
			
			//if exception executing above code, outputs issues
		} catch (InterruptedException e) {
			fail("Users able to enter employee details Failed");
			e.printStackTrace();
			System.out.println("Users able to enter employee details Failed.");
		} 
		
				
	}

	/**
	 *  Clicks the submit button of the add employee UI
	 * 
	 */
	public void clickSubmitBtn() {
		try {			
			driverObj.findElement(By.xpath(Elems.SUBMIT_BTN.getElem())).click();
			Thread.sleep(5000);

	   } catch (InterruptedException e) {
		   fail("Submit Button was not clicked");
			e.printStackTrace();			
		} 
				
	}

	/**
	 *  Method validates the new employee data has been added to the Benefits Dashboard table. 
	 *  The data is hard coded that is entered so the method validate page content agasint
	 *  declared Constants.
	 * 
	 */
	public void seeEmployeeInTable() {
		//Gets text of First and Last name to be compared to what was entered in add employee
		//I used static xpath for the names in the table for the test
		try {			
			Thread.sleep(3000);	
			String firstResult = driverObj.findElement(By.xpath(Elems.FIRST_NAME.getElem())).getText();
			String lastResult = driverObj.findElement(By.xpath(Elems.LAST_NAME.getElem())).getText();

			//Checks to see if the button is displayed 
			if (firstResult.equals(FIRST) && lastResult.equals(LAST)){
				System.out.println("Expected Result Returned, the user should see the employee "+ firstResult + " "
						+ lastResult +" in the table");
			}else{
				fail("Expected Result Was NOT Returned, the user should see the employee in the table Has Failed");
				System.out.println("Expected Result Was NOT Returned, the user should see the employee in the table Has Failed");
			}
			
			//if exception executing above code, outputs issues
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
		
	}

	/**
	 *  Method validates the new Correct Calculations are added to the Benefits Dashboard table. 
	 *  The data is hard coded that is entered so the method validate page content against
	 *  declared Constants.
	 * 
	 */
	public void seeCorrectCalculations() {
		//Gets text of Benefit Cost and Net Pay to be compared to what was entered in add employee
		//and known correct calculation 76.92 = net pay 1923.08 (2 dep)
		//The calculations are confirmed correct and the input is hard-coded
		//The xpath for the <td> is static for the purposes of the test
		try {
			
			Thread.sleep(3000);				
			String benResult = driverObj.findElement(By.xpath(Elems.BENEFIT_COST.getElem())).getText();
			String netResult = driverObj.findElement(By.xpath(Elems.NET_PAY.getElem())).getText();
			
			//Checks to see if the button is displayed 
			if (benResult.equals(BENEFIT_COST) && netResult.equals(NET_PAY)){
				System.out.println("Expected Result Returned, Benefit cost calculations are correct "+ benResult + " "
						+ netResult +" in the table");
			}else{
				fail("Expected Result Was NOT Returned, Benefit cost calculations Has Failed " + benResult + " "
						+ netResult);
				System.out.println("Expected Result Was NOT Returned, Benefit cost calculations Has Failed " + benResult + " "
						+ netResult);
			}
			
			//if exception executing above code, outputs issues
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
		
		//Closes Browser
		driverObj.close();		
	}	
	
}
