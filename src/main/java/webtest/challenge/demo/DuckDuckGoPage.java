package webtest.challenge.demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

//this class method runs the tests
public class DuckDuckGoPage {
	
	// Page Constants section
    // The login.html page is local on my web drive 
	//private static final String LOGIN_URL = "login.html";
	private static final String URL = "https://duckduckgo.com/";
	private static final String TEXT = "Selenium";

	public WebDriver driver;
	WebElement element;

	/**
	 * Login Employee Dashbaord. Finds the Username and Password elements and enters credentials.
	 * Then clicks Login Button
	 * 
	 */
    public void launch(){
    	
		//creates clean session-clean cache etc
		//DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		//capabilities.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);

		ChromeOptions NewChromeOptions = new ChromeOptions();

		WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

		WebDriverWait wait;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        //tries to execute commands to open chrome
				try {
					if (driver == null) {
						System.out.println("Driver is null");
						return;
					}
					driver.navigate().to(URL);
					Thread.sleep(50);
					driver.manage().window().maximize();


					//explicit wait - to wait for the button to be click-able
					wait.until(ExpectedConditions.elementToBeClickable(By.id(Elems.TEXT_AREA.getElem())));

					//Enter Search Text
					/**driver.findElement(By.name(Elems.LOGIN_USERNAME.getElem())).sendKeys(USER);
					Thread.sleep(2000); */

					//if exception executing above code, outputs issues
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
	}

	/**
	 * Launches the Add Employee UI
	 *
	 */
	public void enterSearchText() {
		try {

			//Enter Text
			driver.findElement(By.id(Elems.TEXT_AREA.getElem())).sendKeys(TEXT);
			Thread.sleep(2000);

			//if exception executing above code, outputs issues
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void clickSearch() {
		try {

			//Click Search and DuckDuckGo searches for Selenium
			driver.findElement(By.xpath(Elems.SEARCH_BTN.getElem())).click();
			Thread.sleep(5000);

			//if exception executing above code, outputs issues
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Title typically becomes e.g., "selenium webdriver at DuckDuckGo"
		assertTrue(
				driver.getTitle().toLowerCase().contains("selenium"),
				"Expected page title to include 'selenium' but was: " + driver.getTitle()
		);

	}

	public void tearDown(){
		if (driver != null){
			driver.quit();
		}
	}
}
