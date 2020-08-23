package stepDefinitions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.After;
import cucumber.api.java.AfterStep;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import seleniumTests.ExcelreadandWrite;
import seleniumTests.Screenshot;

public class Steps {
	static WebDriver driver;
	ExcelreadandWrite erw ;
	Screenshot screenshot;
	 

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","D:\\Automation Softwares\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	 
	@Given("^I have launch URL$")
	public void i_have_launch_URL() throws Throwable {
		driver.get("https://www.dbs.com.sg/index/default.page");
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class ='dbs-group' ]/a/button")));

	}

	@When("^I click on LearnMore button$")
	public void i_click_on_LearnMore_button() throws Throwable {		
		driver.findElement(By.xpath("//p[@class ='dbs-group' ]/a/button")).click();
	}

	@When("^Scroll down and navigate to Singapore on the left panel$")
	public void scroll_down_and_navigate_to_Singapore_on_the_left_panel() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='navbar-links-left'] //a[@data-node ='jwxuznof']")));
	    driver.findElement(By.xpath("//div[@class='navbar-links-left'] //a[@data-node ='jwxuznof']")).click();
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text() ='Creating Social Impact']")));
		driver.findElement(By.xpath("//a[text() ='Creating Social Impact']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href = '/sustainability/dbs-stronger-together-fund'] [text() = 'DBS Stronger Together Fund']")));
		driver.findElement(By.xpath("//a[@href = '/sustainability/dbs-stronger-together-fund'] [text() = 'DBS Stronger Together Fund']")).click();
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class = 'left-nav nav navbar-nav'] //li[3]/a")));
		WebElement element = driver.findElement(By.xpath("//ul[@class = 'left-nav nav navbar-nav'] //li[4]/a"));
		JavascriptExecutor js = (JavascriptExecutor) driver;  
		js.executeScript("arguments[0].scrollIntoView();",element);

	}

	@Then("^I Read and write the table in excel sheet$")
	public void i_Read_and_write_the_table_in_excel_sheet() throws Throwable {
		erw = new ExcelreadandWrite();
		String ssname = "Data";
		screenshot = new Screenshot(driver, ssname);
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class = 'col-md-8 col-sm-8 left-content'] //table")));
		WebElement table = driver.findElement(By.xpath("//div[@class = 'col-md-8 col-sm-8 left-content'] //table"));
		List<WebElement> rows = table.findElements(By.xpath("//div[@class = 'col-md-8 col-sm-8 left-content'] //table/tbody/tr"));
		int rowCount = rows.size();
			
		List<WebElement> cols = table.findElements(By.xpath("//div[@class = 'col-md-8 col-sm-8 left-content'] //table/tbody/tr[1]/td"));
		int colCount = cols.size();	
		screenshot.TakeScreenShot(driver);	
		String beforeXpath_1 = "//div[@class = 'col-md-8 col-sm-8 left-content'] //table/tbody/tr[";
		String afterXpath_1 = "]/td[";
		String afterXpath_2 = "]";
			
	    String[][] tableValues = new String[rowCount][colCount];
			
		for(int i=1;i<=rowCount;i++) {				
			for(int j=1;j<=colCount;j++) {
				String actualXpath = beforeXpath_1+i+afterXpath_1+j+afterXpath_2;
				String value = table.findElement(By.xpath(actualXpath)).getText();
				tableValues[i-1][j-1] = value;		
			}
		}
		
		erw.writetoExcel1(rowCount, colCount, tableValues);
		
	}

	@Then("^I click on 'About' tab in header$")
	public void i_click_on_About_tab_in_header() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class = 'navbar-links-left'] //a[text() = 'About']")));
		driver.findElement(By.xpath("//div[@class = 'navbar-links-left'] //a[text() = 'About']")).click();

	}

	@Then("^I Navigate to Who we are tab$")
	public void i_Navigate_to_Who_we_are_tab() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text() = 'Who We Are']")));
		driver.findElement(By.xpath("//a[text() = 'Who We Are']")).click();	

	}

	@Then("^I Navigate to OurAwards & Accolades$")
	public void i_Navigate_to_OurAwards_Accolades() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text() = 'Our Awards & Accolades']")));
		driver.findElement(By.xpath("//a[text() = 'Our Awards & Accolades']")).click();

	}

	@Then("^I validate the total number of awards displayed on the page is (\\d+)$")
	public void i_validate_the_total_number_of_awards_displayed_on_the_page_is(int arg1) throws Throwable {
		String ssname = "Awards";
		screenshot = new Screenshot(driver,ssname);
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class = 'col-md-8']")));
		List<WebElement> awards = driver.findElements(By.xpath("//div[@class = 'col-md-8']"));	
		
		WebElement element = driver.findElement(By.xpath("//div[@class = 'col-md-8']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;  
		js.executeScript("arguments[0].scrollIntoView();",element);
		
		screenshot.TakeScreenShot(driver);	
		
		Assert.assertEquals(22, awards.size(), "Total number of awards displying are"+awards.size() );
		
		

	}

	@Then("^I validate all the award name and caption of the awards$")
	public void i_validate_all_the_award_name_and_caption_of_the_awards() throws Throwable {
		erw = new ExcelreadandWrite();
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='col-md-8']/h3/Strong")));
		List<WebElement> name = driver.findElements(By.xpath("//div[@class='col-md-8']/h3/Strong")); 
		List<WebElement> caption = driver.findElements(By.xpath("//div[@class='col-md-8']/p"));
		
		
		int nameCount = name.size();
		int captionCount = caption.size();
		String[] nameValues = new String[name.size()];
		String[] captionValues = new String[caption.size()];	 
		int index = 0,index1 = 0;
		 
		for(int i=0,j=0; i<nameCount || j<captionCount; i++,j++)
		{
			String curName = name.get(i).getText();
			nameValues[index++] = curName;
			String curCaption = caption.get(j).getText();
			captionValues[index1++] = curCaption;			 
		 }
		erw.writetoExcel2(nameValues,captionValues);
		Thread.sleep(5000);
		
		
	}
	
	@AfterStep
	public void after(Scenario scenario){
		System.out.println(scenario);
	    final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	    scenario.embed(screenshot, "image/png");
	}
	
	@After
	public void teardown(){
		//driver.close();
	}
}
