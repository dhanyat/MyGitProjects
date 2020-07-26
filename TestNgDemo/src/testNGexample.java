
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class testNGexample {
    
    @Test
    public void testReport(){
        
        WebDriver driver=new FirefoxDriver();
        
        Reporter.log("Browser Opened");
        
        driver.manage().window().maximize();
        
        Reporter.log("Browser Maximized");
        
        driver.get("http://www.google.com");
        
        Reporter.log("Application started");
        
        driver.quit();
        
        Reporter.log("Application closed");
        
    }

}

