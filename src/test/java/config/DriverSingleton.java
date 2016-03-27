package config;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by eugene on 26.03.2016.
 */
public class DriverSingleton {
    private static WebDriver driver = null;

    public WebDriver getDriver() {
        if(driver != null) {
            return driver;
        }
        driver = WebDriverFactory.creteDriver("firefox");  // need to do realization how configuration for choose browser  
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }

    public void tearDown(){
    	if(driver!=null){
    		driver.close();
    	}
    }
}
