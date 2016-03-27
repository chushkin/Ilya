package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 * Created by eugene on 26.03.2016.
 */
public class WebDriverFactory {

    static enum driverTypeEnum {
        FIREFOX("firefox"), CHROME("chrome"), IE("ie");


        private String driverName;

        driverTypeEnum(String name) {
            driverName = name;
        }

        public String getName() {
            return driverName;
        }
    }


    public static WebDriver creteDriver(String driverType) {
        WebDriver driver;
        if (driverType.equals(driverTypeEnum.FIREFOX.getName())) {
            return new FirefoxDriver();
        }
        if (driverType.equals(driverTypeEnum.CHROME.getName())) {
            return new ChromeDriver();
        }
        if (driverType.equals(driverTypeEnum.IE.getName())) {
            return new InternetExplorerDriver();
        }

        throw new RuntimeException("Cant' identify driver type: " + driverType);
    }


}


