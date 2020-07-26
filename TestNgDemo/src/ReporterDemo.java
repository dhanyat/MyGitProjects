
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.*;
 
public class ReporterDemo {
   

	  private WebDriver driver;
	  private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();
	  
	  
	/*  @BeforeClass

	  public void setUp() throws Exception {
		
		
		//PropertyConfigurator.configure("log4j.properties");
		
		
		System.setProperty("webdriver.chrome.driver","D:\\Automation Softwares\\chromedriver.exe");
		ChromeOptions chromeOptions = new ChromeOptions();
		driver = new ChromeDriver(chromeOptions);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Reporter.log("Browser Opened");
		driver.manage().window().maximize();
		Reporter.log("Browser Maximized");	
			   
	  }
	  */
    @Test
    public void testReport(){   
    	System.setProperty("webdriver.chrome.driver","D:\\Automation Softwares\\chromedriver.exe");
		ChromeOptions chromeOptions = new ChromeOptions();
		driver = new ChromeDriver(chromeOptions);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Reporter.log("Browser Opened");
		driver.manage().window().maximize();
		Reporter.log("Browser Maximized");	
        
        driver.get("http://www.google.com");
        
        Reporter.log("Application started");
        
        driver.quit();
        
        Reporter.log("Application closed");
        
    }
 
}